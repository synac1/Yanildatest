package project1;

import javax.swing.*;
public class part1 {
	//main method
	public static void main(String[] args)
	{
		//this string will hold user's input
		String input;
		
		//get the input now
		input=JOptionPane.showInputDialog("Enter the secret message. ");
		
		//test for correctness "Evil genius is {the secret message"
		if(input.equals("Evil genius "))
		{
			//user got it right
			System.out.println("You got the correct answer");
		}
		//else
		else
		{
			System.out.println("Wrong");
		}
		
	}

}
