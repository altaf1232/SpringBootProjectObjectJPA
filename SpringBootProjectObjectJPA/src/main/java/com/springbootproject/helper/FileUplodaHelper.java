package com.springbootproject.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUplodaHelper {
	public final String Upload_dir="here is upload your file path";
	
	public boolean uploadfile(MultipartFile multipartfile) {
		
		boolean f =false;
		try {
			/*//this is first way
			 * 
			 * InputStream store= multipartfile.getInputStream(); //here is create array
			 * byte data[]=new byte[store.available()]; store.read(data);
			 * 
			 * //write FileOutputStream fos=new
			 * FileOutputStream(Upload_dir+" "+multipartfile.getOriginalFilename());
			 * fos.write(data); fos.flush(); fos.close(); f=true;
			 */
		    Files.copy(multipartfile.getInputStream(), Paths.get(Upload_dir+File.separator+ multipartfile.getOriginalFilename())
		    ,StandardCopyOption.REPLACE_EXISTING);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return f;
	}

}
