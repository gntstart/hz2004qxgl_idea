package com.gnt.qxgl.hz2004.entity;

import java.util.Date;

/**
 * <功能概述>
 * 用于人口普查登记数据
 *
 * @author: 杨冬冬
 * @className: QG_RKPC
 * @package: com.gnt.qxgl.hz2004.entity
 * @description: QG_RKPC人口普查实体类
 * @date: 2020-06-24 15:05
 */
public class QG_RKPC {
    /**
     * 主键id
     */
    private String rkpcId;
    /**
     * 户口整顿后总户数
     */
    private String rkpcZhs;
    /**
     * 户口整顿后总户数备注
     */
    private String rkpcZhsBz;
    /**
     * 户口整顿后总人数
     */
    private String rkpcZrs;
    /**
     * 户口整顿后总人数备注
     */
    private String rkpcZrsBz;
    /**
     * 户口整顿后乡村人数
     */
    private String rkpcXcrks;
    /**
     * 户口整顿后乡村人数备注
     */
    private String rkpcXcrksBz;
    /**
     * 户口整顿后人户分离数
     */
    private String rkpcRhfls;
    /**
     * 户口整顿后人户分离数备注
     */
    private String rkpcRhflsBz;
    /**
     * 常驻户口持证未落户数
     */
    private String rkpcCzwlf;
    /**
     * 常驻户口持证未落户备注
     */
    private String rkpcCzwlfBz;
    /**
     * 常驻户口持证未落户解决数
     */
    private String rkpcCzwlfJjs;
    /**
     * 常驻户口出生未报户口数
     */
    private String rkpcCswbhk;
    /**
     * 常驻户口出生未报户口备注
     */
    private String rkpcCswbhkBz;
    /**
     * 常驻户口出生未报户口解决数
     */
    private String rkpcCswbhkJjs;
    /**
     * 常驻户口其他
     */
    private String rkpcCzhkQt;
    /**
     * 常驻户口其他备注
     */
    private String rkpcCzhkQtBz;
    /**
     * 常驻户口其他解决数
     */
    private String rkpcCzhkQtJjs;

    /**
     * 暂住人口居住半年以上
     */
    private String rkpcZzrkJzbnys;
    /**
     * 暂住人口居住半年以上备注
     */
    private String rkpcZzrkJzbnysBz;
    /**
     * 暂住人口新登暂住人口数
     */
    private String rkpcZzrkXdzzrks;
    /**
     * 暂住人口新登暂住人口数备注
     */
    private String rkpcZzrkXdzzrksBz;
    /**
     * 户口登记重登暂住人口数
     */
    private String rkpcHkdjCdhkrs;
    /**
     * 户口登记重登暂住人口数备注
     */
    private String rkpcHkdjCdhkrsBz;
    /**
     * 户口登记应销未销户口数
     */
    private String rkpcHkdjYxwxhks;
    /**
     * 户口登记应销未销户口数备注
     */
    private String rkpcHkdjYxwxhksBz;
    /**
     * 户口登记死亡未销数
     */
    private String rkpcHkdjSwwx;
    /**
     * 户口登记死亡未销数备注
     */
    private String rkpcHkdjSwwxBz;
    /**
     * 户口登记户口变更及更正项目数
     */
    private String rkpcHkdjHkbgxms;
    /**
     * 户口登记户口变更及更正项目数备注
     */
    private String rkpcHkdjHkbgxmsBz;
    /**
     * 创建时间
     */
    private Date rkpcCreateDate;
    /**
     * 修改时间
     */
    private Date rkpcUpdateDate;
    /**
     * 数据归属单位
     */
    private String gsdw;

    /**
     * 破案线索
     */
    private String rkpcPaxs;

    /**
     * 破案线索备注
     */
    private String rkpcPaxsBz;

    /**
     * 刑事案件
     */
    private String rkpcXsaj;

    /**
     * 刑事案件备注
     */
    private String rkpcXsajBz;

    /**
     * 治安案件
     */
    private String rkpcZaaj;

    /**
     * 治安案件备注
     */
    private String rkpcZaajBz;

    /**
     * 抓获逃犯
     */
    private String rkpcZhtf;

    /**
     * 抓获逃犯备注
     */
    private String rkpcZhtfBz;

