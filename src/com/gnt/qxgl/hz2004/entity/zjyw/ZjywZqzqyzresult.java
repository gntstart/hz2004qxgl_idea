package com.gnt.qxgl.hz2004.entity.zjyw;

import java.util.Date;

/**
 * <功能概述>
 *  准迁证迁移证反馈信息表
 * @author: 杨冬冬
 * @className: ZjywZqzqyzresult
 * @package: com.gnt.qxgl.hz2004.entity.zjyw
 * @description: 介绍
 * @date: 2021-02-19 13:20
 */
public class ZjywZqzqyzresult {
    //主键ID
    private String id;
    //数据包类型  010122准迁证/010124迁移证
    private String sjblx;
    //业务流水号
    private String ywlsh;
    //准迁证编号
    private String zqzbh;
    //迁移证编号
    private String qyzbh;
    //反馈code
    private String code;
    //反馈信息
    private String msg;
    //创建时间
    private Date cjsj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSjblx() {
        return sjblx;
    }

    public void setSjblx(String sjblx) {
        this.sjblx = sjblx;
    }

    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

    public String getZqzbh() {
        return zqzbh;
    }

    public void setZqzbh(String zqzbh) {
        this.zqzbh = zqzbh;
    }

    public String getQyzbh() {
        return qyzbh;
    }

    public void setQyzbh(String qyzbh) {
        this.qyzbh = qyzbh;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }
}
