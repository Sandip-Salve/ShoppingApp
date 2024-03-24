package com.app.shoppingapp.model;

import java.util.List;

public class ImageListResponse {

	private List<ImageResponse> images;
	
	public ImageListResponse(List<ImageResponse> images) {
		this.images = images;
	}

	public List<ImageResponse> getImages() {
		return images;
	}

	public void setImages(List<ImageResponse> images) {
		this.images = images;
	}
	
}
