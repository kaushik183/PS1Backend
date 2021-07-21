package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController


@RequestMapping(path = "/image")
public class ImageController {
	@Autowired
	ImageRepository imageRepository;
	
	@GetMapping("/")
	public java.util.List<ImageModel> allImages(){
		java.util.List<ImageModel> myList=imageRepository.findAll();
		for(ImageModel image:myList) {
			image.setImage(decompressBytes(image.getImage()));
		}
		Collections.reverse(myList);
		return myList;
	}
	
	@PostMapping("/addImage/{id}")
	public boolean uploadImage(@PathVariable (value="id") String tag,@RequestParam("imageFile") MultipartFile file) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(),compressBytes(file.getBytes()),tag);
		imageRepository.save(img);
		return true;
	}
	
	@GetMapping("/profile/{id}")
	public java.util.List<ImageModel> reteriveprofile(@PathVariable (value="id") String username)
	{
		java.util.List<ImageModel> myList=imageRepository.findByUsername(username);
		for(ImageModel image:myList) {
			image.setImage(decompressBytes(image.getImage()));
		}
		Collections.reverse(myList);
		return myList;
	}
	
	
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

			return outputStream.toByteArray();
		}

		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}

		@GetMapping()
	public java.util.List<ImageModel> allImages1(){
		java.util.List<ImageModel> myList=imageRepository.findAll();
		for(ImageModel image:myList) {
			image.setImage(decompressBytes(image.getImage()));
		}
		Collections.reverse(myList);
		return myList;
	}
	
	
	@GetMapping("/{id}")
	public ImageModel getimageById(@PathVariable (value="id") String id) {
		return imageRepository.findById(Long.parseLong(id)).orElseThrow();
	}
	
}


