package com.gnt.qxgl.webservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbFjcl;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbLgApiLog;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXx;
import com.gnt.qxgl.hz2004.entity.zjyw.*;
import com.gnt.qxgl.job.YwtbXxJob;
import com.gnt.qxgl.service.Hz2004Service;
import com.gnt.qxgl.service.YwtbService;
import com.gnt.qxgl.webservice.bean.DwxxResult;
import com.gnt.qxgl.webservice.bean.ZjywReturnBean;
import net.coobird.thumbnailator.Thumbnails;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <功能概述> 长三角“一网通办”户籍事项证明服务，实现长三角地区跨省异地开具《户籍事项证明》。
 *
 * @author: 杨冬冬
 * @className: CsjYthYwtbWebService
 * @package: com.gnt.qxgl.webservice
 * @description: 介绍
 * @date: 2020-05-19 10:15
 */
public class YwtbWebService {
	/**
	 * 保存一网通接口调用日志
	 *
	 * @param log
	 */
	static private void saveLog(YwtbLgApiLog log) {
		YwtbService apiService = (YwtbService) SpringContainer.getObject("ywtbService");
		apiService.saveLog2(log);
	}

	// 缓存getDict的结果

	/**
	 * @param pcsbm
	 *            商户code
	 * @param md5
	 *            WEBSERVICE-API对应的口令MD5
	 * @param type
	 *            字典code
	 * @param code
	 *            所属id
	 * @return
	 */
	public String getDictValue(String pcsbm, String md5, String type, String code) {
		LgApiLog log = new LgApiLog();
		log.setApiname("getDictValue");
		log.setBz("type=" + type + code);
		log.setLgbm(pcsbm);
		log.setLogsj(new Date());
		String value = null;

		try {
			WebServiceUtil.checkUser(pcsbm, null, md5);
			String ip = WebServiceUtil.getIpaddress();
			log.setIp(ip);
			value = DictData.getCodeName(type, code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.setHs(new Date().getTime() - log.getLogsj().getTime());
		log.setSfcg("1");
		return value;
	}

	/**
	 * WebService 查询 单位信息表
	 *
	 * @param pcsbm
	 *            商户code
	 * @param md5
	 *            WEBSERVICE-API对应的口令MD5
	 * @param type
	 *            预留字段 传空字符串
	 * @param code
	 *            预留字段 传空字符串
	 * @return
	 */
	public String getDwxx(String pcsbm, String md5, String type, String code) {
		LgApiLog log = new LgApiLog();
		log.setApiname("getDictValue");
		log.setBz("type=" + type + code);
		log.setLgbm(pcsbm);
		log.setLogsj(new Date());
		String value = null;

		try {
			WebServiceUtil.checkUser(pcsbm, null, md5);
			String ip = WebServiceUtil.getIpaddress();
			log.setIp(ip);
			Hz2004Service apiService = (Hz2004Service) SpringContainer.getObject("hz2004Service");
			List<XtDwxxb> list = apiService.queryByHQL("from XtDwxxb order by dwjgdm ASC");
			List<DwxxResult> dwxxResults = new ArrayList<DwxxResult>();
			for (XtDwxxb dwxx : list) {
				DwxxResult dwxxResult = new DwxxResult();
				dwxxResult.setDm(dwxx.getDm());
				dwxxResult.setMc(dwxx.getMc());
				dwxxResults.add(dwxxResult);
			}
			value = WebServiceUtil.toJson(dwxxResults);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.setHs(new Date().getTime() - log.getLogsj().getTime());
		log.setSfcg("1");
		return value;
	}

	/**
	 * 接收长三角一网通平台传递数据 保存信息
	 * @param pcsbm 授权商户Code
	 * @param md5  授权密码 MD5加密
	 * @param type  类别
	 * @param json 具体信息 Json数据
	 * @return
	 */
	public String postYwtbHjzm(String pcsbm, String md5, String type, String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 日志记录
		YwtbLgApiLog log = new YwtbLgApiLog();
		log.setApiname("postYwtbHjzm");
		log.setLgbm(pcsbm);
		log.setLogsj(new Date());
		String applyno = "";
		try {
			// 判断商户Code
			WebServiceUtil.ywtbCheckUser(pcsbm, null, md5);
			// 获取请求的ip
			String ip = WebServiceUtil.getIpaddress();
			log.setIp(ip);
			// 解析json数据
			JSONObject jsonObj = JSON.parseObject(json);
			// 获取到formData
			JSONObject formData = jsonObj.getJSONObject("formdata");
			// 用户返回的applyno
			applyno = formData.getString("applyNo");
			// 进行数据保存，josn解析
			getSaveToJson(formData);
			// 请求成功返回
			log.setBz("json=" + applyno);
			map.put("success", true);
			map.put("msg", "数据接收成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.setBz("error=" + e.toString());
			// 请求失败返回
			map.put("success", false);
			map.put("msg", "数据接收失败");
			map.put("error", e.toString());
		}
		map.put("applyNo", applyno);
		log.setHs(new Date().getTime() - log.getLogsj().getTime());
		Boolean success = (Boolean) map.get("success");
		log.setSfcg(success ? "1" : "0");
		// 保存日志
		saveLog(log);
		return WebServiceUtil.toJson(map);
	}

	/**
	 * 长三角一网通平台查询数据 保存信息
	 *
	 * @param pcsbm
	 *            授权商户Code
	 * @param md5
	 *            授权密码 MD5加密
	 * @param bljg
	 *            办理结果
	 * @param isstatus
	 *            推送状态
	 * @return
	 */
	public String getYwtbXx(String pcsbm, String md5, String bljg, String isstatus, int pageIndex, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 日志记录
		YwtbLgApiLog log = new YwtbLgApiLog();
		log.setApiname("getYwtbXx");
		log.setLgbm(pcsbm);
		log.setLogsj(new Date());
		try {
			// 判断商户Code
			WebServiceUtil.ywtbCheckUser(pcsbm, null, md5);
			// 获取请求的ip
			String ip = WebServiceUtil.getIpaddress();
			log.setIp(ip);
			Map<String, Object> mapParam = new HashMap<String, Object>();
			// 更改后不需要根据办理结果查询 办理结果通过不通过都要返回
			// mapParam.put("bljg", bljg);
			mapParam.put("isstatus", isstatus);
			// 获取到ywtbService
			YwtbService apiService = (YwtbService) SpringContainer.getObject("ywtbService");
			Page page = apiService.queryYwtbXxJob(mapParam, pageIndex, pageSize);
			List<YwtbXx> list = page.getList();
			List<YwtbXxJob> listJob = new ArrayList<YwtbXxJob>();
			for (YwtbXx ywtbXx : list) {
				ywtbXx.setIsstatus("1");
				apiService.updateYwtbXx(ywtbXx);

				YwtbXxJob ywtbXxJob = new YwtbXxJob();
				ywtbXxJob.setApplyno(ywtbXx.getApplyno());
				ywtbXxJob.setBljg(ywtbXx.getBljg());
				ywtbXxJob.setBlyj(ywtbXx.getBlyj());
				ywtbXxJob.setBlBmcode(ywtbXx.getBlBmcode());
				ywtbXxJob.setBlBmName(ywtbXx.getBlBmName());
				 ywtbXxJob.setBlFile(new String(ywtbXx.getBlFile()));//2021-4-2 kqt 放开注释 为什么要注释？
				
				listJob.add(ywtbXxJob);
			}
			map.put("success", true);
			map.put("msg", "数据接收成功");
			map.put("list", listJob);

		} catch (Exception e) {
			e.printStackTrace();
			log.setBz("error=" + e.toString());
			// 请求失败返回
			map.put("success", false);
			map.put("msg", "数据查询失败");
			map.put("error", e.toString());
		}
		log.setHs(new Date().getTime() - log.getLogsj().getTime());
		Boolean success = (Boolean) map.get("success");
		log.setSfcg(success ? "1" : "0");
		// 保存日志
		saveLog(log);

		return WebServiceUtil.toJson(map);
	}

	/**
	 * 解析Json数据 保存数据
	 *
	 * @param formData
	 */
	private void getSaveToJson(JSONObject formData) {
		YwtbXx ywtbXx = JSONObject.toJavaObject(formData, YwtbXx.class);
		// 获取kjfw
		JSONObject kjfw = formData.getJSONObject("kjfw");
		String kjfwValue = kjfw.getString("value");
		ywtbXx.setKjfw(kjfwValue);
		// 获取lqfs
		JSONObject lqfs = formData.getJSONObject("lqfs");
		String lqfsValue = lqfs.getString("value");
		ywtbXx.setLqfs(lqfsValue);
		ywtbXx.setIsstatus("0");//0是从政务网接收1是从互联网前置机推送到公安网2是公安网办结3是公安网推送到互联网前置机4是互联网推送到政务网 5是推送失败
//		ywtbXx.setBlFile(Base64.decode(formData.getString("blFile")));
		ywtbXx.setCjsj(new Date());
		System.out.println("-----------开始保存YwtbXx------------");
		// 获取到ywtbService
		YwtbService apiService = (YwtbService) SpringContainer.getObject("ywtbService");
		// 执行保存ywtbXx
		apiService.saveYwtbXx(ywtbXx);
		// 获取附件材料
		JSONArray archivesdata = formData.getJSONArray("archivesdata");
		for (int i = 0; i < archivesdata.size(); i++) {
			System.out.println("--------开始解析附件材料--------");
			JSONObject archivesdataObj = archivesdata.getJSONObject(i);
			System.out.println(archivesdataObj.toString());
			YwtbFjcl ywtbFjcl = new YwtbFjcl();
			System.out.println("295新建附件材料对象");
			String stuffcode = archivesdataObj.getString("stuffcode");
			String needflag = archivesdataObj.getString("needflag");
			String stuffname = archivesdataObj.getString("stuffname");
			String filetype = archivesdataObj.getString("filetype");
			// String filename = archivesdataObj.getString("filename");
			// String stuffid = archivesdataObj.getString("stuffid");
			String stufffile = archivesdataObj.getString("stufffile");
			// ywtbFjcl.setFilename(filename);
			System.out.println("304新建附件材料对象开始赋值");
			ywtbFjcl.setNeedflag(needflag);
			ywtbFjcl.setStuffname(stuffname);
			ywtbFjcl.setStuffcode(stuffcode);
			// ywtbFjcl.setStuffid(stuffid);
			ywtbFjcl.setFiletype(filetype);
			String base64 = "";

			String isGaStatus = SystemConfig.getSystemConfig("isGaStatus");
			System.out.println("313开始解析文件");
			System.out.println("isGaStatus" + isGaStatus);
			System.out.println("315文件长度："+stufffile.length());
			if (filetype != null && filetype.contains("pdf") && !isGaStatus.equals("true")) {
				System.out.println("--------开始解析附件材料 stufffile 为pdf--------" + stufffile);
				// 对字节数组Base64编码
				BASE64Decoder base64Decoder = new BASE64Decoder();
				byte[] bytes = null;
				try {
					// 将pdf base64 转byte
					System.out.println("311将pdf base64 转byte");
					bytes = base64Decoder.decodeBuffer(stufffile);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 将pdf 转byte 转 图片 byte
//				byte[] bytes1 = ImageToPdf.pdf2img(bytes);
				// 对字节数组Base64编码
//				BASE64Encoder encoder = new BASE64Encoder();
				// 返回Base64编码过的字节数组字符串
//				base64 = encoder.encode(bytes1);
				System.out.println("322开始赋值文件");
				ywtbFjcl.setStufffile(bytes);
			} else {
				System.out.println("--------开始解析附件材料 stufffile 为jpg-------" + stufffile);
				// 返回Base64编码过的字节数组字符串
				// 对字节数组Base64编码
				// 返回Base64编码过的字节数组字符串
				BufferedImage src = base64String2BufferedImage(stufffile);
				try {
					BufferedImage output = Thumbnails.of(src).size(700, 800).asBufferedImage();
					base64 = imageToBase64(output);
					ywtbFjcl.setStufffile(base64.getBytes());
					System.out.println("342文件长度："+stufffile.length());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			ywtbFjcl.setApplyno(ywtbXx.getApplyno());
			ywtbFjcl.setCjsj(new Date());
			System.out.println("--------参数解析完成开始保存--------");
			apiService.saveYwtbFjcl(ywtbFjcl);
		}

	}

	/**
	 * 准迁证信息接收 准迁证迁移人信息接收
	 *
	 * @param pcsbm
	 *            授权商户Code
	 * @param md5
	 *            授权密码 MD5加密
	 * @param type
	 *            入住记录类型：1 内宾，2 外宾
	 * @param json
	 *            内/外宾入组记录的JSON编码，编码格式见文档说明。
	 * @return 返回处理结果的JSON，格式如下： { "success": "true|false之一，表示成功或者失败",
	 *         "message":"错误消息", "postid":"json数据包含的用户第三方ID值，用于返回对应",
	 *         "lkbm":"如果成功，那么返回入住流水号，必须回填此流水号，退房或者修改入住信息必须使用此凭证" }
	 */
	public String postZqzxxRecrod(String pcsbm, String md5, String type, String json) {
		YwtbLgApiLog log = new YwtbLgApiLog();
		log.setApiname("postZqzxxRecrod");
		log.setBz("type=" + type + json);
		log.setLgbm(pcsbm);
		log.setLogsj(new Date());

		ZjywReturnBean re = new ZjywReturnBean();
		try {
			// 判断商户Code
			WebServiceUtil.ywtbCheckUser(pcsbm, null, md5);

			String ip = WebServiceUtil.getIpaddress();
			log.setIp(ip);
			Hz2004Service hz2004Service = (Hz2004Service) SpringContainer.getObject("hz2004Service");
			// NwbService nwbService = (NwbService)SpringContainer.getObject("nwbservice");
			// 解析XML文件
			ZjywReturnBean zjywReturnBean = parseGetXml(json, ip, pcsbm, type, hz2004Service);

			// re = postZqzxxRecrods(ip, pcsbm, type, hz2004Service, obj);
		} catch (Exception e) {
			re.setMessage(e.getMessage());
			re.setSuccess(false);
		}
		log.setHs(new Date().getTime() - log.getLogsj().getTime());
		log.setSfcg(re.isSuccess() ? "1" : "0");
		try {
			saveLog(log);
		} catch (Exception e) {
			;
		}

		return WebServiceUtil.toJson(re);
	}

	/**
	 * 解析参数XML文件
	 *
	 * @param xml
	 *            xml参数
	 * @param ip
	 *            ip
	 * @param pcsbm
	 *            编码
	 * @param type
	 * @param nwbService
	 */
	private ZjywReturnBean parseGetXml(String xml, String ip, String pcsbm, String type, Hz2004Service nwbService) {
		InputSource source = new InputSource(new StringReader(xml));
		SAXReader reader = new SAXReader();
		Document document1 = null;
		ZjywReturnBean re = null;
		try {
			document1 = reader.read(source);

			// 获取根节点属性对象
			Element rootElem = document1.getRootElement();
			// 显示根节点的名字
			System.out.println("节点名字" + rootElem.getName());
			// 获取head节点属性对象
			Element headElem = rootElem.element("head");
			List<Element> elements = headElem.elements();
			String zqzbh = null;
			String qyzbh = null;
			for (Iterator<Element> it = elements.iterator(); it.hasNext();) {
				Element element = it.next();
				// 循环获取属性名
				String conAttrName = element.getName();
				String conTxt = element.getStringValue();
				// 判断是准迁证还是迁移证
				if (conAttrName == "zqzbh") {
					// 获取改属性的值
					System.out.println(conAttrName + " = " + conTxt);
					zqzbh = conTxt;
				}
				if (conAttrName == "qyzbh") {
					System.out.println(conAttrName + " = " + conTxt);
					qyzbh = conTxt;

				}
			}
			Class zqzQyzxx = null;
			Object stuInstance = null;
			Class qyrXx = null;
			Object qyrxxInstance = null;
			List qyrxx = new ArrayList();
			// 判断准迁证和迁移证哪个不为空，则创建哪个实体类的实例
			if (zqzbh != null) {
				// 1.反射，得到类的引用
				zqzQyzxx = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzxx");
				// 通过类的引用，得到类的对象
				stuInstance = zqzQyzxx.newInstance();

				// 1.反射，得到类的引用
				qyrXx = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzQyrxx");
				// 通过类的引用，得到类的对象
				qyrxxInstance = qyrXx.newInstance();
			}
			if (qyzbh != null) {
				// 1.反射，得到类的引用
				zqzQyzxx = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxx");
				// 通过类的引用，得到类的对象
				stuInstance = zqzQyzxx.newInstance();

				// 1.反射，得到类的引用
				qyrXx = Class.forName("com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxxQyrxx");
				// 通过类的引用，得到类的对象
				qyrxxInstance = qyrXx.newInstance();
			}

			// 获取body节点属性对象 准迁证信息
			Element bodyElem = rootElem.element("body");
			List<Element> bodyElements = bodyElem.elements();
			for (Iterator<Element> it = bodyElements.iterator(); it.hasNext();) {
				Element element = it.next();
				// 分别每个节点的名字
				String conAttrName = element.getName();
				if ("qyr".equals(conAttrName)) {
					break;
				}
				// 分别每个节点的值内容
				String conTxt = element.getStringValue();
				// 通过elemetname得到对应的get set方法，先拼接出方法名，比如 name--setName
				String funName = "set" + (conAttrName.charAt(0) + "").toUpperCase() + conAttrName.substring(1);
				// 通过方法名反射出方法对象
				Method method1 = zqzQyzxx.getDeclaredMethod(funName, String.class);
				// 通过反射调用方法，调用stuInstance对象的method方法，参数为stuData---给各属性赋值
				method1.invoke(stuInstance, conTxt);
			}
			// 遍历qyr节点的所有属性 迁移人
			List<Element> qyrElem = bodyElem.elements("qyr");
			for (Iterator<Element> it = qyrElem.iterator(); it.hasNext();) {
				Element element = it.next();
				List<Element> qyrElements = element.elements();

				for (Element qyrElement : qyrElements) {
					// 遍历某个节点的所有属性
					String conAttrName = qyrElement.getName();
					// 分别获取每个节点的值内容
					String conTxt = qyrElement.getStringValue();
					System.out.println(conAttrName + " = " + conTxt);
					// 通过elemetname得到对应的get set方法，先拼接出方法名，比如 name--setName
					String funName = "set" + (conAttrName.charAt(0) + "").toUpperCase() + conAttrName.substring(1);
					// 通过方法名反射出方法对象
					Method method1 = qyrXx.getDeclaredMethod(funName, String.class);
					// 通过反射调用方法，调用stuInstance对象的method方法，参数为stuData---给各属性赋值
					method1.invoke(qyrxxInstance, conTxt);
				}
				// 添加到集合中
				qyrxx.add((ZjywZqzQyrxx) qyrxxInstance);
			}

			if (zqzbh != null) {
				re = postZqzxxRecrods(ip, pcsbm, type, nwbService, (ZjywZqzxx) stuInstance, qyrxx);
			}

			if (qyzbh != null) {
				re = postQyzxxRecrods(ip, pcsbm, type, nwbService, (ZjywQyzxx) stuInstance, qyrxx);
			}

			// 创建文档。
			Document document = DocumentHelper.createDocument();
			// 文档增加节点，即根节点，一个文档只能有一个根节点，多加出错
			Element root = document.addElement("root");
			// 根节点下添加节点head
			Element head = root.addElement("head");
			// 节点添加属性
			head.addAttribute("sjblx", "010122");
			head.addAttribute("ywlsh", "123456");
			head.addAttribute("zqzbh", "123456767");
			head.addAttribute("qyzbh", "");
			head.addAttribute("license", "2222222");
			head.addAttribute("code", "11");
			head.addAttribute("msg", "对方已收到");
			String result = document.asXML();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	/**
	 * 准迁证信息接收 准迁证迁移人信息接收 保存或者修改的通用方法
	 *
	 * @param ip
	 * @param pcsbm
	 * @param type
	 * @param nwbService
	 * @param bean
	 * @return
	 */
	private ZjywReturnBean postZqzxxRecrods(String ip, String pcsbm, String type, Hz2004Service nwbService,
			ZjywZqzxx zjywZqzxx, List zqzQyrxxList) {

		String ywlsh = null;
		ZjywReturnBean re = new ZjywReturnBean();
		try {
			ywlsh = zjywZqzxx.getYwlsh();

			// 下面模拟nwbaction里面的流程，保持nwbservice的业务流程不变
			boolean c_u = true;
			// 判断数据库是否已经记录过此记录KEY
			ZjywZqzxx zjywZqzxx1 = nwbService.queryZjywZqzxxByPostid(ywlsh);
			if (zjywZqzxx1 != null) {
				// 如果有，那么修改原记录(用户不带，那么智能判断)
				c_u = false;
			}

			if (c_u) {
				nwbService.saveZjywZqzxx(zjywZqzxx, pcsbm);
				// 执行for循环
				for (Object obj : zqzQyrxxList) {
					ZjywZqzQyrxx zqz = (ZjywZqzQyrxx) obj;
					zqz.setYwlsh(ywlsh);
					nwbService.saveZjywZqzQyrxx(zqz);
				}
			} else {
				ZjywZqzxx oldnb = nwbService.queryZjywZqzxxByPostid(ywlsh);
				if (oldnb == null) {
					throw new Exception("业务流水号[" + zjywZqzxx.getPostid() + "]不存在！");
				}

				nwbService.updateZjywZqzxx(zjywZqzxx);
			}
			re.setSuccess(true);
		} catch (Exception e) {
			re.setSuccess(false);
			re.setMessage(e.getMessage());
		}
		re.setYwlsh(ywlsh);
		return re;
	}

	/**
	 * 准迁证信息接收 准迁证迁移人信息接收 保存或者修改的通用方法
	 *
	 * @param ip
	 * @param pcsbm
	 * @param type
	 * @param nwbService
	 * @param bean
	 * @return
	 */
	private ZjywReturnBean postQyzxxRecrods(String ip, String pcsbm, String type, Hz2004Service nwbService,
			ZjywQyzxx zjywQyzxx, List zqzQyrxxList) {

		String ywlsh = null;
		ZjywReturnBean re = new ZjywReturnBean();
		try {
			ywlsh = zjywQyzxx.getYwlsh();

			// 下面模拟nwbaction里面的流程，保持nwbservice的业务流程不变
			boolean c_u = true;
			// 判断数据库是否已经记录过此记录KEY
			ZjywZqzxx zjywZqzxx1 = nwbService.queryZjywZqzxxByPostid(ywlsh);
			if (zjywZqzxx1 != null) {
				// 如果有，那么修改原记录(用户不带，那么智能判断)
				c_u = false;
			}

			if (c_u) {
				nwbService.saveZjywQyzxx(zjywQyzxx, pcsbm);
				// 执行for循环
				for (Object obj : zqzQyrxxList) {
					ZjywQyzxxQyrxx qyz = (ZjywQyzxxQyrxx) obj;
					qyz.setYwlsh(zjywQyzxx.getYwlsh());
					nwbService.saveZjywQyzQyrxx(qyz);
				}
			} else {
				ZjywQyzxx oldnb = nwbService.queryZjywQyzxxByPostid(ywlsh);
				if (oldnb == null) {
					throw new Exception("业务流水号[" + zjywZqzxx1.getPostid() + "]不存在！");
				}

				nwbService.updateZjywQyzxx(zjywQyzxx);
			}
			re.setSuccess(true);
		} catch (Exception e) {
			re.setSuccess(false);
			re.setMessage(e.getMessage());
		}
		re.setYwlsh(ywlsh);
		return re;
	}

	/*    *//**
			 * 迁移证信息接收 迁移证迁移人信息接收
			 *
			 * @param pcsbm
			 *            派出所编码
			 * @param md5
			 *            旅馆WEBSERVICE-API对应的口令MD5
			 * @param type
			 *            入住记录类型：1 内宾，2 外宾
			 * @param json
			 *            内/外宾入组记录的JSON编码，编码格式见文档说明。
			 * @return 返回处理结果的JSON，格式如下： { "success": "true|false之一，表示成功或者失败",
			 *         "message":"错误消息", "postid":"json数据包含的用户第三方ID值，用于返回对应",
			 *         "lkbm":"如果成功，那么返回入住流水号，必须回填此流水号，退房或者修改入住信息必须使用此凭证" }
			 *//*
				 * public String postQyzxxRecrod(String pcsbm, String md5, String type, String
				 * json) { YwtbLgApiLog log = new YwtbLgApiLog();
				 * log.setApiname("postQyzxxRecrod"); log.setBz("type=" + type + json);
				 * log.setLgbm(pcsbm); log.setLogsj(new Date());
				 * 
				 * ZjywReturnBean re = new ZjywReturnBean(); try { //判断商户Code
				 * WebServiceUtil.ywtbCheckUser(pcsbm, null, md5);
				 * 
				 * String ip = WebServiceUtil.getIpaddress(); log.setIp(ip); Hz2004Service
				 * hz2004Service = (Hz2004Service) SpringContainer.getObject("hz2004Service");
				 * //NwbService nwbService =
				 * (NwbService)SpringContainer.getObject("nwbservice");
				 * 
				 * ZjywQyzQyryxxBean obj = WebServiceUtil.getJsonData(ZjywQyzQyryxxBean.class,
				 * json);
				 * 
				 * re = postQyzxxRecrods(ip, pcsbm, type, hz2004Service, obj); } catch
				 * (Exception e) { re.setMessage(e.getMessage()); re.setSuccess(false); }
				 * 
				 * log.setHs(new Date().getTime() - log.getLogsj().getTime());
				 * log.setSfcg(re.isSuccess() ? "1" : "0"); try { saveLog(log); } catch
				 * (Exception e) { ; }
				 * 
				 * return WebServiceUtil.toJson(re); }
				 */

	/* *//**
			 * 迁移证信息接收 迁移证迁移人信息接收 保存或者修改的通用方法
			 *
			 * @param ip
			 * @param pcsbm
			 * @param type
			 * @param nwbService
			 * @param bean
			 * @return
			 *//*
				 * private ZjywReturnBean postQyzxxRecrods(String ip, String pcsbm, String type,
				 * Hz2004Service nwbService, ZjywQyzQyryxxBean bean) {
				 * 
				 * 
				 * String ywlsh = null; ZjywReturnBean re = new ZjywReturnBean(); String postid
				 * = null; ZjywQyzxx lk = null; try {
				 * 
				 * postid = bean.getQyzbh();
				 * 
				 * ywlsh = bean.getYwlsh();
				 * 
				 * //下面模拟nwbaction里面的流程，保持nwbservice的业务流程不变 boolean c_u = true;
				 * 
				 * //如果第三方没有带业务流水号，那么默认为新增 if (CommonUtil.isNotEmpty(ywlsh)) { c_u = false; }
				 * else { //判断数据库是否已经记录过此记录KEY ApiYs ys = nwbService.getApiYsByPostid(pcsbm,
				 * type, postid); if (ys != null) { //如果有，那么修改原记录(用户不带，那么智能判断) c_u = false;
				 * bean.setYwlsh(ys.getLkbm()); } }
				 * 
				 * //将nbbean转换为lknb对象
				 * 
				 * lk = WebServiceUtil.getQyzxx(nwbService, ip, pcsbm, bean);
				 * List<ZjywQyzxxQyrxx> listQyrxx = bean.getQyrxx(); if (c_u) {
				 * nwbService.saveZjywQyzxx(lk, pcsbm);//saveNb(nb, postid); //执行for循环 for
				 * (ZjywQyzxxQyrxx qyz : listQyrxx) { qyz.setYwlsh(lk.getYwlsh());
				 * nwbService.saveZjywQyzQyrxx(qyz); } } else { ZjywQyzxx oldnb =
				 * nwbService.queryZjywQyzxxByPostid(postid); if (oldnb == null) { throw new
				 * Exception("业务流水号[" + lk.getYwlsh() + "]不存在！"); }
				 * 
				 * nwbService.updateZjywQyzxx(lk); }
				 * 
				 * //返回设置流水号 re.setPostid(postid); re.setSuccess(true);
				 * re.setYwlsh(lk.getYwlsh()); } catch (Exception e) { re.setSuccess(false);
				 * re.setMessage(e.getMessage()); re.setPostid(postid);
				 * //如果是修改，那么在异常之后，还需要添加上旅客编码 if (CommonUtil.isEmpty(re.getPostid()) &&
				 * CommonUtil.isNotEmpty(re.getYwlsh())) { re.setYwlsh(lk.getYwlsh()); } }
				 * 
				 * 
				 * return re; }
				 */

	/**
	 * @param pcsbm
	 *            商户code
	 * @param md5
	 *            WEBSERVICE-API对应的口令MD5
	 * @param name
	 *            姓名
	 * @param gmsfhm
	 *            身份证
	 * @param dqbm
	 *            地区编码
	 * @return
	 */
	public Boolean postUpdateZp(String pcsbm, String md5, String name, String gmsfhm, String dqbm) {
		LgApiLog log = new LgApiLog();
		log.setApiname("getDictValue");
		log.setBz("type=" + dqbm + name + gmsfhm);
		log.setLgbm(pcsbm);
		log.setLogsj(new Date());
		String value = null;
		Boolean sfcg = false;
		try {
			WebServiceUtil.checkUser(pcsbm, null, md5);
			String ip = WebServiceUtil.getIpaddress();
			log.setIp(ip);
			Hz2004Service hz2004Service = (Hz2004Service) SpringContainer.getObject("hz2004Service");
			sfcg = hz2004Service.postUpdateZp(name, gmsfhm, dqbm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.setHs(new Date().getTime() - log.getLogsj().getTime());
		log.setSfcg("1");
		return sfcg;
	}

	/**
	 * 获取未来 第 past 天的日期
	 *
	 * @param past
	 *            传递int 为几 就加几天
	 * @return
	 */
	public static String getFetureDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		System.out.println(result);
		return result;
	}

	/**
	 * base64转换成BufferedImage:
	 * 
	 * @param base64string
	 * @return
	 */
	public static BufferedImage base64String2BufferedImage(String base64string) {
		BufferedImage image = null;
		try {
			InputStream stream = BaseToInputStream(base64string);
			image = ImageIO.read(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * Base64转换成InputStream:
	 * 
	 * @param base64string
	 * @return
	 */
	private static InputStream BaseToInputStream(String base64string) {
		ByteArrayInputStream stream = null;
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes1 = decoder.decodeBuffer(base64string);
			stream = new ByteArrayInputStream(bytes1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stream;
	}

	/**
	 * BufferedImage转换成base64，在这里需要设置图片格式，如下是jpg格式图片：
	 * 
	 * @param bufferedImage
	 * @return
	 */
	public static String imageToBase64(BufferedImage bufferedImage) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(bufferedImage, "jpg", baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(baos.toByteArray());
	}
}
