package com.gnt.qxgl.webservice.bean;

import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzQyrxx;
import com.gnt.qxgl.hz2004.entity.zjyw.ZjywZqzxx;

import java.util.List;

public class ZjywZqzQyryxxBean extends ZjywZqzxx {

    private List<ZjywZqzQyrxx> qyrxx;

    public List<ZjywZqzQyrxx> getQyrxx() {
        return qyrxx;
    }

    public void setQyrxx(List<ZjywZqzQyrxx> qyrxx) {
        this.qyrxx = qyrxx;
    }
}
