package part2;

//first allow input getting 
import javax.swing.*;
public class part2 {
	// method throws exception added for thread.sleep()
	public static void main(String[] args) throws Exception
	{
		//this is  how many 1/2 a second the user gets
		int difficulty;
		difficulty= Integer.parseInt(JOptionPane.showInputDialog("How are you? \n"+"1=evil genius...\n"+"10= evil but not a evil  genius"));
		
		//flag to continue or not 
		boolean cont= false;
		
		// do while loop to enclose the content of th emain method
		do
		{
			//reset cont to false
			cont= false;
			
			//random number for the equation
			double num1= (int)(Math.round(Math.random()*10));
			
			double num2;
			do 
			{
				num2=(int)(Math.round(Math.random()*10));
			}
			while(num2==0.0);//if it's zero do it again
			
			//random number for sign
			int sign =(int)(Math.round(Math.random()*10));
			//will store the answers
			double answer;
			
			// make stuff noticeable
			System.out.println("\n\n********");
			
			if(sign==0)
			{
				System.out.println(num1+" times "+num2);
				answer=num1*num2;
			}
			else if(sign==1)
			{
				System.out.println(num1+" divided "+num2);
				answer=num1/num2;
			}
			
			else if(sign==1)
			{
				System.out.println(num1+" minus "+num2);
				answer=num1-num2;
			}
			else
			{
				System.out.println(num1+" % "+num2);
				answer=num1%num2;
			}
			
			for(int i=difficulty; i>=0; i--)
			{
				System.out.println(i+"...");
				
				Thread.sleep(500);
			}
			
			//print the answer
			System.out.println("Answer:: "+ answer);
			
			String again;
			again=JOptionPane.showInputDialog("Play again? ");
			
			//if the user says yes set cont to true 
			if(again.equals("yes"))
				cont=true;
		}
		while(cont);//until cont is false
		
		
	}
	

}
