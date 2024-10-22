package intopost;

import java.util.Scanner;



public class intopostapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.err.println("Enter Inflix String:");
		String st=sc.next();
		Stackinfixtopostfix S1=new Stackinfixtopostfix(st);
		String str=S1.ConvertIntoPost(st);
		if(str.length()==1)
		{
			System.err.println("Invalid Operatrion");
		}
		else
		{
			System.err.println("Postflix Expression: "+str);
		}

	}
	

}
