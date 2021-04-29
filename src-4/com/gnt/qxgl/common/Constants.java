package com.gnt.qxgl.common;

public interface Constants {
	public class MEMCACHED_ATTR{
		static final public String SID_ATTR = "_SID_";
		static final public String DICT_SEARCH_ATTR = "_DICT_SEARCH_";
		static final public String DICT_SJPZB_ATTR = "_DICT_SJPZB_";
		static final public String DICT_SEARCH_ALL_ATTR = "_DICT_SEARCH_ALL";
	}
	
	/**
	 * 跟节点行政区划
	 */
	static final public String ROOT_XZQH = "_ROOT";
	
	/**
	 * 身份标识在上下文中的名称
	 */
	static final public String COOKIE_SID = "memsid";
	
	/**
	 * 上下文的用户KEY
	 */
	static final public String USER_ATTRNAME = "_user";
	
	/**
	 * SID的有效期设置cookie有效期是一天
	 */
	static final public int cookieMaxAge = 60 * 60 * 24;
	
	/**
	 * 省厅
	 */
    public static final String DWLX_ST = "ST";
    /**
     * 市局
     */
    public static final String DWLX_SJ = "SJ";
    /**
     * 区分局
     */
    public static final String DWLX_QFJ = "QFJ";
    /**
     * 县局
     */
    public static final String DWLX_XJ = "XJ";
    /**
     * 市劳教委员会
     */
    public static final String DWLX_SLJWYH = "SLJWYH";
    /**
     * 劳教科
     */
    public static final String DWLX_LJK = "LJK";
    /**
     * 派出所
     */
    public static final String DWLX_PCS = "PCS";
    /**
     * 中队
     */
    public static final String DWLX_ZD = "ZD";
    /**
     * 大队
     */
    public static final String DWLX_DD = "DD";
    /**
     * 科室
     */
    public static final String DWLX_KS = "KS";
    /**
     * 处
     */
    public static final String DWLX_C = "C";
    /**
     * 支队
     */
    public static final String DWLX_ZHIDUI = "ZHIDUI";
    /**
     * 总队
     */
    public static final String DWLX_ZONGDUI = "ZONGDUI";
    
    
    /**
     * 页面跳转参数名称
     */
    public static final String ParameterGOTO = "goto_url";
}
