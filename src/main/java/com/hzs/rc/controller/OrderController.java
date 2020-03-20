package com.hzs.rc.controller;

import com.hzs.rc.dto.OrderDTO;
import com.hzs.rc.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hanzs
 * @version 1.0
 * @description: entity
 * @Date 2020年03月20日
 */
@RestController()
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @PostMapping("/insert")
    public  void insertOrder(@RequestBody OrderDTO orderDTO) {
        orderService.InsertOrder(orderDTO);
    }
}