    /**
     * 被拐卖妇女儿童
     */
    private String rkpcBgmfnet;

    /**
     * 被拐卖妇女儿童备注
     */
    private String rkpcBgmfnetBz;

    /**
     * 纠正公明身份证号码重错号
     */
    private String rkpcJzgmsfzhmcch;

    /**
     * 装订门楼牌
     */
    private String rkpcZdmlp;

    /**
     * 清理废弃地址
     */
    private String rkpcQlfqdz;

    /**
     * 抽调人员
     */
    private String rkpcCdry;

    /**
     * 抽调民警
     */
    private String rkpcCdmj;

    /**
     * 工作会议培训
     */
    private String rkpcGzhypx;

    /**
     * 筹措经费万元
     */
    private String rkpcCcjf;





    public String getRkpcId() {
        return rkpcId;
    }

    public void setRkpcId(String rkpcId) {
        this.rkpcId = rkpcId;
    }

    public String getRkpcZhs() {
        return rkpcZhs;
    }

    public void setRkpcZhs(String rkpcZhs) {
        this.rkpcZhs = rkpcZhs;
    }

    public String getRkpcZhsBz() {
        return rkpcZhsBz;
    }

    public void setRkpcZhsBz(String rkpcZhsBz) {
        this.rkpcZhsBz = rkpcZhsBz;
    }

    public String getRkpcZrs() {
        return rkpcZrs;
    }

    public void setRkpcZrs(String rkpcZrs) {
        this.rkpcZrs = rkpcZrs;
    }

    public String getRkpcZrsBz() {
        return rkpcZrsBz;
    }

    public void setRkpcZrsBz(String rkpcZrsBz) {
        this.rkpcZrsBz = rkpcZrsBz;
    }

    public String getRkpcXcrks() {
        return rkpcXcrks;
    }

    public void setRkpcXcrks(String rkpcXcrks) {
        this.rkpcXcrks = rkpcXcrks;
    }

    public String getRkpcXcrksBz() {
        return rkpcXcrksBz;
    }

    public void setRkpcXcrksBz(String rkpcXcrksBz) {
        this.rkpcXcrksBz = rkpcXcrksBz;
    }

    public String getRkpcRhfls() {
        return rkpcRhfls;
    }

    public void setRkpcRhfls(String rkpcRhfls) {
        this.rkpcRhfls = rkpcRhfls;
    }

    public String getRkpcRhflsBz() {
        return rkpcRhflsBz;
    }

    public void setRkpcRhflsBz(String rkpcRhflsBz) {
        this.rkpcRhflsBz = rkpcRhflsBz;
    }

    public String getRkpcCzwlf() {
        return rkpcCzwlf;
    }

    public void setRkpcCzwlf(String rkpcCzwlf) {
        this.rkpcCzwlf = rkpcCzwlf;
    }

    public String getRkpcCzwlfBz() {
        return rkpcCzwlfBz;
    }

    public void setRkpcCzwlfBz(String rkpcCzwlfBz) {
        this.rkpcCzwlfBz = rkpcCzwlfBz;
    }

    public String getRkpcCzwlfJjs() {
        return rkpcCzwlfJjs;
    }

    public void setRkpcCzwlfJjs(String rkpcCzwlfJjs) {
        this.rkpcCzwlfJjs = rkpcCzwlfJjs;
    }

    public String getRkpcCswbhk() {
        return rkpcCswbhk;
    }

    public void setRkpcCswbhk(String rkpcCswbhk) {
        this.rkpcCswbhk = rkpcCswbhk;
    }

    public String getRkpcCswbhkBz() {
        return rkpcCswbhkBz;
    }

    public void setRkpcCswbhkBz(String rkpcCswbhkBz) {
        this.rkpcCswbhkBz = rkpcCswbhkBz;
    }

    public String getRkpcCswbhkJjs() {
        return rkpcCswbhkJjs;
    }

    public void setRkpcCswbhkJjs(String rkpcCswbhkJjs) {
        this.rkpcCswbhkJjs = rkpcCswbhkJjs;
    }

    public String getRkpcCzhkQt() {
        return rkpcCzhkQt;
    }

    public void setRkpcCzhkQt(String rkpcCzhkQt) {
        this.rkpcCzhkQt = rkpcCzhkQt;
    }

