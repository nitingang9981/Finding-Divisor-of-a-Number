package Study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.NumberFormatException;
/**
 * This class DivisorException is extended from JFrame class and also implements ActionListener class.
 * It contains various data fields that we require in our GUI like JLabel, & JButton JTextfield
 * @author Nitin Gangasagar
 */
public class DivisorException extends JFrame implements ActionListener{
	//data field 
	final int WIDTH = 300; 
	final int HEIGHT = 200;
	public String divisors;
	private int num; 
	JLabel question =  new JLabel("Enter an integer to find all it divisor");
	JButton find = new JButton("Find");
	JTextField answer = new JTextField(5); 
	JLabel feedback = new JLabel(""); 
 
       //Constructor
	/**
	 * <p>In this constructor we have initialized our JFrame with super keyword.
	 * It also includes all the set methods and add methods for the GUI.</p>
	 */
       public DivisorException(){
    	 //call super class constructor
   		super("Divisor");
   		
   		//call set methods
   		setSize(WIDTH,HEIGHT);
   		setVisible(true);
   		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   		setLayout(new FlowLayout()); 
   		
   		//call add methods
   		add(question); 
   		add(answer);
   		answer.addActionListener(this);
   		add(find); 
   		find.addActionListener(this);
   		add(feedback);
       }
      
       //method
       /**
   	 * <p> This is an action performed method. We have put our critical statement in the try block
   	 * and catching all the possible exceptions.
   	 */
       
       public void actionPerformed(ActionEvent e) {
    	    try {
    	        num = Integer.parseInt(answer.getText());
    	        if (e.getSource().equals(find)) {
    	            divisors = divisor(num);
    	            feedback.setText(divisors);
//    	            answer.setText("");
    	        }

    	    } catch (NumberFormatException ex) {
    	        feedback.setText("Invalid input. Enter an integer!");
    	        answer.setText("");
    	    }
    	}
     /**
   	 * <p> In this method we are receiving a number and finding its divisors.
   	 * We are converting each divisor into a string and appending it into a string variable "divisors"
   	 * Then we are returning the variable output.</p>
   	 * @param num
   	 * @return output of String type
   	 */
       private String divisor(int num){
    	   String divisors = "";
           for(int i = 1; i <= num; i++){
               if(num % i == 0){
            	   divisors += (i + ", ");         
               }
           }
           System.out.println(divisors.length());
           divisors = divisors.substring(0,divisors.length()-2);
           return divisors;
       }
 
}