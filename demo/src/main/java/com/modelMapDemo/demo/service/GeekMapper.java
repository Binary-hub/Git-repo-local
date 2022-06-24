package com.modelMapDemo.demo.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.modelMapDemo.demo.domain.Root;
import com.modelMapDemo.demo.domain.RootDto;

@Service
public class GeekMapper {
    

public RootDto whenMapGameWithExactMatch_thenConvertsToDTO(Root root) {
    // when similar source object is provided
    ModelMapper modelMapper = new ModelMapper();
    Root game = root;
    RootDto gameDTO = modelMapper.map(game, RootDto.class);
    
    // then it maps by default
    return gameDTO;
    
    //assertEquals(game.getId(), gameDTO.getId());
    //assertEquals(game.getMsgType(), gameDTO.getMsgType());
}
}
