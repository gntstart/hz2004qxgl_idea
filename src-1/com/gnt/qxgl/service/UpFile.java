package com.gnt.qxgl.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.gnt.qxgl.bean.SimpleJson;

public interface UpFile {
	public SimpleJson upFile(Map parm,HttpServletRequest req);
}
