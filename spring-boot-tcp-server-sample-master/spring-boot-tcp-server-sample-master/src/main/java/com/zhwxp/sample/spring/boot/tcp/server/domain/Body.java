package com.zhwxp.sample.spring.boot.tcp.server.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {

    public int taskId;

    @JsonProperty("taskId")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "Body [taskId=" + taskId + "]";
    }

    
    
}
