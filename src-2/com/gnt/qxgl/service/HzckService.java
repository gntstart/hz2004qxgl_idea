package com.gnt.qxgl.service;

import java.util.List;
import java.util.Map;

import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.XtHzck;

public interface HzckService {
	
	public List<XtHzck> getHzckInfo();
	
	public Page queryYhxx(Map<String,Object> map,int pageIndex,int pageSize);
	
}
