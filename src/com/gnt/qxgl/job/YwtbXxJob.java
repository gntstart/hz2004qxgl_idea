package com.gnt.qxgl.job;

/**
 * <功能概述>
 * 内网查询返回
 * @author: 杨冬冬
 * @className: YwtbXxJob
 * @package: com.gnt.qxgl.job
 * @description: 介绍
 * @date: 2020-11-02 15:02
 */
public class YwtbXxJob {
    /* 唯一标识applyNo */
    private String applyno;
    //办理结果
    private String bljg;
    //办理意见
    private String blyj;
    //file 户籍证明文件流
    private String blFile;
    //办理部门code
    private String blBmcode;
    //办理部门name
    private String blBmName;

    public String getApplyno() {
        return applyno;
    }

    public void setApplyno(String applyno) {
        this.applyno = applyno;
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

    public String getBlFile() {
        return blFile;
    }

    public void setBlFile(String blFile) {
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
}
