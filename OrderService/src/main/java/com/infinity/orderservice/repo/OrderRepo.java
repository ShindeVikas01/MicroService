package com.infinity.orderservice.repo;

import com.infinity.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {
    @Query(nativeQuery = true,value = "SELECT * from orderstb where CID=:custid")
    List<OrderEntity> findOrderByCid(@Param("custid") int custid);
}
