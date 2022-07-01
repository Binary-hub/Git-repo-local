package com.zhwxp.sample.spring.boot.tcp.server.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    
    public Header header;
    public Body body;

    @JsonProperty("header") 
    public Header getHeader() {
        return header;
    }
    public void setHeader(Header header) {
        this.header = header;
    }

    @JsonProperty("body") 
    public Body getBody() {
        return body;
    }
    public void setBody(Body body) {
        this.body = body;
    }
    @Override
    public String toString() {
        return "Response [body=" + body + ", header=" + header + "]";
    }

    
}