    public String getRkpcCzhkQtBz() {
        return rkpcCzhkQtBz;
    }

    public void setRkpcCzhkQtBz(String rkpcCzhkQtBz) {
        this.rkpcCzhkQtBz = rkpcCzhkQtBz;
    }

    public String getRkpcCzhkQtJjs() {
        return rkpcCzhkQtJjs;
    }

    public void setRkpcCzhkQtJjs(String rkpcCzhkQtJjs) {
        this.rkpcCzhkQtJjs = rkpcCzhkQtJjs;
    }

    public String getRkpcZzrkJzbnys() {
        return rkpcZzrkJzbnys;
    }

    public void setRkpcZzrkJzbnys(String rkpcZzrkJzbnys) {
        this.rkpcZzrkJzbnys = rkpcZzrkJzbnys;
    }

    public String getRkpcZzrkJzbnysBz() {
        return rkpcZzrkJzbnysBz;
    }

    public void setRkpcZzrkJzbnysBz(String rkpcZzrkJzbnysBz) {
        this.rkpcZzrkJzbnysBz = rkpcZzrkJzbnysBz;
    }

    public String getRkpcZzrkXdzzrks() {
        return rkpcZzrkXdzzrks;
    }

    public void setRkpcZzrkXdzzrks(String rkpcZzrkXdzzrks) {
        this.rkpcZzrkXdzzrks = rkpcZzrkXdzzrks;
    }

    public String getRkpcZzrkXdzzrksBz() {
        return rkpcZzrkXdzzrksBz;
    }

    public void setRkpcZzrkXdzzrksBz(String rkpcZzrkXdzzrksBz) {
        this.rkpcZzrkXdzzrksBz = rkpcZzrkXdzzrksBz;
    }

    public String getRkpcHkdjCdhkrs() {
        return rkpcHkdjCdhkrs;
    }

    public void setRkpcHkdjCdhkrs(String rkpcHkdjCdhkrs) {
        this.rkpcHkdjCdhkrs = rkpcHkdjCdhkrs;
    }

    public String getRkpcHkdjCdhkrsBz() {
        return rkpcHkdjCdhkrsBz;
    }

    public void setRkpcHkdjCdhkrsBz(String rkpcHkdjCdhkrsBz) {
        this.rkpcHkdjCdhkrsBz = rkpcHkdjCdhkrsBz;
    }

    public String getRkpcHkdjYxwxhks() {
        return rkpcHkdjYxwxhks;
    }

    public void setRkpcHkdjYxwxhks(String rkpcHkdjYxwxhks) {
        this.rkpcHkdjYxwxhks = rkpcHkdjYxwxhks;
    }

    public String getRkpcHkdjYxwxhksBz() {
        return rkpcHkdjYxwxhksBz;
    }

    public void setRkpcHkdjYxwxhksBz(String rkpcHkdjYxwxhksBz) {
        this.rkpcHkdjYxwxhksBz = rkpcHkdjYxwxhksBz;
    }

    public String getRkpcHkdjSwwx() {
        return rkpcHkdjSwwx;
    }

    public void setRkpcHkdjSwwx(String rkpcHkdjSwwx) {
        this.rkpcHkdjSwwx = rkpcHkdjSwwx;
    }

    public String getRkpcHkdjSwwxBz() {
        return rkpcHkdjSwwxBz;
    }

    public void setRkpcHkdjSwwxBz(String rkpcHkdjSwwxBz) {
        this.rkpcHkdjSwwxBz = rkpcHkdjSwwxBz;
    }

    public String getRkpcHkdjHkbgxms() {
        return rkpcHkdjHkbgxms;
    }

    public void setRkpcHkdjHkbgxms(String rkpcHkdjHkbgxms) {
        this.rkpcHkdjHkbgxms = rkpcHkdjHkbgxms;
    }

    public String getRkpcHkdjHkbgxmsBz() {
        return rkpcHkdjHkbgxmsBz;
    }

    public void setRkpcHkdjHkbgxmsBz(String rkpcHkdjHkbgxmsBz) {
        this.rkpcHkdjHkbgxmsBz = rkpcHkdjHkbgxmsBz;
    }

    public Date getRkpcCreateDate() {
        return rkpcCreateDate;
    }

