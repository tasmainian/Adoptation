/**
 * @author Tasmiha Hassan 
 * @date March 15, 2018
 */
package cas.xb3.adoptation.framework;

import java.io.*;  
import java.util.*;

public class Tree {
	private Node root;
	private Scanner c;
	private String[] list;
	private String type;
	
	public Tree() {
		c = new Scanner(System.in);
		root = new Node("");
		list = new String[5];
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
				String[] list = {"MASTIFF", "SHEEPDOG", "SIGHTHOUND"};
				setList(list);
				setType("A");
			}
			else if ((root.text).equals("You're a Type B personality, mid sized dogs are a best fit for you")){
				String[] list = {"COLLIE", "HOUNDS", "MIX", "POINTER", "SETTER/RETRIEVE"};
				setList(list);
				setType("B");}
			else if ((root.text).equals("You're a Type C personality, small dogs are a best fit for you")){
				String[] list = {"POODLE", "SPANIEL", "SPITZ", "TERRIER", "TOY"};
				setList(list);
				setType("C");}
			else if ((root.text).equals("You're a Type D personality, hybrid cats are a best fit for you")){
				String[] list = {"MIX"};
				setList(list);
				setType("D");}
			else if ((root.text).equals("You're a Type E personality, domestic cats are a best fit for you")){
				String[] list = {"MIX"};
				setList(list);
				setType("E");}
			else if ((root.text).equals("You're a Type F personality, short hair/ hairless cats are a best fit for you")){
				String[] list = {"SHORTHAIR"};
				setList(list);
				setType("F");}
			else if ((root.text).equals("You're a Type G personality, long hair cats are a best fit for you")){
				String[] list = {"LONGHAIR"};
				setList(list);
				setType("G");}
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
	
	public void setList(String[] l){
		list = new String[l.length];
		for (int i = 0; i < l.length; i++){
			list[i] = l[i];
		}
	}
	
	public String[] getList(){
		return this.list;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
}