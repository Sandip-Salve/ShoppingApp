package com.app.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.shoppingapp.entity.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long>{

}
