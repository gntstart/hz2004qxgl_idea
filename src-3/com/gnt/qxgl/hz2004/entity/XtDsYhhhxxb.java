package  com.gnt.qxgl.hz2004.entity;

import java.io.Serializable;
import java.util.Date;

public class XtDsYhhhxxb implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private long yhhhId;
	
	private String hhId;
	
	private long yhId;
	
	private String yhIP;
	
	private String khdbb;
	
	private String stId;
	
	private String stdsbm;
	
	private String stdsmc;
	
	private Date gxsj;
	
	
	public long getYhhhId() {
		return yhhhId;
	}

	public void setYhhhId(long yhhhId) {
		this.yhhhId = yhhhId;
	}

	public String getHhId() {
		return hhId;
	}

	public void setHhId(String hhId) {
		this.hhId = hhId;
	}

	public long getYhId() {
		return yhId;
	}

	public void setYhId(long yhId) {
		this.yhId = yhId;
	}

	public String getYhIP() {
		return yhIP;
	}

	public void setYhIP(String yhIP) {
		this.yhIP = yhIP;
	}

	public String getKhdbb() {
		return khdbb;
	}

	public void setKhdbb(String khdbb) {
		this.khdbb = khdbb;
	}

	public String getStId() {
		return stId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public String getStdsbm() {
		return stdsbm;
	}

	public void setStdsbm(String stdsbm) {
		this.stdsbm = stdsbm;
	}

	public String getStdsmc() {
		return stdsmc;
	}

	public void setStdsmc(String stdsmc) {
		this.stdsmc = stdsmc;
	}

	public Date getGxsj() {
		return gxsj;
	}

	public void setGxsj(Date gxsj) {
		this.gxsj = gxsj;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
