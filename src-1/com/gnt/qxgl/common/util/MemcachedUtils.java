package com.gnt.qxgl.common.util;

import java.io.Serializable;
import java.util.Date;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.exception.ActionException;

/**
 * 缓存操作类
 * @author ting_it
 *
 */
public class MemcachedUtils {
	static Logger logger = Logger.getLogger(MemcachedUtils.class);
	
	static private MemCachedClient mcc = null;
	
	public static MemCachedClient getInstance(){
        return mcc;
    }
	
	static final public  int session_timeout = Integer.parseInt(SystemConfig.getSystemConfig("SESSION_TIMEOUT", "30"))*60*1000;
	
	/**
	 * 初始化本地会话的Memcached对象
	 */
	static{
		BasicConfigurator.configure();
		String s =  SystemConfig.getSystemConfig("MemCached.ServerList", "127.0.0.1:11211");
		String[] servers = { s };
		
		SockIOPool pool = SockIOPool.getInstance();
	    // 获取socke连接池的实例对象
	    // 这个类用来创建管理客户端和服务器通讯连接池，
	    // 客户端主要的工作（包括数据通讯、服务器定位、hash码生成等）都是由这个类完成的。
	    // 设置服务器信息
	    pool.setServers(servers);
	    // 设置Server权重, 和service一致
	    //pool.setWeights(new Integer[]{3});
	    // 设置初始连接数、最小和最大连接数以及最大处理时间
	    pool.setInitConn(Integer.parseInt(SystemConfig.getSystemConfig("MemCached.InitConn", "10")));
	    pool.setMinConn(Integer.parseInt(SystemConfig.getSystemConfig("MemCached.MinConn", "5")));
	    pool.setMaxConn(Integer.parseInt(SystemConfig.getSystemConfig("MemCached.MaxConn", "100")));
	    pool.setMaxIdle(Integer.parseInt(SystemConfig.getSystemConfig("MemCached.MaintSleep", "30000")));
	    
	    // 设置主线程的睡眠时间
	    pool.setMaintSleep(30);
	    
	    // 设置连接心跳监测开关
	    // true:每次通信都要进行连接是否有效的监测，造成通信次数倍增，加大网络负载，
	    // 因此在对HighAvailability要求比较高的场合应该设为true
	    // 默认状态是false，建议保持默认。
	    pool.setAliveCheck(false);
	    
	    // 设置连接失败恢复开关
	    // 设置为true，当宕机的服务器启动或中断的网络连接后，这个socket连接还可继续使用，否则将不再使用.
	    // 默认状态是true，建议保持默认。
	    pool.setFailback(true);
	    
	    // 设置容错开关
	    // true:当当前socket不可用时，程序会自动查找可用连接并返回，否则返回NULL
	    // 默认状态是true，建议保持默认。
	    pool.setFailover(true);
	    
	    // 设置hash算法
	    // alg=0 使用String.hashCode()获得hash code,该方法依赖JDK，可能和其他客户端不兼容，建议不使用
	    // alg=1 使用original 兼容hash算法，兼容其他客户端
	    // alg=2 使用CRC32兼容hash算法，兼容其他客户端，性能优于original算法
	    // alg=3 使用MD5 hash算法
	    // 采用前三种hash算法的时候，查找cache服务器使用余数方法。采用最后一种hash算法查找cache服务时使用consistent方法。
	    // 默认值为0
	    pool.setHashingAlg(2);
	    
	    // 设置是否使用Nagle算法，因为我们的通讯数据量通常都比较大（相对TCP控制数据）而且要求响应及时，
	    // 因此该值需要设置为false（默认是true）
	    pool.setNagle(false);
	     
	    // 设置socket的读取等待超时值（单位毫秒）
	    pool.setSocketTO(Integer.parseInt(SystemConfig.getSystemConfig("MemCached.SocketTO", "3000")));
	     
	    // 设置socket的连接等待超时值
	    pool.setSocketConnectTO(Integer.parseInt(SystemConfig.getSystemConfig("MemCached.SocketConnectTO", "60000")));
	    
	    // 初始化连接池
	    pool.initialize();
	    
	    // 压缩设置，超过指定大小（单位为K）的数据都会被压缩
	    // mcc.setCompressEnable(true);  //UnsupportedOperation
	    // mcc.setCompressThreshold(64 * 1024);
		
		System.out.print("Memcached 初始化：" + s + "...");
		
		mcc = new MemCachedClient();
		if(!mcc.set("test", "1")){
			System.out.println("缓存池异常！");
		}else{
			System.out.println("成功！");
		}
	}
	
	/**
	 * 向当前会话中写入键值对
	 * @param key
	 * @param value
	 * @return
	 */
	static public boolean setSessionValue(String sid, String key, Serializable value){
		BaseUser session = MemcachedUtils.getSessionInfo(sid);
		if(session==null)
			return false;
		
		session.getSessionMap().put(key, value);
		
		return MemcachedUtils.setSessionInfo(session);
	}
	
	/**
	 * 向当前会话中写入会话对象
	 * @param session
	 * @return
	 */
	static public boolean setSessionInfo(BaseUser session){
		boolean b = mcc.set(session.getSid(), session,new Date(session_timeout));
		if(!b)
			throw new ActionException("缓存失败，请检查！");
		
		return b;
	}
	
	/**
	 * 获取SESSION会话的所有KEY/VALUE值
	 * @param sid
	 * @return
	 */
	static public BaseUser getSessionInfo(String sid){
		if(sid==null)
			return null;
		
		BaseUser info = (BaseUser)mcc.get(sid);
		
		if(info==null)
			return null;
		
		//回写新的生命期，防止过期
		boolean b = mcc.set(sid, info, new Date(session_timeout));
		if(!b)
			throw new ActionException("缓存失败，请检查！");
		
		//写入身份标识
		info.setSid(sid);
		
		return info;
	}
	
	/**
	 * 写入永不过期的键值对，慎用此方法
	 * @param key
	 * @param value
	 * @return
	 */
	static public boolean setValue(String key,Object value){
		boolean b= mcc.set(key, value);
		if(!b)
			throw new ActionException("缓存失败，请检查！");
		return b;
	}
	
	/**
	 * 仅仅获取键值对
	 * @param key
	 * @return
	 */
	static public Object getValue(String key){
		return mcc.get(key);
	}
	
	/**
	 * 写入带生命期的键值对
	 * @param key		键值
	 * @param value	写入的对象
	 * @param expiry	生命期，单位秒
	 * @return
	 */
	static public boolean setValue(String key,Object value,int expiry){
		boolean b= mcc.set(key, value, new Date(expiry*1000));
		if(!b)
			throw new ActionException("缓存失败，请检查！");
		return b;
	}
	
	/**
	 * 判断KEY是否存在
	 * @param key
	 * @return
	 */
	static public boolean existsKey(String key){
		return mcc.keyExists(key);
	}
	
	/**
	 * 从缓存中删除指定键值的对象
	 * @param key
	 * @return
	 */
	static public boolean removeKey(String key){
		return mcc.delete(key);
	}
}
