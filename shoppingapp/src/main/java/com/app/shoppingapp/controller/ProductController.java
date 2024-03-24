package com.app.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.shoppingapp.entity.Product;
import com.app.shoppingapp.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@PostMapping("/{productId}/addImage")
	public ResponseEntity<Product> addProductImage(@PathVariable("productId")Long productId, @RequestParam("imageFile")MultipartFile imageFile){
		Product addedProductImage = productService.addProductImage(productId, imageFile);
		return new ResponseEntity<Product> (addedProductImage,HttpStatus.CREATED);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId")long productId){
		Product productDtls = productService.getProductDtls(productId);
		return new ResponseEntity<Product> (productDtls,HttpStatus.OK);
	}
	
	@GetMapping("/images/{productId}")
	public ResponseEntity<byte[]> getProductImages(@PathVariable("productId")Long productId){
		List<byte[]> productImagesList = productService.getProductImages(productId);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(productImagesList.get(0));
	}
}
