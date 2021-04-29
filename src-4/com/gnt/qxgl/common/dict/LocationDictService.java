package com.gnt.qxgl.common.dict;

import java.util.List;
import java.util.Map;

import com.gnt.qxgl.bean.SysCode;


/**
 * 加载本地字典服务，除了组织机构、组织警员、sys_code、sys_codetype等字典之外，还允许将其他配置加载到字典中。
 * 通过WEB.xml文件指定接口实现着
 * @author User
 *
 */
public interface LocationDictService {
	public Map<String,Map<String,List<SysCode>>> loadDict();
}