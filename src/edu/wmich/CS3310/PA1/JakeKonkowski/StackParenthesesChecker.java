package edu.wmich.CS3310.PA1.JakeKonkowski;

public class StackParenthesesChecker implements IParenthesesChecker {

	@Override
	public boolean isBalanced(String s) {
		
		//if first character is ) it's not balanced
		if (")".equals(Character.toString(s.charAt(0)))) {
			return false;
		}
		
		//if last character is ( it's not balanced
		if ("(".equals(Character.toString(s.charAt(s.length() - 1)))) {
			return false;
		}
		
		//quick check to see if the parentheses are not balanced.
		if (s.replace("(", "").length() != s.replace(")", "").length()) {
			return false;
		}
		
		Stack<String> stack = new Stack<String>(s.length()/2); //We only need the stack to be half the size of the string because we only push ")"
		
		for (int i = 0; i < s.length(); i++) { //Loop through the characters of the string
			String currentChar = Character.toString(s.charAt(i)); //Get the current character
			
			if ("(".equals(currentChar)) {
				stack.push(currentChar); //push )
			}
			
			if (")".equals(currentChar)) { //If we encounter a ) then we check if there is a ( to remove from the stack. If there isn't, the string isn't balanced.
				if (null != stack.peek()) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		if (stack.getList().getSize() == 0) { //If there isn't anything in the stack at the end then it is balanced.
			return true;
		}
		
		return false;
	}

}
