package com.zhwxp.sample.spring.boot.tcp.server.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    public String id;
    public String msgType;
    public Response response;

    @JsonProperty("id") 
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("msgType")
    public String getMsgType() {
        return msgType;
    }
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @JsonProperty("response") 
    public Response getResponse() {
        return response;
    }
    public void setResponse(Response response) {
        this.response = response;
    }
    @Override
    public String toString() {
        return "Root [id=" + id + ", msgType=" + msgType + ", response=" + response + "]";
    }

    
}
