package com.hzs.rc.controller;

import com.hzs.rc.dto.OrderDTO;
import com.hzs.rc.service.OrderService;
import com.hzs.rc.vo.OrderV0;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public void insertOrder(@RequestBody OrderDTO orderDTO) {
        orderService.InsertOrder(orderDTO);
    }

    @GetMapping("getInpay")
    public List<OrderV0> getOrder(String userId) {
        return orderService.getOrderV0List(Integer.valueOf(userId));
    }

    @GetMapping("getPay")
    public List<OrderV0> getOrderPaied(String userId) {
        return orderService.getOrderV0ListPaied(Integer.valueOf(userId));
    }
}
