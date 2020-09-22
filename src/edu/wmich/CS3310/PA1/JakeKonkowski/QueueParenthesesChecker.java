package edu.wmich.CS3310.PA1.JakeKonkowski;

public class QueueParenthesesChecker implements IParenthesesChecker {

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
		
		Queue<String> queue = new Queue<String>(s.length()/2); //We only need the queue to be half the size of the string because we only push ")"
		
		for (int i = 0; i < s.length(); i++) { //Loop through the characters of the string
			String currentChar = Character.toString(s.charAt(i)); //Get the current character
			
			if ("(".equals(currentChar)) {
				queue.enqueue(currentChar); //enqueue )
			}
			
			if (")".equals(currentChar)) { //If we encounter a ) then we check if there is a ( to remove from the queue. If there isn't, the string isn't balanced.
				if (queue.poll() != null) {
					queue.dequeue();
				} else {
					return false;
				}
			}
		}
		
		if (queue.getList().getSize() == 0) { //If there isn't anything in the queue at the end then it is balanced.
			return true;
		}
		
		return false;
	}

}
