package com.zhwxp.sample.spring.boot.tcp.server.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zhwxp.sample.spring.boot.tcp.server.domain.Body;
import com.zhwxp.sample.spring.boot.tcp.server.domain.Header;
import com.zhwxp.sample.spring.boot.tcp.server.domain.Response;
import com.zhwxp.sample.spring.boot.tcp.server.domain.Root;

@Service
public class ResponseMapper {

     public String createResponse(String messageContent){

        JSONObject obj = new JSONObject(messageContent);
        Root root = new Root();
        root.setId(obj.getString("id"));
        root.setMsgType("RobotTaskResponseMsg");
        Response response = new Response();
        Header header = new Header();
        header.setCode(0);
        header.setMsg("Success");
        JSONObject req = obj.getJSONObject("request");
        JSONObject head = req.getJSONObject("header");
        //String firstName = pilot.getString("firstName");
        header.setResponseId(head.getString("requestId"));
        Body body = new Body();
        body.setTaskId(38);
        response.setBody(body);
        response.setHeader(header);
        root.setResponse(response);
        Gson gson = new Gson();
        String employeeJsonString = gson.toJson(root);
        return employeeJsonString;

     }
    
}
