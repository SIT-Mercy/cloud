package com.gallifrey.mercyhouse.controller;

import com.gallifrey.mercyhouse.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/oder/all")
    public List getOrderAndUser(){
        return orderMapper.selectAllOderAndUser();
    }

}
