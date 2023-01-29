package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Optional;
import java.util.stream.Stream;

public class FileOperations {
	public File fileList = new File("C:\\Users\\NeacsuR\\eclipse-workspace\\JavaFSDFullStack_NeacsuNicolaeRobert\\src\\textFiles");
	
	public void displaySortedList() {
		Stream.of(fileList.listFiles())
	      .map(File::getName)
	      .forEach(f -> System.out.println(f));
	}
	
	public void deleteFile(String fileName) throws Exception {
		Optional<File> stream;
		stream = Stream.of(fileList.listFiles())
	      .filter(f -> f.getName().contentEquals(fileName))
	      .findFirst();
	      
		if(stream.isPresent()) {
			File fileToDelete = new File(stream.get().getAbsolutePath());
			fileToDelete.delete();
			System.out.println("File deleted!");
		}
		else {
			throw new Exception("File not found!");
		}
	}
	
	public void createFiles(String filename, String content) throws Exception {
		File fileToCreate = new File("C:\\Users\\NeacsuR\\eclipse-workspace\\JavaFSDFullStack_NeacsuNicolaeRobert\\src\\textFiles\\"+filename);
		if(fileToCreate.createNewFile()) {
			FileWriter writer = new FileWriter(fileToCreate.getAbsolutePath());
			writer.write(content);
			writer.close();
			System.out.println("File created!");
		}
		else {
			throw new Exception("File already exists!");
		}
	}
	
	public void readFiles(String fileName) throws Exception {
		Optional<File> stream;
		stream = Stream.of(fileList.listFiles())
	      .filter(f -> f.getName().contentEquals(fileName))
	      .findFirst();
		
		if(stream.isPresent()) {
			File fileToRead = new File(stream.get().getAbsolutePath());
			BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
			String line;
			System.out.println("The content of the file is: ");
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		else {
			throw new Exception("File not found!");
		}
	}
}  
 