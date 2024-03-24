package com.app.shoppingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.shoppingapp.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

}
