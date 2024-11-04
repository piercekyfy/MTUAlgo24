package lab3;

import java.util.Stack;

public class IsBalanced {
	
	private static final Character[] OPENING_PARENTHESES = new Character[] {'(', '{', '[', '<'};
	private static final Character[] CLOSING_PARENTHESES = new Character[] {')', '}', ']', '>'};
	
	public static boolean usingStack(String expression) {
		Stack<Character> stack = new Stack<Character>();
		
		for(Character c : expression.toCharArray()) {
			
			if (isIn(c, OPENING_PARENTHESES)) {
				stack.push(c);
			} else if(isIn(c, CLOSING_PARENTHESES)) {
				if(stack.empty())
					return false;
				else if (!isMatchingParentheses(stack.pop(), c))
					return false;
			}
		}
		return stack.empty();
	}
	
	private static boolean isIn(Character character, Character[] characters) {
		for(Character c : characters) {
			if(character == c)
				return true;
		}
		return false;
	}
	
	private static boolean isMatchingParentheses(Character opening, Character closing) {
		for(int i = 0; i < OPENING_PARENTHESES.length; i++) {
			if(opening == OPENING_PARENTHESES[i]) {
				if(closing == CLOSING_PARENTHESES[i])
					return true;
			}
		}
		return false;
	}
}
