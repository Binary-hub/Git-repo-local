package com.modelMapDemo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modelMapDemo.demo.domain.Root;
import com.modelMapDemo.demo.domain.RootDto;
import com.modelMapDemo.demo.service.GeekMapper;

@RestController
public class GeekRestController {

    @Autowired
    GeekMapper mapper;

    @PostMapping("/")
    public RootDto doSomething(@RequestBody Root root)
    {
       return mapper.whenMapGameWithExactMatch_thenConvertsToDTO(root);
    }
    
}
