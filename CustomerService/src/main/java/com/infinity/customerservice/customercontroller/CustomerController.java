package com.infinity.customerservice.customercontroller;

import com.infinity.customerservice.entity.CustomerEntity;
import com.infinity.customerservice.entity.OrderEntity;
import com.infinity.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("customer/api")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/addcustomer")
    public CustomerEntity addcustomer(@RequestBody CustomerEntity customerEntity) {
        return customerRepo.save(customerEntity);
    }

    @GetMapping("/getallcustomer")
    public List<CustomerEntity> getallcustomer(){
        return customerRepo.findAll();
    }

    @GetMapping("/getcustomerbyid/{cid}")
    public CustomerEntity getcustomerbyid(@PathVariable("cid")int cid){
        CustomerEntity customer=customerRepo.findById(cid).get();
        List<OrderEntity> order=restTemplate.getForObject("http://orderservice/order/api/getorderbycid/"+cid,List.class);
        customer.setOrderList(order);
        return customer;
    }
}
