package com.gnt.qxgl.service;

import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.Page;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_HJSPSQB;
import com.gnt.qxgl.hz2004.entity.SJ_HJSP_ZQZXXB;
import com.gnt.qxgl.hz2004.entity.SJ_HJYW_QCZXXXB;
import com.gnt.qxgl.hz2004.entity.XtDwxxb;
import com.gnt.qxgl.hz2004.entity.ywtb.YwtbXkzApi;
import com.gnt.qxgl.hz2004.entity.zjyw.*;
import com.hzjc.hz2004.po.PoHJXX_RYZPXXB;

import java.util.List;
import java.util.Map;


public interface Hz2004Service {

    YwtbXkzApi getXkzApi(String pcsbm, String sbh);

    String updateLkbm(String lgbm);
    /**
     * 通用查询
     *
     * @param hql
     * @return
     */
    List queryByHQL(String hql);

    ApiYs getApiYsByPostid(String lgbm, String type, String postid);

    void saveLog2(LgApiLog log);

    void saveZjywZqzxx(ZjywZqzxx zqzxx, String pcsbm);

    ZjywZqzxx queryZjywZqzxxByPostid(String postid);


    void updateZjywZqzxx(ZjywZqzxx zqzxx);

    void updateSjHjspZqzxx(SJ_HJSP_ZQZXXB sjHjspZqzxxb);

    void saveZjywZqzQyrxx(ZjywZqzQyrxx zqzQyrxx);

    void saveZjywQyzxx(ZjywQyzxx qyzxx, String pcsbm);

    void updateZjywQyzxx(ZjywQyzxx qyzxx);

    void saveZjywQyzQyrxx(ZjywQyzxxQyrxx zqzQyrxx);

    ZjywQyzxx queryZjywQyzxxByPostid(String qyzbh);

    Page queryZqzXx(Map<String, Object> map, int pageIndex, int pageSize);

    Page querySjHjspZqzxx(Map<String, Object> map, int pageIndex, int pageSize);

    Page queryQyzXx(Map<String, Object> map, int pageIndex, int pageSize);

    Page queryZqzQyrxx(Map<String, Object> map, int pageIndex, int pageSize);

    Page querySJ_HJSP_QYZXXB(Map<String, Object> map, int pageIndex, int pageSize);

    List querySJ_HJSP_ZQZXXB(String isStatus,String dqbm,int pageIndex, int pageSize);

    SJ_HJSP_ZQZXXB querySJ_HJSP_ZQZXXB(String zqzbh);

    SJ_HJYW_QCZXXXB queryQczxxxb(String gmsfhm,String qyzbh,String zqzbh);

    void updateSJ_HJSP_ZQZXXB(SJ_HJSP_ZQZXXB sj_hjsp_zqzxxb);

    Boolean postUpdateZp(String name, String gmsfhm, String dqbm);

    PoHJXX_RYZPXXB queryZp(Map<String, Object> map);

    XtDwxxb queryXtDwxxb(String mc,String fjjgdm);

    XtDwxxb queryXtDwxxbDm(String mc,String fjjgdm);

    SJ_HJSP_HJSPSQB querySJ_HJSP_HJSPSQB(String spywid);

    void saveZjywZqzqyzresult(ZjywZqzqyzresult zjywZqzqyzresult);

    Page queryDzyxSjHjspZqzxx(Map<String, Object> map, int pageIndex, int pageSize);

    void insertDzyxQr(Map<String, Object> map, int pageIndex, int pageSize, BaseUser user);

    void deleteZqzXx(String status, String zqid);

    void modifyDzyxQr(Map<String, Object> map);
}
