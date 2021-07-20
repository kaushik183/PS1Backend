package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="image")
public class ImageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long imageId;
	@Column(name="name")
	private String imageName;
	//image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Column(name = "picByte", length = 1000)
	private byte[] picByte;
	@Column(name="tag")
	private String imageTag;
	public ImageModel() {
		super();
	}
	public ImageModel(String imageName, byte[] picByte, String imageTag) {
		super();
		this.imageName = imageName;
		this.picByte = picByte;
		this.imageTag = imageTag;
	}

	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public byte[] getImage() {
		return picByte;
	}
	public void setImage(byte[] picByte) {
		this.picByte = picByte;
	}
	public String getImageTag() {
		return imageTag;
	}
	public void setImageTag(String imageTag) {
		this.imageTag = imageTag;
	}
}
	
	

	