    public void setRkpcCreateDate(Date rkpcCreateDate) {
        this.rkpcCreateDate = rkpcCreateDate;
    }

    public Date getRkpcUpdateDate() {
        return rkpcUpdateDate;
    }

    public void setRkpcUpdateDate(Date rkpcUpdateDate) {
        this.rkpcUpdateDate = rkpcUpdateDate;
    }

    public String getGsdw() {
        return gsdw;
    }

    public void setGsdw(String gsdw) {
        this.gsdw = gsdw;
    }

    public String getRkpcPaxs() {
        return rkpcPaxs;
    }

    public void setRkpcPaxs(String rkpcPaxs) {
        this.rkpcPaxs = rkpcPaxs;
    }

    public String getRkpcPaxsBz() {
        return rkpcPaxsBz;
    }

    public void setRkpcPaxsBz(String rkpcPaxsBz) {
        this.rkpcPaxsBz = rkpcPaxsBz;
    }

    public String getRkpcXsaj() {
        return rkpcXsaj;
    }

    public void setRkpcXsaj(String rkpcXsaj) {
        this.rkpcXsaj = rkpcXsaj;
    }

    public String getRkpcXsajBz() {
        return rkpcXsajBz;
    }

    public void setRkpcXsajBz(String rkpcXsajBz) {
        this.rkpcXsajBz = rkpcXsajBz;
    }

    public String getRkpcZaaj() {
        return rkpcZaaj;
    }

    public void setRkpcZaaj(String rkpcZaaj) {
        this.rkpcZaaj = rkpcZaaj;
    }

    public String getRkpcZaajBz() {
        return rkpcZaajBz;
    }

    public void setRkpcZaajBz(String rkpcZaajBz) {
        this.rkpcZaajBz = rkpcZaajBz;
    }

    public String getRkpcZhtf() {
        return rkpcZhtf;
    }

    public void setRkpcZhtf(String rkpcZhtf) {
        this.rkpcZhtf = rkpcZhtf;
    }

    public String getRkpcZhtfBz() {
        return rkpcZhtfBz;
    }

    public void setRkpcZhtfBz(String rkpcZhtfBz) {
        this.rkpcZhtfBz = rkpcZhtfBz;
    }

    public String getRkpcBgmfnet() {
        return rkpcBgmfnet;
    }

    public void setRkpcBgmfnet(String rkpcBgmfnet) {
        this.rkpcBgmfnet = rkpcBgmfnet;
    }

    public String getRkpcBgmfnetBz() {
        return rkpcBgmfnetBz;
    }

    public void setRkpcBgmfnetBz(String rkpcBgmfnetBz) {
        this.rkpcBgmfnetBz = rkpcBgmfnetBz;
    }

    public String getRkpcJzgmsfzhmcch() {
        return rkpcJzgmsfzhmcch;
    }

    public void setRkpcJzgmsfzhmcch(String rkpcJzgmsfzhmcch) {
        this.rkpcJzgmsfzhmcch = rkpcJzgmsfzhmcch;
    }

    public String getRkpcZdmlp() {
        return rkpcZdmlp;
    }

    public void setRkpcZdmlp(String rkpcZdmlp) {
        this.rkpcZdmlp = rkpcZdmlp;
    }

    public String getRkpcQlfqdz() {
        return rkpcQlfqdz;
    }

    public void setRkpcQlfqdz(String rkpcQlfqdz) {
        this.rkpcQlfqdz = rkpcQlfqdz;
    }

    public String getRkpcCdry() {
        return rkpcCdry;
    }

    public void setRkpcCdry(String rkpcCdry) {
        this.rkpcCdry = rkpcCdry;
    }

    public String getRkpcCdmj() {
        return rkpcCdmj;
    }

    public void setRkpcCdmj(String rkpcCdmj) {
        this.rkpcCdmj = rkpcCdmj;
    }

    public String getRkpcGzhypx() {
        return rkpcGzhypx;
    }

    public void setRkpcGzhypx(String rkpcGzhypx) {
        this.rkpcGzhypx = rkpcGzhypx;
    }

    public String getRkpcCcjf() {
        return rkpcCcjf;
    }

    public void setRkpcCcjf(String rkpcCcjf) {
        this.rkpcCcjf = rkpcCcjf;
    }
}
