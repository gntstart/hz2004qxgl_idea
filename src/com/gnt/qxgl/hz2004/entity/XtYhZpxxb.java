package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;
import java.sql.Blob;

/**系统用户照片信息表
 * 
 * @author yj
 *
 */
public class XtYhZpxxb implements Serializable{
  private String zpid;
  private String yhid;//用户id
  private Blob zp;//照片
  private Blob zw;//指纹
public String getZpid() {
	return zpid;
}
public void setZpid(String zpid) {
	this.zpid = zpid;
}
public String getYhid() {
	return yhid;
}
public void setYhid(String yhid) {
	this.yhid = yhid;
}
public Blob getZp() {
	return zp;
}
public void setZp(Blob zp) {
	this.zp = zp;
}
public Blob getZw() {
	return zw;
}
public void setZw(Blob zw) {
	this.zw = zw;
}
public XtYhZpxxb() {
	super();
}
  
}
