package com.gnt.qxgl.common.dict.bean;

public class Code {
    private String code;
    private String name;
    private String pyt;
    
    public Code(){
    	
    }

    public Code(String code,String name,String pyt){
    	this.code = code;
    	this.name = name;
    	this.pyt = pyt;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPyt() {
        return pyt;
    }
    public void setPyt(String pyt) {
        this.pyt = pyt;
    }
}