package com.gnt.qxgl.common.dict.bean;

/**
 * 
 * @author Albert
 * 所有POJO对象必须继承的基本超类，实现了IcomEntity接口。
 *
 */
public class CommonEntity implements IcomEntity,Cloneable {
	public Object getClone(){
		try{
			return clone();
		}catch(Exception e){
			;
		}
		
		return null;
	}
}
