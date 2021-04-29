package com.gnt.qxgl.service.tj;

import javax.servlet.http.HttpServletResponse;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.ExtMap;
import com.gnt.qxgl.common.Page;

public interface RktjService {
	
	public Page queryRktj(BaseUser user, ExtMap<String, Object> params);
	
	public Page queryRktjMx(BaseUser user, ExtMap<String, Object> params);
	
	public void exportRktj(BaseUser user, ExtMap<String, Object> params, HttpServletResponse response);
	
}
