package com.GL.model;

import java.util.Stack;

public class BracketsCheck {
	static boolean checkBalancedBrackets(String string) {

		Stack<Character> stack = new Stack<>();
		char[] str = string.toCharArray();

		for (int i = 0; i < str.length; i++) {
			char ch = str[i];
			
			if (ch == '(' || ch == '[' || ch == '{')
            {
                stack.push(ch);
                continue;
            }
			
			if (stack.isEmpty())
                return false;
			
			char check;
            switch (ch) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
        return (stack.isEmpty());
    }
	
	public static void main(String args[]) {
		
		String string = "(({[]}))";
		
		if(checkBalancedBrackets(string)) {
			System.out.println("The string is balanced");
		}
		else
			System.out.println("The string is not balanced");
	}
			

}


