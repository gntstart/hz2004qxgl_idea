package com.gnt.qxgl.hz2004.entity.zjyw;

import java.sql.Blob;

/**
 * 浙江迁移证接收参数实体类
 */
public class ZjywQyzxxQyrxx implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /*主键id*/
    private String id;
    //迁移证编号
    private String qyzbh;
    //与持证人关系_家庭关系
    private String yczrgx_jtgxdm;
    //公民身份号码
    private String gmsfhm;
    //姓名
    private String xm;
    //曾用名最多允许5个，使用“，”分隔
    private String cym;
    //性别
    private String xbdm;
    //民族
    private String mzdm;
    //出生日期
    private String csrq;
    //出生地_国家（地区）
    private String csd_gjhdqdm;
    //出生地_省市县（区）
    private String csd_ssxqdm;
    //出生地_区划内详细地址
    private String csd_qhnxxdz;
    //籍贯_国家（地区）
    private String jg_gjhdqdm;
    //籍贯_省市县（区）
    private String jg_ssxqdm;
    //籍贯_区划内详细地址
    private String jg_qhnxxdz;
    //文化程度
    private String xldm;
    //婚姻状况
    private String hyzkdm;
    //职业
    private String zy;
    //迁移（流动）原因
    private String qyldyydm;
    //迁移（流动）原因（内部）
    private String qyldyymc_nb;
    //相片
    private byte[] xp;
    //居民身份证签发机关
    private String jmsfz_qfjg;
    //有效期限起始日期
    private String jmsfz_yxqxqsrq;
    //有效期限截止日期
    private String jmsfz_yxqxjzrq;
    //数据流水标识
    private String ywlsh;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQyzbh() {
        return qyzbh;
    }

    public void setQyzbh(String qyzbh) {
        this.qyzbh = qyzbh;
    }

    public String getYczrgx_jtgxdm() {
        return yczrgx_jtgxdm;
    }

    public void setYczrgx_jtgxdm(String yczrgx_jtgxdm) {
        this.yczrgx_jtgxdm = yczrgx_jtgxdm;
    }

    public String getGmsfhm() {
        return gmsfhm;
    }

    public void setGmsfhm(String gmsfhm) {
        this.gmsfhm = gmsfhm;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getCym() {
        return cym;
    }

    public void setCym(String cym) {
        this.cym = cym;
    }

    public String getXbdm() {
        return xbdm;
    }

    public void setXbdm(String xbdm) {
        this.xbdm = xbdm;
    }

    public String getMzdm() {
        return mzdm;
    }

    public void setMzdm(String mzdm) {
        this.mzdm = mzdm;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getCsd_gjhdqdm() {
        return csd_gjhdqdm;
    }

    public void setCsd_gjhdqdm(String csd_gjhdqdm) {
        this.csd_gjhdqdm = csd_gjhdqdm;
    }

    public String getCsd_ssxqdm() {
        return csd_ssxqdm;
    }

    public void setCsd_ssxqdm(String csd_ssxqdm) {
        this.csd_ssxqdm = csd_ssxqdm;
    }

    public String getCsd_qhnxxdz() {
        return csd_qhnxxdz;
    }

    public void setCsd_qhnxxdz(String csd_qhnxxdz) {
        this.csd_qhnxxdz = csd_qhnxxdz;
    }

    public String getJg_gjhdqdm() {
        return jg_gjhdqdm;
    }

    public void setJg_gjhdqdm(String jg_gjhdqdm) {
        this.jg_gjhdqdm = jg_gjhdqdm;
    }

    public String getJg_ssxqdm() {
        return jg_ssxqdm;
    }

    public void setJg_ssxqdm(String jg_ssxqdm) {
        this.jg_ssxqdm = jg_ssxqdm;
    }

    public String getJg_qhnxxdz() {
        return jg_qhnxxdz;
    }

    public void setJg_qhnxxdz(String jg_qhnxxdz) {
        this.jg_qhnxxdz = jg_qhnxxdz;
    }

    public String getXldm() {
        return xldm;
    }

    public void setXldm(String xldm) {
        this.xldm = xldm;
    }

    public String getHyzkdm() {
        return hyzkdm;
    }

    public void setHyzkdm(String hyzkdm) {
        this.hyzkdm = hyzkdm;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getQyldyydm() {
        return qyldyydm;
    }

    public void setQyldyydm(String qyldyydm) {
        this.qyldyydm = qyldyydm;
    }

    public byte[] getXp() {
        return xp;
    }

    public void setXp(byte[] xp) {
        this.xp = xp;
    }

    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

    public String getQyldyymc_nb() {
        return qyldyymc_nb;
    }

    public void setQyldyymc_nb(String qyldyymc_nb) {
        this.qyldyymc_nb = qyldyymc_nb;
    }

    public String getJmsfz_qfjg() {
        return jmsfz_qfjg;
    }

    public void setJmsfz_qfjg(String jmsfz_qfjg) {
        this.jmsfz_qfjg = jmsfz_qfjg;
    }

    public String getJmsfz_yxqxqsrq() {
        return jmsfz_yxqxqsrq;
    }

    public void setJmsfz_yxqxqsrq(String jmsfz_yxqxqsrq) {
        this.jmsfz_yxqxqsrq = jmsfz_yxqxqsrq;
    }

    public String getJmsfz_yxqxjzrq() {
        return jmsfz_yxqxjzrq;
    }

    public void setJmsfz_yxqxjzrq(String jmsfz_yxqxjzrq) {
        this.jmsfz_yxqxjzrq = jmsfz_yxqxjzrq;
    }
}
