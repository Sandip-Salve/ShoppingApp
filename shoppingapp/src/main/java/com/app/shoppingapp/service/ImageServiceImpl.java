package com.app.shoppingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.shoppingapp.dao.ImageRepository;
import com.app.shoppingapp.entity.Image;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepository imageRepo;
	
	public Image addImage(Image image) {
		return imageRepo.save(image);
	}
}
