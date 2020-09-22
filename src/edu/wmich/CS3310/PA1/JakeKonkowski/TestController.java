package edu.wmich.CS3310.PA1.JakeKonkowski;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestController {

	public static void main(String[] args){
		
		IParenthesesChecker stackChecker = new StackParenthesesChecker();
		IParenthesesChecker queueChecker = new QueueParenthesesChecker();
		
		String input = "";
		Scanner scanner = new Scanner(System.in);
		
		while(!"exit".equals(input)) {	
			System.out.println("Enter parentheses to check for balance (Type \"exit\" to exit the application): ");
			
			input = scanner.nextLine();
			
			String pattern = "[()]+";

			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(input);
			
			if (m.matches()) {
				if (stackChecker.isBalanced(input) && queueChecker.isBalanced(input)) {
					System.out.println("The input string \"" + input + "\" has balanced parentheses.");
				} else {
					System.out.println("The input string \"" + input + "\" does not have balanced parentheses.");
				}
			} else if (!"exit".equals(input)) {
				System.out.println("Invalid input! Parentheses only!");
			}
		}
		
		scanner.close();
	}

}
