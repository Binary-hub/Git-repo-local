package com.modelMapDemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootDto {
    
    @JsonProperty("id") 
    public String getId() { 
		 return this.id; } 

    public void setId(String id) { 
		 this.id = id; } 

    private String id;

    @JsonProperty("msgType") 
    public String getMsgType() { 
		 return this.msgType; } 

    public void setMsgType(String msgType) { 
		 this.msgType = msgType; } 

    private String msgType;
    
}
