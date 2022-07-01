package com.zhwxp.sample.spring.boot.tcp.server.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Header {

    public String responseId;
    public int code;
    public String msg;
    
    @JsonProperty("responseId") 
    public String getResponseId() {
        return responseId;
    }
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    @JsonProperty("code")
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    
    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    @Override
    public String toString() {
        return "Header [code=" + code + ", msg=" + msg + ", responseId=" + responseId + "]";
    }

    
    
}
