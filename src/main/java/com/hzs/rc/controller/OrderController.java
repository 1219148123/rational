package com.hzs.rc.controller;

import com.hzs.rc.dto.OrderDTO;
import com.hzs.rc.service.OrderService;
import com.hzs.rc.service.UserDetailService;
import com.hzs.rc.vo.OrderV0;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Resource
    UserDetailService userDetailService;

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

    @Transactional
    @PostMapping("/updatePayStatus")
    public void updatePayStatus(@RequestParam("orderId") String orderId, @RequestParam("userId") String userId, @RequestParam("spent") Double spent, HttpServletRequest httpServletRequest) {
        orderService.updatePayStatus(Integer.valueOf(orderId), Integer.valueOf(userId), spent);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("hzsUser", userDetailService.getUserDetail(Integer.valueOf(userId)));
    }
}
