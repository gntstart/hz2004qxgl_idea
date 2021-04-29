package com.gnt.qxgl.common.util;

import java.util.Comparator;

import com.gnt.qxgl.common.dict.bean.TreeNode;

/**
 * 实体排序接口类。
 * @author sh
 */
public class EntitySorter<T> implements Comparator<T>{
	boolean ascending;	//排序方式：true升序，false降序
	
	public EntitySorter(boolean ascending){
		this.ascending = ascending;
	}
	
	public int compare(T o1, T o2){
		int ire=0;
		
		if(o1 instanceof TreeNode){
			TreeNode node1 = (TreeNode)o1;
			TreeNode node2 = (TreeNode)o2;
			
			long i1 = node1.getZy().getPxh();
			long i2 = node2.getZy().getPxh();
			if(i1!=i2){
				if(ascending)
					ire = i2>i1?1:-1;
				else
					ire = i1>i2?1:-1;
			}
		}else{
			
		}
		
		return ire;
	}
}
