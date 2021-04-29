package com.gnt.qxgl.hz2004.entity;

public class TjbVo  {
	
	private HJXX_CZRKJBXXB czrk;
	private XT_XZQHB xzqh;
	private HJXX_MLPXXXXB mlp;
	private XT_JWHXXB jwh;
	private HJXX_HXXB hxx;
	private XtDwxxb dw;
	private HJYW_CSDJXXB cs;
	private HJYW_SWZXXXB sw;
	private HJYW_QRDJXXB qr;
	private HJYW_QCZXXXB qc;
	
	
	public HJXX_CZRKJBXXB getCzrk() {
		return czrk;
	}
	public void setCzrk(HJXX_CZRKJBXXB czrk) {
		this.czrk = czrk;
	}
	public XT_XZQHB getXzqh() {
		return xzqh;
	}
	public void setXzqh(XT_XZQHB xzqh) {
		this.xzqh = xzqh;
	}
	public HJXX_MLPXXXXB getMlp() {
		return mlp;
	}
	public void setMlp(HJXX_MLPXXXXB mlp) {
		this.mlp = mlp;
	}
	public XT_JWHXXB getJwh() {
		return jwh;
	}
	public void setJwh(XT_JWHXXB jwh) {
		this.jwh = jwh;
	}
	public HJXX_HXXB getHxx() {
		return hxx;
	}
	public void setHxx(HJXX_HXXB hxx) {
		this.hxx = hxx;
	}
	public XtDwxxb getDw() {
		return dw;
	}
	public void setDw(XtDwxxb dw) {
		this.dw = dw;
	}
	public HJYW_CSDJXXB getCs() {
		return cs;
	}
	public void setCs(HJYW_CSDJXXB cs) {
		this.cs = cs;
	}
	public HJYW_SWZXXXB getSw() {
		return sw;
	}
	public void setSw(HJYW_SWZXXXB sw) {
		this.sw = sw;
	}
	public HJYW_QRDJXXB getQr() {
		return qr;
	}
	public void setQr(HJYW_QRDJXXB qr) {
		this.qr = qr;
	}
	public HJYW_QCZXXXB getQc() {
		return qc;
	}
	public void setQc(HJYW_QCZXXXB qc) {
		this.qc = qc;
	}
	
	
	public TjbVo() {
		super();
	}
	
	public TjbVo(HJXX_CZRKJBXXB czrk, XT_XZQHB xzqh, HJXX_MLPXXXXB mlp, XT_JWHXXB jwh,XtDwxxb dw) {
		super();
		this.czrk = czrk;
		this.xzqh = xzqh;
		this.mlp = mlp;
		this.jwh = jwh;
		this.dw = dw;
	}
	
	public TjbVo(HJYW_CSDJXXB cs,XT_XZQHB xzqh, HJXX_MLPXXXXB mlp, XT_JWHXXB jwh, XtDwxxb dw) {
		super();
		this.cs = cs;
		this.xzqh = xzqh;
		this.mlp = mlp;
		this.jwh = jwh;
		this.dw = dw;
	}
	
	public TjbVo(HJYW_SWZXXXB sw,XT_XZQHB xzqh, HJXX_MLPXXXXB mlp, XT_JWHXXB jwh, XtDwxxb dw) {
		super();
		this.sw = sw;
		this.xzqh = xzqh;
		this.mlp = mlp;
		this.jwh = jwh;
		this.dw = dw;
	}
	
	public TjbVo(HJYW_QRDJXXB qr,XT_XZQHB xzqh, HJXX_MLPXXXXB mlp, XT_JWHXXB jwh, XtDwxxb dw) {
		super();
		this.qr = qr;
		this.xzqh = xzqh;
		this.mlp = mlp;
		this.jwh = jwh;
		this.dw = dw;
	}
	
	public TjbVo(HJYW_QCZXXXB qc,XT_XZQHB xzqh, HJXX_MLPXXXXB mlp, XT_JWHXXB jwh, XtDwxxb dw) {
		super();
		this.qc = qc;
		this.xzqh = xzqh;
		this.mlp = mlp;
		this.jwh = jwh;
		this.dw = dw;
	}
	
	public TjbVo(HJXX_CZRKJBXXB czrk, XT_XZQHB xzqh, HJXX_MLPXXXXB mlp, XT_JWHXXB jwh, 
			XtDwxxb dw, HJYW_CSDJXXB cs, HJYW_SWZXXXB sw, HJYW_QRDJXXB qr, HJYW_QCZXXXB qc) {
		super();
		this.czrk = czrk;
		this.xzqh = xzqh;
		this.mlp = mlp;
		this.jwh = jwh;
		this.dw = dw;
		this.cs = cs;
		this.sw = sw;
		this.qr = qr;
		this.qc = qc;
	}
	
}