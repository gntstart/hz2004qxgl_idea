package com.gnt.qxgl.base;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.bean.SimpleJson;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.common.struts.action.ExtCommonAction;
import com.gnt.qxgl.common.struts.form.CommonForm;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.ExtUtils;

public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ERROR_MESSAGE = "_error";
	public static final String FILE_INFO = "_file_info";
	public static final String RE_MAP = "_re_Map";
	public static String ROOT_PATH = null;
	
	// 附件字符串的类参数名
	public static final String FILE_CLASSNAME = "className";
	// 附件字符串的ID参数名
	public static final String FILE_ID = "id";
	// 附件字符串的文件参数名
	public static final String FILE_NAME = "file";
	// 附件字符串的文件长度参数名
	public static final String FILE_SIZE = "size";
	// 附件字符串的文件上传区域参数名
	public static final String FILE_FIELD = "field";
	// 附件字符串的文件扩展名参数名
	public static final String FILE_EXT = "ext";
	// className=className&file=filename&size=len&field=fileItem&ext=ext
	
	private Logger logger = Logger.getLogger(getClass());

	public void init(ServletConfig config) throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(config.getServletContext());
		SpringContainer.setFactory(ac);
	}
	
	protected void importXlsfile(String importType,HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String filename = "";	
		if(CommonUtil.isNotEmpty(importType)){

		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String type = req.getParameter("type");
		/*
		if (CommonUtil.isNotEmpty(type)) {
			if("yhtx".equals(type)){
				String id = req.getParameter("id");
				ZzjyManagerService uf = (ZzjyManagerService) SpringContainer.getObject("zzjyManagerService");
				byte[] qm = uf.getZzjyTx(id);
				if(qm==null){
					req.getRequestDispatcher("/images/no_pic.gif").forward(req, resp);
				}else{
					resp.getOutputStream().write(qm);
					resp.getOutputStream().flush();
				}
			}
			if("dwgz".equals(type) || "jzy".equals(type)){
				String id = req.getParameter("id");
				ZzjyManagerService uf = (ZzjyManagerService) SpringContainer.getObject("zzjyManagerService");
				byte[] qm = uf.getZzjgImg(type,id);
				if(qm==null){
					req.getRequestDispatcher("/images/no_pic.gif").forward(req, resp);
				}else{
					resp.getOutputStream().write(qm);
					resp.getOutputStream().flush();
				}
			}

			 */
			return;
	}

	protected void doPost(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse) throws ServletException,
			IOException {
		String className = httpservletrequest.getParameter("className");
		String method = httpservletrequest.getParameter("method");
		SimpleJson sj = new SimpleJson();
		try {
			DiskFileItemFactory f = new DiskFileItemFactory();
			ServletFileUpload s = new ServletFileUpload(f);
			s.setHeaderEncoding(SystemConfig.CharSet);
			s.setSizeMax(-1); // 设定可接受的最大上传文件的大小不限
			List list = s.parseRequest(httpservletrequest);

			// 存储参数
			Map metadata = new HashMap();
			metadata.put("_filesize", "0"); // 文件总大小

			for (java.util.Enumeration e = httpservletrequest.getParameterNames(); e.hasMoreElements();) {
				String key = e.nextElement().toString();
				metadata.put(key, httpservletrequest.getParameter(key));
			}

			// 先保存所有的参数
			int i = list.size();
			for (int j = 0; j < i; j++) {
				FileItem fileitem;
				if ((fileitem = (FileItem) list.get(j)).isFormField()) {
					String pname = fileitem.getFieldName();
					String pvalue = fileitem.getString(SystemConfig.CharSet);
					metadata.put(pname, pvalue);
				} else {
					String pname = fileitem.getFieldName();
					FileItem fileItem = (FileItem) list.get(j);
					metadata.put(pname, fileItem);
				}
			}

			/*
			if(CommonUtil.isNotEmpty(method) && className.equals("zzjyManagerService")){
				ZzjyManagerService uf = (ZzjyManagerService) SpringContainer.getObject("zzjyManagerService");
				if(method.equals("saveZzjg")){
					sj = uf.saveZzjg(metadata, httpservletrequest);
					
					//重载组织结构
					try{
						DictData.reLoadZzjg(null);
					}catch(Exception e){
						sj.setMessage("保存组织结构成功，但是重载缓存失败：" + e.getMessage());
					}
				}else if(method.equals("saveZzjy")){
					sj = uf.saveZzjy(metadata, httpservletrequest);
					
					//重载组织警员
					try{
						DictData.reLoadZzjy(null);
					}catch(Exception e){
						sj.setMessage("保存警员信息成功，但是重载缓存失败：" + e.getMessage());
					}
				}
			}else{
				UpFile uf = (UpFile) SpringContainer.getObject(className);
				sj = (SimpleJson) uf.upFile(metadata, httpservletrequest);
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
			Throwable cause = e;
			String err = cause.getMessage();
			while (cause.getCause() != null) {
				cause = cause.getCause();
				err = cause.getMessage();
			}
			sj.setMessage(err);
			sj.setSuccess(false);
		}
		httpservletrequest.setAttribute(ExtCommonAction.JSON, ExtUtils.getJsonData(sj));
		httpservletrequest.getRequestDispatcher("/common/gson.jsp").forward(httpservletrequest, httpservletresponse);
	}
}
