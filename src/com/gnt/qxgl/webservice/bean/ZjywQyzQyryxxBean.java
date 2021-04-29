package com.gnt.qxgl.webservice.bean;

import com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxx;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywQyzxxQyrxx;

import java.util.List;

public class ZjywQyzQyryxxBean extends ZjywQyzxx {

    private List<ZjywQyzxxQyrxx> qyrxx;

    public List<ZjywQyzxxQyrxx> getQyrxx() {
        return qyrxx;
    }

    public void setQyrxx(List<ZjywQyzxxQyrxx> qyrxx) {
        this.qyrxx = qyrxx;
    }
}
