package com.app.dao;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class FileDao implements IFileDao {
	@PersistenceContext //JPA anno.
	private EntityManager mgr;
	@Override
	public String addFile(byte[] file) {
		// TODO Auto-generated method stub
		System.out.println("in add file");
		
		
		getFile();
		return null;
	}

	@Override
	public byte[] getFile() {
		// TODO Auto-generated method stub
		Image img =mgr.find(Image.class, 1);
		/* ? */
		
		
		File file = new File("src\\main\\resources\\static\\image\\productimage\\"+"1");

		if(file.exists()!=true)
			file.mkdir();
		String path="src/main/resources/static/image/productimage/"+"1"+"/front.jpg"; 
		  // alternatively, file.getInputStream(); // application logic 
		  try (FileOutputStream stream = new FileOutputStream(path)) {
			  System.out.println("in try gggggg");

			/*    stream.write(img.getFront());*/
			}
		  catch(Exception e)
		  {
			  System.out.println("in catch");
		  }
		return null;
		/*return img.getFront();*/
	}

}
