package com.example.customerservice.customercontroller;

import com.example.customerservice.entity.OrderEntity;
import com.example.customerservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/api")
public class OrderController {
    @Autowired
    OrderRepo orderRepo;

    @PostMapping("/addorder")
    public OrderEntity addorder(@RequestBody OrderEntity orderEntity){
        return orderRepo.save(orderEntity);
    }

    @GetMapping("/getorderbyoid/{oid}")
    public OrderEntity getorderbyoid(@PathVariable("oid")int oid){
        return orderRepo.findById(oid).get();
    }

    @GetMapping("/getorderbycid/{custid}")
    public List<OrderEntity> getorderbycid(@PathVariable("custid")int custid){
        return orderRepo.findOrderByCid(custid);
    }
}
