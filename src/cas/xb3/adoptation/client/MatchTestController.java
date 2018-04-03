package cas.xb3.adoptation.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import cas.xb3.adoptation.framework.Tree;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MatchTestController {
	
	@FXML
	private Button btnYes, btnNo;
	@FXML
	private TextArea txtArea;
	
	public static final String QUESTIONAIRE = "data/question.txt";
	public static PipedInputStream input;
	public static PipedOutputStream output;
	
	
	public void appendText(String str) {
	    
	    Platform.runLater(new Runnable() {
	    		@Override
	    		public void run() {
	    			if (txtArea.getText().length() != 0 && txtArea.getText(txtArea.getText().length() - 1, txtArea.getText().length()).equals("?")) {
	    				// last character is a question mark, can remove old question
	    				txtArea.clear();
	    			}
	    			txtArea.appendText(str);
	    		}
	    });
	}
	
	@FXML
	private void initialize() {
		
		output = new PipedOutputStream();
		try {
			input = new PipedInputStream(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				appendText(String.valueOf((char) b));
			}
		};
		System.setOut(new PrintStream(out, true));
		
		
		
		
		TestRunnable myRunnable = new TestRunnable(); 
		Thread myThread = new Thread(myRunnable);
		myThread.setDaemon(true);
		myThread.start(); 
	}

	@FXML
	public void onYesPress() {
		String response = "y\n";
		try {
			output.write(response.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void onNoPress() {
		String response = "n\n";
		try {
			output.write(response.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class TestRunnable implements Runnable {

		@Override
		public void run() {
			
			System.setIn(input);
			
			Tree questions = new Tree();
			
			
		     //loading the questions into the tree object
				try {
					questions.read(new Scanner(new File(QUESTIONAIRE)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     
		     System.out.println();

		     //going down the tree with the answers from the user
		     while (questions.ask().left == null && questions.ask().right == null){
		         questions.ask();
		     }
		     System.out.println();
		     System.out.println(Arrays.toString(questions.getList()));
			
		}
		
	}

}
