package com.zhwxp.sample.spring.boot.tcp.server.service.impl;

//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
import com.zhwxp.sample.spring.boot.tcp.server.service.MessageService;
import com.zhwxp.sample.spring.boot.tcp.server.service.ResponseMapper;

//import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
    @Autowired
    ResponseMapper mapper;

    @Override
    public byte[] processMessage(byte[] message) {
        String messageContent = new String(message);
        LOGGER.info("Receive message: {}", messageContent);
        boolean validMsg = validate(messageContent);
        LOGGER.info("Is it Valid format: {}", validMsg);
        String responseContent ="";
        if(validMsg == true){
            String res = mapper.createResponse(messageContent); 
            responseContent = String.format("*********************Message \"%s\" is processed************************", res);

        }
        return responseContent.getBytes();
    }

    @Override
    public boolean validate(String msgContent){

        boolean areTheyEqual = false;
        //LOGGER.info("INSIDE VALIDATE - ARETHEYEQUAL INITIAL VALUE : {}", areTheyEqual);
        System.out.println("---------");
        JSONObject obj2 = new JSONObject(msgContent);
        System.out.println("---- FROM MODEL MAPPER SERVICE -----"+ obj2);
        try{  
        String format = "/standardFormat.json";
        InputStream input = MessageServiceImpl.class.getResourceAsStream(format);
        JSONTokener tokener = new JSONTokener(input);
        JSONObject obj1 = new JSONObject(tokener);
        LOGGER.info("------------INSIDE VALIDATE - FROM FILE---------- : {}", obj1);

        //Object myJSON = msgContent;  
        
        //JsonParser obj3 = JsonParser.parse(obj1);
        //JSONObject obj3 = (JSONObject)obj2.parse(msgContent);
        //LOGGER.info("INSIDE VALIDATE - COMPARING OBJECTS: {}", myJSON.equals(obj1));
        //ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        //String json = ow.writeValueAsString(myJSON);
       
        //LOGGER.info("INSIDE VALIDATE - OBJECT FROM CLIENT AS STRING : {}", obj2);
        

		ObjectMapper mapper = new ObjectMapper();   
        //String jsonString1 = mapper.writeValueAsString(obj1);  
        //LOGGER.info("-----------------STRING 1 ----------------- : {}", jsonString1);
        //String jsonString2 = mapper.writeValueAsString(obj2); 
        //LOGGER.info("-----------------STRING 2 ----------------- : {}", jsonString2);

        JsonNode tree1 = mapper.readTree(obj1.toString());
        LOGGER.info("-----------------TREE 1 ----------------- : {}", tree1);
        JsonNode tree2 = mapper.readTree(obj2.toString());
        LOGGER.info("-----------------TREE 2 ----------------- : {}", tree2);

        areTheyEqual = tree1.equals(tree2);
        System.out.println("-------------------areTheyEqual-------------------"+ areTheyEqual);
        //assertEquals(expected, actual);
        }
        catch(Exception e){

        }
        //LOGGER.info("INSIDE VALIDATE - AFTER COMPARING BEFORE RETURN : {}", areTheyEqual);
        return areTheyEqual;
    }

}
