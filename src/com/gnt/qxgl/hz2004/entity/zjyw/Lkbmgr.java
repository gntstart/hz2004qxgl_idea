package com.gnt.qxgl.hz2004.entity.zjyw;

/**
*旅客编码生成
*/
public class Lkbmgr implements java.io.Serializable{
private static final long serialVersionUID = 1L;
	
	/*
	*单位层次
	*/
	/*
	*旅馆编码
	*/
	private String id;
	private String lgbm;
	/*
	*日期
	*/
	private String rq;
	/*
	*序号
	*/
	private Long xh;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLgbm(){
		return this.lgbm;
	}

	public void setLgbm(String lgbm){
		this.lgbm=lgbm;
	}

	public String getRq(){
		return this.rq;
	}

	public void setRq(String rq){
		this.rq=rq;
	}

	public Long getXh(){
		return this.xh;
	}

	public void setXh(Long xh){
		this.xh=xh;
	}

	public String getLayerOooo(){
		return "";
	}

	public void setLayerOooo(String layerOoooo){
	}
}