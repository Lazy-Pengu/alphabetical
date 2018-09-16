/*
 * Program that takes a PDF file and alphabetizes it's words based on ASCII 
 * numbering system
 */
import java.io.File;

import java.io.IOException;
import java.util.*;

//import PDFBox for reading PDF document
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;



public class Main {

	public static void main(String[] args) throws IOException {
		
		//initialize File object with local PDF file and loads it
		File pdf = new File("C:/Users/lukev/Documents/Eclipse Files/Alphabetical/test-document.pdf");
		PDDocument document = PDDocument.load(pdf);
		
		//strip an encryptions on the file
		PDFTextStripper stripper = new PDFTextStripper();
		
		//convert PDF into String
		String textRetrieved = stripper.getText(document);
		
		//test to see if PDF is being converted 
		System.out.println(textRetrieved);
		
		//splits individuals words up at each " " and create a string array
		String[] textSplit = textRetrieved.split(" ");
		
		//close document
		document.close();

		
		//initialize char array to hold individual letters of string
		char[] characters = null;

		for (int i = 0; i < textSplit.length; i++) {
			
			//takes individual letters of string and places it in char array
			characters = textSplit[i].toCharArray();
			
			//alphabetize sets of letters of a string
			Arrays.sort(characters);
			
			//places chars into string 
			String sortedString = new String(characters);	
			System.out.println(sortedString);
 		}
		
	}
}
