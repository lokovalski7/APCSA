/* Lola Kovalski
Project 3.5
Computes an employee's total weekly pay based on daily overtime hours, daily regular hours, and hourly wage
   uses StringTokenizer as well as external data
   https://docs.oracle.com/javase/7/docs/api/ was used for reference
   
   
   This week's reflection: Frankly, this week was complete torture. I hardly understood string tokenizer and relied on java docs more than ever. 
   I feel very uncomfortable with dealing with external data, but, java docs and heavy commenting helped me to make a little progress.
   This week I also got even more familiar with methods, because of this program. Initially, I did not use methods, but after further revision I realized how much more organized they would make my code
   
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class totalWeeklyPayReloaded {
		 private static FileInputStream inFile;         // used to obtain bytes from an external file
		 private static InputStreamReader inReader;     //used to convert the bytes found above to character streams  
		 private static  BufferedReader reader;        // reads from character input stream (the thing above)
		 private static StringTokenizer strTkn;        // breaks strings into tokens
		 private static String line, word;
		 private static String firstname, surname;    //initializes variable for the user's first and last name
		 private static double totalRegHours, totalOverHours, wage, totalPay;  // initializes basic variables used in computation
		 
		 
		 public static void main (String args[]) throws IOException  //IOexception helps system better deal with problems while importing the file
		  {

		    retrieveFile();   //method that retrieves file and breaks the file into character input streams and reads from it
		    getData();    //method
		    calculateResults();  // method that does the calculation
		    printResults(); //method that delivers the output data in a user friendly way
		    
		    
		    inFile.close();// closes text file
		  }


		private static void retrieveFile() throws FileNotFoundException {
			inFile = new FileInputStream ("VHSP35data1.txt");  //imports the file with user's information
		    inReader = new InputStreamReader(inFile);      //converts bytes in the text file to characters
		    reader = new BufferedReader(inReader);       // reads the characters
		}
		private static void getData() throws IOException{
			line = reader.readLine();   //processes the data from the text file in the form of a string
		    System.out.println ("data line = " + line ); // converts the string found above to one string
		    System.out.println();
		    
		    strTkn = new StringTokenizer(line);
   
		    firstname = strTkn.nextToken(); //setting firstname to the first token in the text file/ string
		     
		    
		    surname = strTkn.nextToken(); //sets surname to the next token in the data using Stringtokenizer
		    
		    // calculates and store values for totalRegHours, totalOverHours, and wage using string tokenizer
		    wage = Double.parseDouble(strTkn.nextToken()); 
		    totalRegHours = Double.parseDouble(strTkn.nextToken());
		    totalOverHours = Double.parseDouble(strTkn.nextToken());
		    totalRegHours = totalRegHours + Double.parseDouble(strTkn.nextToken());
		    totalOverHours = totalOverHours + Double.parseDouble(strTkn.nextToken());
		    totalRegHours = totalRegHours + Double.parseDouble(strTkn.nextToken());
		    totalOverHours = totalOverHours + Double.parseDouble(strTkn.nextToken());
		    totalRegHours = totalRegHours + Double.parseDouble(strTkn.nextToken());
		    totalOverHours = totalOverHours + Double.parseDouble(strTkn.nextToken());
		    totalRegHours = totalRegHours + Double.parseDouble(strTkn.nextToken());
		    totalOverHours = totalOverHours + Double.parseDouble(strTkn.nextToken());
		  }  
				

		
		private static void calculateResults() {
			totalPay = (totalRegHours * wage) + (totalOverHours * (wage * 1.5));   //does the actual math
		}
		
		private static void printResults() {
			System.out.println(firstname + " " + surname + "earned " + totalPay + " dollars this week.");  //prints descriptive output
		}
		
		
	}

