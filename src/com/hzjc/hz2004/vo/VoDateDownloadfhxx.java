package com.hzjc.hz2004.vo;

import com.hzjc.wsstruts.vo.*;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class VoDateDownloadfhxx extends DefaultVO {

    //��־����
    protected static Log _log = LogFactory.getLog(VoDateDownloadfhxx.class);

    //�����ļ��б�
    protected String[] DcwjlbList;

    public VoDateDownloadfhxx() {
    }

    public void setDcwjlbList(String[] DcwjlbList){
        this.DcwjlbList = DcwjlbList;
    }

    public String[] getDcwjlbList(){
        return this.DcwjlbList;
    }

}
