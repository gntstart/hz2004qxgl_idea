package com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;
import java.util.Date;

import com.gnt.qxgl.common.dict.DictData;
import com.gnt.qxgl.common.dict.bean.SysOrganizeInfo;

/**
*鐢ㄦ埛淇℃伅琛�
*/
public class XtYhxxb implements Serializable{
	/*
	*鍗曚綅灞傛鐮�
	*/
	/*
	*鐢ㄦ埛ID
	*/
	private String	yhid;
	/*
	*鐢ㄦ埛鐧诲綍鍚�
	*/
	private String	yhdlm;
	/*
	*璀﹀憳鍙�
	*/
	private String	jyh;
	/*
	*鍗曚綅浠ｇ爜
	*/
	private String	dwdm;
	/*
	*鐢ㄦ埛濮撳悕
	*/
	private String	yhxm;
	/*
	*鐢ㄦ埛鎬у埆
	*/
	private String	yhxb;
	/*
	*鐢ㄦ埛鑱屽姟
	*/
	private String	yhzw;
	/*
	*鐧诲綍鍙ｄ护
	*/
	private String	dlkl;
	/*
	*鐢ㄦ埛瀵嗙骇
	*/
	private String	yhmj;
	/*
	*鎿嶄綔瀵嗙骇
	*/
	private String	czmj;
	/*
	*鐢ㄦ埛鐘舵�
	*/
	private String	yhzt;
	/*
	*鍏皯韬唤鍙风爜
	*/
	private String	gmsfhm;
	private String dqbm;
	
	private String uid;
	private String dwmc;//非持久字段
	private String khmsg;	//考核数据
	private Date khgxsj;
	private String lxdh;
	private String zwmc; //非持久字段
	
	
	public String getZwmc() {
		return zwmc;
	}

	public void setZwmc(String zwmc) {
		this.zwmc = zwmc;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public Date getKhgxsj() {
		return khgxsj;
	}

	public void setKhgxsj(Date khgxsj) {
		this.khgxsj = khgxsj;
	}

	public String getKhmsg() {
		return khmsg;
	}

	public void setKhmsg(String khmsg) {
		this.khmsg = khmsg;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}
	
	public String getDqbm(){
		return dqbm;
	}
	
	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public XtYhxxb(){}

	public String getYhid(){
		return this.yhid;
	}

	public void setYhid(String yhid){
		this.uid = String.valueOf(yhid);
		this.yhid=yhid;
	}

	public String getYhdlm(){
		return this.yhdlm;
	}

	public void setYhdlm(String yhdlm){
		this.yhdlm=yhdlm;
	}

	public String getJyh(){
		return this.jyh;
	}

	public void setJyh(String jyh){
		this.jyh=jyh;
	}

	public String getDwdm(){
		return this.dwdm;
	}

	public void setDwdm(String dwdm){
		this.dwdm=dwdm;
		
		SysOrganizeInfo org = DictData.getZzjg(dwdm);
		if(org!=null)
			this.dwmc = org.getMc();
		else
			this.dwmc = dwdm;
	}

	public String getYhxm(){
		return this.yhxm;
	}

	public void setYhxm(String yhxm){
		this.yhxm=yhxm;
	}

	public String getYhxb(){
		return this.yhxb;
	}

	public void setYhxb(String yhxb){
		this.yhxb=yhxb;
	}

	public String getYhzw(){
		return this.yhzw;
	}

	public void setYhzw(String yhzw){
		this.yhzw=yhzw;
	}

	public String getDlkl(){
		return this.dlkl;
	}

	public void setDlkl(String dlkl){
		this.dlkl=dlkl;
	}

	public String getYhmj(){
		return this.yhmj;
	}

	public void setYhmj(String yhmj){
		this.yhmj=yhmj;
	}

	public String getCzmj(){
		return this.czmj;
	}

	public void setCzmj(String czmj){
		this.czmj=czmj;
	}

	public String getYhzt(){
		return this.yhzt;
	}

	public void setYhzt(String yhzt){
		this.yhzt=yhzt;
	}

	public String getGmsfhm(){
		return this.gmsfhm;
	}

	public void setGmsfhm(String gmsfhm){
		this.gmsfhm=gmsfhm;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}