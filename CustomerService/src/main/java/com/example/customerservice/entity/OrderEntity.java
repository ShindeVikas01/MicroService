package com.example.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="orderstb")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int oid;
    private String odate;
    private String oitem;
    private int oamount;
    @ManyToOne
    @JoinColumn(name = "cid")
    private CustomerEntity customer;


}
