package com.modelMapDemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

    @JsonProperty("header") 
    public Header getHeader() { 
		 return this.header; } 

    public void setHeader(Header header) { 
		 this.header = header; } 

    private Header header;

    @JsonProperty("body") 
    public Body getBody() { 
		 return this.body; } 

    public void setBody(Body body) { 
		 this.body = body; } 

    private Body body;

    @Override
    public String toString() {
        return "Request [body=" + body + ", header=" + header + "]";
    }
    

}
