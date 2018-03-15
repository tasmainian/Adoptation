/**
 * @author Tasmiha Hassan
 * @date March 15, 2018
 */
public class Node {
	public String text; //Holds the questions/answer - parent
    public Node left; //leftYes - left child
    public Node right; //rightNo = right child
                
    // leaf node constructor
    public Node(String text) {
        this(text, null, null);
    }
                        
    // branch node constructor
    public Node(String text, Node left, Node right) {
        this.text = text;
        this.left = left;
        this.right = right;
    }
	
}
