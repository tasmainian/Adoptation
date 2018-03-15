/**
 * @author Tasmiha Hassan
 * @date March 15, 2018
 */
import java.io.*; 
import java.util.*;

public class MainQ {
 public static final String QUESTIONAIRE = "data/question.txt";
 private static Scanner c = new Scanner(System.in);

 public static void main(String[] args) throws FileNotFoundException {
     System.out.println("Let's find you the perfect pet!");
     System.out.println();
     
     
     //prompt to begin
	 System.out.print("Would you like to begin (y/n)? ");
	 String response = c.nextLine().trim().toLowerCase();
	 while (!response.equals("y") && !response.equals("n")) {
			System.out.println("Please answer y or n.");
	        System.out.print("Would you like to begin (y/n)? ");
	        response = c.nextLine().trim().toLowerCase();
	 }
	 
	 //creating a Tree object
     Tree questions = new Tree();
     
     //loading the questions into the tree object
     if (response.equals("y"))
         questions.read(new Scanner(new File(QUESTIONAIRE)));
     else if (response.equals("n"))
    	 System.exit(0);
     
     System.out.println();

     //going down the tree with the answers from the user
     while (questions.ask().left == null && questions.ask().right == null){
         questions.ask();
         System.out.println();
     }
     //System.out.println(questions.list);
    }
}
