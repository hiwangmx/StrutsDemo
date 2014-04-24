package com.star.factory.reflect.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Init {

	public static Properties getPro(){
		Properties pro = new Properties();
		File file = new File("src/fruit.properties");
		if(file.exists()){
			InputStream input = null;
			try {
				input = new FileInputStream(file);
				pro.load(input);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(input != null){
					try {
						input.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}else{
			pro.setProperty("Apple", "com.star.factory.Apple");
			pro.setProperty("Orange", "com.star.factory.Orange");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
				pro.store(output, "Fruit Class");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(output != null){
					try {
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return pro;
	}
	
}
