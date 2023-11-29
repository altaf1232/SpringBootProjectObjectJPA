package com.springbootproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springbootproject.helper.FileUplodaHelper;

@RestController
public class FileUpLoadController {
	
	  //FileUplodaHelper class ko used karne key liye ham aapne controller ma difine karunga
	  @Autowired
	  private FileUplodaHelper fileUploadhelper; 
	
	//here is create a method this method through i will send static code 
	@PostMapping("/upload-file")
	//data ko recive karne key liye ham used karte hai (@RequestParam) 
	public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file)
	{
		/*
		 * System.out.println(file.getOriginalFilename());
		 * System.out.println(file.getSize());
		 * System.out.println(file.getContentType());
		 * System.out.println(file.getName());
		 */
		try {
			   //validation
		      if(file.isEmpty()) {
		      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must cantain file");
		      }
		      //here i am taking Photo.jpg file
		      //ya condition tab cahlega jab image/jpeg milega
		      
		     if(file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request is geting image/jpeg then excutie ");
		    }
		
		    //here is stated my new if
		    //ya condition tab chalega jab hamra image/jpeg nahi milega
		    if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request is not geting image/jpeg file then Excute ");
		    }
		    //file upload code
		    boolean f=fileUploadhelper.uploadfile(file);
		    if(f) {
		    	return ResponseEntity.ok("file is successfully uploaded");
		    }
		 }
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("some went wrong ! try");
	}

}
