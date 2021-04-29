package com.gnt.qxgl.common.sort;

import java.util.Comparator;
import com.gnt.qxgl.hz2004.entity.XT_JLXXXB;

public class JlxSort implements Comparator<XT_JLXXXB>{
	public int compare(XT_JLXXXB o1, XT_JLXXXB o2) {
		if(o2==null)
			return -1;
		
		return o1.getDm().compareTo(o2.getDm());
	}
}
