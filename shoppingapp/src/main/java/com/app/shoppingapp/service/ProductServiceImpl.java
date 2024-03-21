package com.app.shoppingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shoppingapp.dao.IProductRepository;
import com.app.shoppingapp.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductRepository productRepo;

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

}
