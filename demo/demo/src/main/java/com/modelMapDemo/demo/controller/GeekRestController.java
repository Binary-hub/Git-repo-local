package com.modelMapDemo.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modelMapDemo.demo.domain.Root;
import com.modelMapDemo.demo.domain.RootDto;
import com.modelMapDemo.demo.gateway.TcpClientGateway;
import com.modelMapDemo.demo.service.GeekMapper;

@RestController
public class GeekRestController {

    @Autowired
    GeekMapper mapper;

    private TcpClientGateway tcpClientGateway; 

    @Autowired
    public GeekRestController(TcpClientGateway tcpClientGateway) {
        this.tcpClientGateway=tcpClientGateway;
    }
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GeekRestController.class);

    @PostMapping("/")
    public RootDto doSomething(@RequestBody Root root)
    {
       RootDto message = mapper.whenMapGameWithExactMatch_thenConvertsToDTO(root);
       String msg = message.toString();
       LOGGER.info("Send message: {}", msg);
       ObjectMapper mapper = new ObjectMapper();
       String json = "";
       try{
         json = mapper.writeValueAsString(message);
       }
       catch (JsonProcessingException e) {}
       System.out.print("-----------------------------------------------"+msg);
       byte[] responseBytes = tcpClientGateway.send(json.getBytes());
       String response = new String(responseBytes);
       LOGGER.info("Receive response: {}", response);
       System.out.print("------------------------------------------------"+message);
       return message;
    }
    
}
