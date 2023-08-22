package com.example.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="customertb")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String cname;
    private String cmobno;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderEntity> orderList;

    public CustomerEntity(int cid, String cname, String cmobno) {
        this.cid = cid;
        this.cname = cname;
        this.cmobno = cmobno;
    }

    public CustomerEntity(int cid, String cname, String cmobno, List<OrderEntity> orderList) {
        this.cid = cid;
        this.cname = cname;
        this.cmobno = cmobno;
        this.orderList = orderList;
    }
}
