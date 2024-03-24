package com.app.shoppingapp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.shoppingapp.entity.Product;

public interface IProductService {

	public Product addProduct(Product product);
	
	public Product addProductImage(Long productId, MultipartFile imageFile);
	
	public Product getProductDtls(Long productId);
	
	public List<byte[]> getProductImages(Long productId);
}
