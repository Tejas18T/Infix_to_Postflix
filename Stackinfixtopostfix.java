package intopost;

public class Stackinfixtopostfix {
		private int size;
		private int top;
		private char stack[];
		
		Stackinfixtopostfix()
		{
			size=0;
			top=-1;
		}
		Stackinfixtopostfix(String str)
		{
			size=str.length();
			top=-1;
			stack=new char[size];
		}
		public boolean IsFull()
		{
			return (top==size-1);
		}
		public boolean IsEmpty()
		{
			return (top==-1);
		}
		public void push(char data)
		{
			if(!IsFull())
			{
			  stack[++top]=data;
			}	
			else
			{
				System.out.println("Stack Overflow!!");
			}
			
		}
		public char pop()
		{
			char a='\0';
			if(!IsEmpty())
			{
				return stack[top--];
			}
			return a;
		}
		public char peek()
		{
			char a='\0';
			if(!IsEmpty())
			{
				return stack[top];
			}
			return a;
		}
		public boolean Isoperand(char c)
		{
			return ((c>='A' && c<='Z') ||(c>='a' && c<='z'));
		}
		public boolean Isoperator(char c)
		{
			return (c=='(' || c==')' || c=='/' || c=='*' || c=='+' || c=='-');
		}
		public int Setprecedence(char c)
		{
			switch(c)
	  		{
	  		case '*':
	  		case '/':
	  		case '%':
	  			return 3;
	  			
	  		case '+':
	  		case '-':
	  		    return 2;
           
	  		case '(':
	  			 return 1;
	  		case ')':
	  			return 0;
	  		}
			return -1;
			
		
	
		}
		public String ConvertIntoPost(String str)
		{
			String str1=" ";
			char ch,ch1;
			
			for(int i=0;i<str.length();i++)
			{
				ch=str.charAt(i);
				if(Isoperand(ch))
				{
				    str1+=ch;
				}
				else if(Isoperator(ch))
				{
					if(ch=='(')
					{
						push(ch);
					}
					else if(ch==')')
					{
						 
					     while(peek()!='(')
					     {
					    	 ch1=pop();
					    	 str1+=ch1;
					     }
					     pop();
					}
				
				else if(IsEmpty())
				{
					push(ch);
				}
				else if(peek()=='(')
				{
					push(ch);
				}
				else if(Setprecedence(peek()) < Setprecedence(ch))
				{
					push(ch);
				}
				else {
					while((Setprecedence(peek()) >= Setprecedence(ch)))
					{
						ch1=pop();
				    	str1+=ch;
					}
					push(ch);
				}
				}
				
			}//for
			while(!IsEmpty()) 
			{
				
				ch1=pop();
				//System.out.println(ch1);
				if(ch1 !=')' && ch1!='(' )
				{
					
					    str1+=ch1;
				}
				else
				{
					String s="";
					return s ;
				}
			}
			
			
			return str1;
			
		}
}
