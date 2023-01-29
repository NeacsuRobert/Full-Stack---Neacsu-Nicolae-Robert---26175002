package com;

import java.io.File;
import java.util.Scanner;

import com.FileOperations;
public class main {
	
		public static void main(String[] args) throws Exception {
			FileOperations operator = new FileOperations();
			Scanner userInput = new Scanner(System.in);
			String answer;
			String content;
			System.out.println("Welcome to LockedMe.com project, developed by Neacsu Nicolae-Robert! ");
			System.out.println("Please insert 1 for the list of the available files.");
			System.out.println("Please insert 2 to display the file operations available.");
			System.out.println("Please insert 3 to close the app");
			answer = userInput.nextLine();
			if(answer.contentEquals("1")) {
				operator.displaySortedList();
			}
			else {
				if(answer.contentEquals("2")) {
					System.out.println("1: Add a file.");
					System.out.println("2: Delete a file");
					System.out.println("3: Search a file");
					System.out.println("4: Back to main menu");
					answer = userInput.nextLine();
					switch (answer) {
					case "1":  System.out.println("Input the name of the file you wish to create");
							    answer = userInput.nextLine();
							    System.out.println("Write the content of the file");
							    content = userInput.nextLine();
							    operator.createFiles(answer, content);
							    break;
					case "2":  System.out.println("Input the name of the file you wish to delete");
								answer = userInput.nextLine();
								operator.deleteFile(answer);
								break;
					case "3": System.out.println("Input the name of the file you wish to read");
								answer = userInput.nextLine();
								operator.readFiles(answer);
								break;
					case "4": main(args);
					}
				}
				else {
					if(answer.contentEquals("3")) {
						System.exit(0);
					}
				}
			}

		}		
}
