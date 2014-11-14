package part3;

//input getting 
import javax.swing.*;

import java.io.*;


public class part3 {

   //main method 
	public static void main(String[] args) throws IOException
	{
		//for user input 
		String input;
		//get input now 
		input=JOptionPane.showInputDialog("1 to set password, \n"+"2 to unlock message");
		//this file will be set and opened
		File file = new File("password.passwd");
		
		//test for entering or setting the password 
		if(input.equals("1"))
		{
			String p= JOptionPane.showInputDialog("Enter the password to set");
			
			// this is for the output ;
			FileOutputStream outStream = new FileOutputStream(file);
			PrintWriter out= new PrintWriter(outStream);
			
			//set the psswd
			out.println(p);
			
			//close it all
			out.flush();
			out.close();
			outStream.close();
			
			
		}
		else 
		{
			//first, we must get the password
			FileReader fr= new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			
			//this is the pssw in file 
			
			String password = buffer.readLine();
			
			// users attempted guess
			String userPass;
			userPass = JOptionPane.showInputDialog("Enter your guess");
			
			//test the password 
			
			if(password.equals(userPass))
			{
				//if correct
				JOptionPane.showMessageDialog(null, "Correct");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong!!");
			}
		}
	}
	
	
}
