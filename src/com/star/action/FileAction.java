package com.star.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.star.action.base.BaseAction;

public class FileAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String savePath;
	
	public String toUpload(){
		
		return "toUpload";
	}
	
	public String execute(){
		InputStream input = null;
		OutputStream ouput = null;
		File toFile = new File(this.getSavePath() + File.separator + this.getFileFileName());
		//File toFile = new File("E://images/" + this.fileFileName);
		try {
			//如果文件夹路径问空，创建文件夹路径
			if(!toFile.getParentFile().exists()){
				toFile.getParentFile().mkdirs();
			}
			if(toFile.createNewFile()){
				input = new FileInputStream(this.getFile());
				//ouput = new FileOutputStream(this.getSavePath() + File.separator + this.getFileFileName());
				ouput = new FileOutputStream(toFile);
				byte[] tempCache = new byte[1024];
				while(input.read(tempCache) > 0){
					ouput.write(tempCache);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != ouput){
				try {
					ouput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != input){
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return SUCCESS;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = this.getRequest().getSession().getServletContext().getRealPath(savePath);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	
	
}
