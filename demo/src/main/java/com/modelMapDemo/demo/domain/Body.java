package com.modelMapDemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {
    
    @JsonProperty("taskType") 
    public String getTaskType() { 
		 return this.taskType; } 

    public void setTaskType(String taskType) { 
		 this.taskType = taskType; } 

    private String taskType;

    @JsonProperty("field1") 
    public String getField1() { 
		 return this.field1; } 

    public void setField1(String field1) { 
		 this.field1 = field1; } 

    private String field1;

    @JsonProperty("field2") 
    public String getField2() { 
		 return this.field2; } 

    public void setField2(String field2) { 
		 this.field2 = field2; } 

    private String field2;
    
}
