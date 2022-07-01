package com.zhwxp.sample.spring.boot.tcp.server.service;

public interface MessageService {

    byte[] processMessage(byte[] message);

    boolean validate(String msgContent);

}
