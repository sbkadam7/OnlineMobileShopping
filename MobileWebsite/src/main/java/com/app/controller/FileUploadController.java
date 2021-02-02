package com.app.controller;

import java.io.FileOutputStream;
import java.io.IOException;
//import org.apache.commons.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.service.IStorageService;
@Controller 
public class FileUploadController {
	@Autowired
	private IStorageService service;

	public FileUploadController() {
		super();
		System.out.println("In constructor of" + getClass().getName());
	}
	@PostMapping("/AddFile")
	public void handleUpload(@RequestParam("front") MultipartFile file) throws IOException {
		System.out.println("In handleUpload of" );

	    if (!file.isEmpty()) {
			System.out.println("In handleUpload of 1" );

	            byte[] bytes = file.getBytes();
	            
	            service.addFile(bytes);
				
				 /* String path="src/main/resources/static/image/productimage/front.jpg"; 
				  // alternatively, file.getInputStream(); // application logic 
				  try (FileOutputStream stream = new FileOutputStream(path)) {
					  System.out.println("in try");

					    stream.write(bytes);
					}
				  catch(Exception e)
				  {
					  System.out.println("in catch");
				  }
				 
	    }
	    else {
			System.out.println("In handleUpload of 2" );

	    }*/
	}
	
}}
