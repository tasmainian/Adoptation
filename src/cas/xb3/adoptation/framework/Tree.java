/**
 * @author Tasmiha Hassan 
 * @date March 15, 2018
 */
import java.io.*;  
import java.util.*;

public class Tree {
	private Node root;
	private Scanner c;

	public Tree() {
		c = new Scanner(System.in);
		root = new Node("");
	}

	public void read(Scanner input) {
		root = readHelper(input);
	}
	
	private Node readHelper(Scanner input) {
		String QorA = input.nextLine();
		String text = input.nextLine();
		
		if (QorA.equals("Question:")) {
			return new Node(text, readHelper(input), readHelper(input));
		} else {
			return new Node(text);
		}
	}
	
	public Node ask() {
		return askHelper(root);
	}
	
	private Node askHelper(Node root) {
		//leaf Node
        if (root.left == null && root.right == null) { 
			System.out.print(root.text);
			if ((root.text).equals("You're a Type A personality, big dogs are a best fit for you")){
				final String[] list = {"dog", "hi"};}
		} else { //print out the question with (y/n)?
			System.out.print(root.text);
			String branchAns = c.nextLine();
			//if yes, go down the left branch recursively
			if (branchAns.equalsIgnoreCase("y")) {
				root.left = askHelper(root.left);
			//if no, go down the right branch recursively
			} else if (branchAns.equalsIgnoreCase("n")) {
				root.right = askHelper(root.right);
			} else {
				System.out.println("Please answer y or n");
				root = askHelper(root);
			}
		}
        return root;
    }
}