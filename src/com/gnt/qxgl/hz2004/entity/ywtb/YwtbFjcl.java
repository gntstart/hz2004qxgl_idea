package com.gnt.qxgl.hz2004.entity.ywtb;

import java.util.Date;

/**
 * <功能概述>
 *
 * @author: 杨冬冬
 * @className: YwtbFjcl
 * @package: com.gnt.qxgl.hz2004.entity.ywtb
 * @description: 介绍
 * @date: 2020-05-19 15:23
 */
public class YwtbFjcl {
    private String id;
    private String applyno;
    private String filename;
    private String needflag;
    private String stuffname;
    private String stuffcode;
    private String stuffid;
    private byte[] stufffile;
    private Date cjsj;
    private String filetype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getNeedflag() {
        return needflag;
    }

    public void setNeedflag(String needflag) {
        this.needflag = needflag;
    }

    public String getStuffname() {
        return stuffname;
    }

    public void setStuffname(String stuffname) {
        this.stuffname = stuffname;
    }

    public String getStuffcode() {
        return stuffcode;
    }

    public void setStuffcode(String stuffcode) {
        this.stuffcode = stuffcode;
    }

    public String getStuffid() {
        return stuffid;
    }

    public void setStuffid(String stuffid) {
        this.stuffid = stuffid;
    }

    public byte[] getStufffile() {
        return stufffile;
    }

    public void setStufffile(byte[] stufffile) {
        this.stufffile = stufffile;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
    
}
