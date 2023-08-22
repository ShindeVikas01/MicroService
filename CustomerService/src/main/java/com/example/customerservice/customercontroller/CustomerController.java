package com.example.customerservice.customercontroller;

import com.example.customerservice.entity.CustomerEntity;
import com.example.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/api")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

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
        CustomerEntity customerEntity=customerRepo.findById(cid).get();
        return customerEntity;
    }
}
