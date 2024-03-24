package com.app.shoppingapp.model;

import org.springframework.http.MediaType;

public class ImageResponse {

	 private byte[] imageData;
	 private MediaType contentType;
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public MediaType getContentType() {
		return contentType;
	}
	public void setContentType(MediaType contentType) {
		this.contentType = contentType;
	}
	   
	 
}
