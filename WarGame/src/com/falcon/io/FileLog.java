package com.falcon.io;

import java.io.File;
import java.io.FileWriter;

public class FileLog extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 208438101929954252L;
	
	private String message;
	
	public FileLog(String message) {
		this.message = message;
	}
	
	public void saveLog(String report) {
		try {
			File file = new File("Filelog.txt");
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.write(report);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception error) {
			System.out.println("explotó : "+ error.getMessage());
		}
	}
}
