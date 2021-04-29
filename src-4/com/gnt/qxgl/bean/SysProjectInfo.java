package com.gnt.qxgl.bean;

import java.io.Serializable;
import java.util.Date;

/**
*项目�?
*/
public class SysProjectInfo implements Serializable{
	/*
	*单位层次�?
	*/
	/*
	*项目编码，唯�?
	*/
	private String	xmbm;
	/*
	*项目名称，唯�?
	*/
	private String	xmmc;
	/*
	*项目说明
	*/
	private String	xmsm;
	/*
	*创建时间
	*/
	private Date	cjsj;
	/*
	*注销标志�? 有效�? 注销
	*/
	private String	zxbz;
	/*
	*项目管理员角色：必须，创建功能点自动赋予此角色功能点。（自动化框架用�?
	*/
	private String	glyjsbm;
	/*
	*项目状�?：必�? 设计状�?�? 应用状�?。（自动化框架用�?
	*/
	private String	xmbz;

	public SysProjectInfo(){}


	public SysProjectInfo(String xmbm,
			String xmmc,
			String xmsm,
			Date cjsj,
			String zxbz,
			String glyjsbm,
			String xmbz)
	{
		this.xmbm=xmbm;
		this.xmmc=xmmc;
		this.xmsm=xmsm;
		this.cjsj=cjsj;
		this.zxbz=zxbz;
		this.glyjsbm=glyjsbm;
		this.xmbz=xmbz;
	}

	public String getXmbm(){
		return this.xmbm;
	}

	public void setXmbm(String xmbm){
		this.xmbm=xmbm;
	}

	public String getXmmc(){
		return this.xmmc;
	}

	public void setXmmc(String xmmc){
		this.xmmc=xmmc;
	}

	public String getXmsm(){
		return this.xmsm;
	}

	public void setXmsm(String xmsm){
		this.xmsm=xmsm;
	}

	public Date getCjsj(){
		return this.cjsj;
	}

	public void setCjsj(Date cjsj){
		this.cjsj=cjsj;
	}

	public String getZxbz(){
		return this.zxbz;
	}

	public void setZxbz(String zxbz){
		this.zxbz=zxbz;
	}

	public String getGlyjsbm(){
		return this.glyjsbm;
	}

	public void setGlyjsbm(String glyjsbm){
		this.glyjsbm=glyjsbm;
	}

	public String getXmbz(){
		return this.xmbz;
	}

	public void setXmbz(String xmbz){
		this.xmbz=xmbz;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}