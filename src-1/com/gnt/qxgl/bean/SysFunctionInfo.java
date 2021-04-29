package com.gnt.qxgl.bean;

import java.io.Serializable;
import java.util.Date;

/**
*系统权限编码�?
*/
public class SysFunctionInfo implements Serializable{
	/*
	*单位层次�?
	*/
	/*
	*权限ID，主�?
	*/
	private String	funid;
	/*
	*权限编码
	*/
	private String	functionBm;
	/*
	*权限名称
	*/
	private String	functionName;
	/*
	*权限注释
	*/
	private String	functionDesc;
	/*
	*权限URL
	*/
	private String	functionUrl;
	/*
	*权限显示排序
	*/
	private Long	functionOrder;
	/*
	*创建用户ID
	*/
	private String	newUserUid;
	/*
	*创建时间
	*/
	private Date	newDate;
	/*
	*父功能点主键-项目代码
	*/
	private String	parentProjectBm;
	/*
	*父功能点主键-功能点代�?
	*/
	private String	parentFunid;
	/*
	*权限属于的项�?
	*/
	private String	xmbm;
	/*
	*扩展将来的菜单管理：资源类型:menu 菜单，btn_url 按钮/链接 other 其它
	*/
	private String	zylx;
	/*
	*扩展将来的菜单管理：资源应用场景编码：菜单不能为空，默认sys(用来区分系统中的子系统菜�?
	*/
	private String	cjbm;
	/*
	*扩展将来的菜单管理：排序�? 同一层次资源的排序号，只对菜单资源有�?
	*/
	private Long	pxh;
	/*
	*扩展将来的菜单管理：是否�?��菜单�? 否，1 �?
	*/
	private String	zzcd;
	/*
	*扩展将来的菜单管理：是否快捷菜单:0 否，1 �?
	*/
	private String	sfkj;
	/*
	*扩展将来的菜单管理：地市编码: DS
	*/
	private String	dsbm;
	/*
	*扩展将来的菜单管理：是否隐藏�? 否，1 是，隐藏的菜单必须�?过搜索才能使�?
	*/
	private String	sfyc;
	/*
	*资源层次码：4位一层�?
	*/
	private String	ccm;
	/*
	*资源图标，对应WEBROOT目录，以/�?��
	*/
	private String	icon;
	/*
	*资源编码，搜索用，默认为名称的地�?��字母组合
	*/
	private String	zycode;

	public SysFunctionInfo(){}


	public SysFunctionInfo(String funid,
			String functionBm,
			String functionName,
			String functionDesc,
			String functionUrl,
			Long functionOrder,
			String newUserUid,
			Date newDate,
			String parentProjectBm,
			String parentFunid,
			String xmbm,
			String zylx,
			String cjbm,
			Long pxh,
			String zzcd,
			String sfkj,
			String dsbm,
			String sfyc,
			String ccm,
			String icon,
			String zycode)
	{
		this.funid=funid;
		this.functionBm=functionBm;
		this.functionName=functionName;
		this.functionDesc=functionDesc;
		this.functionUrl=functionUrl;
		this.functionOrder=functionOrder;
		this.newUserUid=newUserUid;
		this.newDate=newDate;
		this.parentProjectBm=parentProjectBm;
		this.parentFunid=parentFunid;
		this.xmbm=xmbm;
		this.zylx=zylx;
		this.cjbm=cjbm;
		this.pxh=pxh;
		this.zzcd=zzcd;
		this.sfkj=sfkj;
		this.dsbm=dsbm;
		this.sfyc=sfyc;
		this.ccm=ccm;
		this.icon=icon;
		this.zycode=zycode;
	}

	public String getFunid(){
		return this.funid;
	}

	public void setFunid(String funid){
		this.funid=funid;
	}

	public String getFunctionBm(){
		return this.functionBm;
	}

	public void setFunctionBm(String functionBm){
		this.functionBm=functionBm;
	}

	public String getFunctionName(){
		return this.functionName;
	}

	public void setFunctionName(String functionName){
		this.functionName=functionName;
	}

	public String getFunctionDesc(){
		return this.functionDesc;
	}

	public void setFunctionDesc(String functionDesc){
		this.functionDesc=functionDesc;
	}

	public String getFunctionUrl(){
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl){
		this.functionUrl=functionUrl;
	}

	public Long getFunctionOrder(){
		return this.functionOrder;
	}

	public void setFunctionOrder(Long functionOrder){
		this.functionOrder=functionOrder;
	}

	public String getNewUserUid(){
		return this.newUserUid;
	}

	public void setNewUserUid(String newUserUid){
		this.newUserUid=newUserUid;
	}

	public Date getNewDate(){
		return this.newDate;
	}

	public void setNewDate(Date newDate){
		this.newDate=newDate;
	}

	public String getParentProjectBm(){
		return this.parentProjectBm;
	}

	public void setParentProjectBm(String parentProjectBm){
		this.parentProjectBm=parentProjectBm;
	}

	public String getParentFunid(){
		return this.parentFunid;
	}

	public void setParentFunid(String parentFunid){
		this.parentFunid=parentFunid;
	}

	public String getXmbm(){
		return this.xmbm;
	}

	public void setXmbm(String xmbm){
		this.xmbm=xmbm;
	}

	public String getZylx(){
		return this.zylx;
	}

	public void setZylx(String zylx){
		this.zylx=zylx;
	}

	public String getCjbm(){
		return this.cjbm;
	}

	public void setCjbm(String cjbm){
		this.cjbm=cjbm;
	}

	public Long getPxh(){
		return this.pxh;
	}

	public void setPxh(Long pxh){
		this.pxh=pxh;
	}

	public String getZzcd(){
		return this.zzcd;
	}

	public void setZzcd(String zzcd){
		this.zzcd=zzcd;
	}

	public String getSfkj(){
		return this.sfkj;
	}

	public void setSfkj(String sfkj){
		this.sfkj=sfkj;
	}

	public String getDsbm(){
		return this.dsbm;
	}

	public void setDsbm(String dsbm){
		this.dsbm=dsbm;
	}

	public String getSfyc(){
		return this.sfyc;
	}

	public void setSfyc(String sfyc){
		this.sfyc=sfyc;
	}

	public String getCcm(){
		return this.ccm;
	}

	public void setCcm(String ccm){
		this.ccm=ccm;
	}

	public String getIcon(){
		return this.icon;
	}

	public void setIcon(String icon){
		this.icon=icon;
	}

	public String getZycode(){
		return this.zycode;
	}

	public void setZycode(String zycode){
		this.zycode=zycode;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}