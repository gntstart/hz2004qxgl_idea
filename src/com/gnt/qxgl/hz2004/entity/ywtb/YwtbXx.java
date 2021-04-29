package com.gnt.qxgl.hz2004.entity.ywtb;

import java.util.Date;

/**
 * <功能概述>
 *  一网通办信息
 * @author: 杨冬冬
 * @className: YwtbXx
 * @package: com.gnt.qxgl.hz2004.entity.ywtb
 * @description: 介绍
 * @date: 2020-05-19 15:42
 */
public class YwtbXx {
    /* 唯一标识applyNo */
    private String applyno;
    //姓名
    private String username;
    //身份证号码
    private String licenseno;
    //手机号
    private String mobile;
    //受理单位编号
    private String sldwcode;
    //受理单位名称
    private String sldwname;
    //简述需查证内容
    private String content;
    //事项名称
    private String itemname;
    //申请时间
    private Date begintime;
    //开具范围
    private String kjfw;
    //领取方式
    private String lqfs;
    //收件人姓名
    private String sjrusername;
    //收件人联系地址
    private String sjraddress;
    //收件人联系电话
    private String sjrmobile;
    //状态//0是从政务网接收1是从互联网前置机推送到公安网2是公安网办结3是公安网推送到互联网前置机4是互联网推送到政务网 5是推送失败
    private String isstatus;
    //创建时间
    private Date cjsj;
    //修改时间
    private Date xgsj;
    //办理结果
    private String bljg;
    //办理意见
    private String blyj;
    //file 户籍证明文件流
    private byte[] blFile;
    //办理部门code
    private String blBmcode;
    //办理部门name
    private String blBmName;
    //推送到公安内网状态
    private String gaisstatus;
    private String ywtbfjcl;//add by zjm 1：户籍证明 2：不予出具告知书

    private String btgsx_one;//居民户口薄、居民身份证、护照等法定身份证件能够证明的事项
    private String btgsx_two;//其他单位或部门依法定职责证明的事项
    private String btgsx_three;//其他事项_____________
    private String btgsx_four;//未查证相关事项
    private String btgsx_three_info;//其他事项填写详情

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLicenseno() {
        return licenseno;
    }

    public void setLicenseno(String licenseno) {
        this.licenseno = licenseno;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSldwcode() {
        return sldwcode;
    }

    public void setSldwcode(String sldwcode) {
        this.sldwcode = sldwcode;
    }

    public String getSldwname() {
        return sldwname;
    }

    public void setSldwname(String sldwname) {
        this.sldwname = sldwname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public String getKjfw() {
        return kjfw;
    }

    public void setKjfw(String kjfw) {
        this.kjfw = kjfw;
    }

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
    }

    public String getLqfs() {
        return lqfs;
    }

    public void setLqfs(String lqfs) {
        this.lqfs = lqfs;
    }

    public String getSjrusername() {
        return sjrusername;
    }

    public void setSjrusername(String sjrusername) {
        this.sjrusername = sjrusername;
    }

    public String getSjraddress() {
        return sjraddress;
    }

    public void setSjraddress(String sjraddress) {
        this.sjraddress = sjraddress;
    }

    public String getSjrmobile() {
        return sjrmobile;
    }

    public void setSjrmobile(String sjrmobile) {
        this.sjrmobile = sjrmobile;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getIsstatus() {
        return isstatus;
    }

    public void setIsstatus(String isstatus) {
        this.isstatus = isstatus;
    }

    public String getBljg() {
        return bljg;
    }

    public void setBljg(String bljg) {
        this.bljg = bljg;
    }

    public String getBlyj() {
        return blyj;
    }

    public void setBlyj(String blyj) {
        this.blyj = blyj;
    }

    public byte[] getBlFile() {
        return blFile;
    }

    public void setBlFile(byte[] blFile) {
        this.blFile = blFile;
    }

    public String getBlBmcode() {
        return blBmcode;
    }

    public void setBlBmcode(String blBmcode) {
        this.blBmcode = blBmcode;
    }

    public String getBlBmName() {
        return blBmName;
    }

    public void setBlBmName(String blBmName) {
        this.blBmName = blBmName;
    }

    public String getGaisstatus() {
        return gaisstatus;
    }

    public void setGaisstatus(String gaisstatus) {
        this.gaisstatus = gaisstatus;
    }

	public String getYwtbfjcl() {
		return ywtbfjcl;
	}

	public void setYwtbfjcl(String ywtbfjcl) {
		this.ywtbfjcl = ywtbfjcl;
	}

    public String getBtgsx_one() {
        return btgsx_one;
    }

    public void setBtgsx_one(String btgsx_one) {
        this.btgsx_one = btgsx_one;
    }

    public String getBtgsx_two() {
        return btgsx_two;
    }

    public void setBtgsx_two(String btgsx_two) {
        this.btgsx_two = btgsx_two;
    }

    public String getBtgsx_three() {
        return btgsx_three;
    }

    public void setBtgsx_three(String btgsx_three) {
        this.btgsx_three = btgsx_three;
    }

    public String getBtgsx_four() {
        return btgsx_four;
    }

    public void setBtgsx_four(String btgsx_four) {
        this.btgsx_four = btgsx_four;
    }

    public String getBtgsx_three_info() {
        return btgsx_three_info;
    }

    public void setBtgsx_three_info(String btgsx_three_info) {
        this.btgsx_three_info = btgsx_three_info;
    }
}
