package com.app.shoppingapp.service;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.shoppingapp.dao.IProductRepository;
import com.app.shoppingapp.entity.Image;
import com.app.shoppingapp.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepo;

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	public Product addProductImage(Long productId, MultipartFile imageFile) {
		String imagePath = StringUtils.cleanPath(imageFile.getOriginalFilename());
		String imageFullPath = "D:\\SpringBoot_Prc\\" + imagePath;
		Product exiProduct = productRepo.findById(productId).orElse(null);

		Image image = new Image();
		image.setImageName(imageFile.getOriginalFilename());
		image.setImageType(imageFile.getContentType());
		image.setImagePath(imageFullPath);

		if (exiProduct != null) {
			Set<Image> imageSet = exiProduct.getImages();
			imageSet.add(image);
			exiProduct.setImages(imageSet);
			exiProduct = productRepo.save(exiProduct);
		}
		return exiProduct;
	}

	@Override
	public Product getProductDtls(Long productId) {
		Product exiProduct = productRepo.findById(productId).orElseThrow(()->new RuntimeException("Not found!!!"));
		return exiProduct;
	}

	@Override
	public List<byte[]> getProductImages(Long productId) {
		Product exiProduct = productRepo.findById(productId).orElseThrow(()->new RuntimeException("Not found!!!"));
		Set<Image> images = exiProduct.getImages();
		List<byte[]> byteArrList = new ArrayList<byte[]>();
		for(Image imgElt : images) {
			String imagePath = imgElt.getImagePath();
			try {
				byte[] imgBytes = Files.readAllBytes(new File(imagePath).toPath());
				byteArrList.add(imgBytes);
			}catch(Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		return byteArrList;
	}
}
