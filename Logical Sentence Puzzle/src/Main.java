import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		LogicalSentence l4 = new Negation(l3);
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4));

		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b,true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

		String[] pc = {"P", "Q"};
		truthTable(pc);
	}
	public static void truthTable(String[] str) {
		int columns = str.length;
		for(int y = 0; y < columns; y++) {
			System.out.print(str[y] + "     ");
		}
		System.out.println();
		print(columns, "");
	}
	public static void print(int num, String currString) {
		if(num == 0) {
			System.out.println(currString);
			return;
		}
		print(num-1, currString + "True  ");
		print(num-1, currString + "False ");
	}
	//https://stackoverflow.com/questions/12752225/how-do-i-find-the-position-of-matching-parentheses-or-braces-in-a-given-piece-of
	public static int findMatch(String string, int num) {
		String[] str = string.split("");
		int counter = 0;
		int firstOpenParenthesisIndex = -1;
		int matchingParenthesisIndex = -1;
		for(int x = 0; x < str.length; x++) {
			if(str[x].equals("(")) {
				counter++;
				if(firstOpenParenthesisIndex == -1) {
					firstOpenParenthesisIndex = x;
				}
			} else if(str[x].equals(")")){
				counter--;
			}
			if(counter == 0 && firstOpenParenthesisIndex != -1) {
				matchingParenthesisIndex = x;
			}
			if(firstOpenParenthesisIndex != -1 && matchingParenthesisIndex != -1) {
				return matchingParenthesisIndex;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param sentence - sentence to check if legal
	 * @return whether the sentence is legal
	 */
	public static boolean legal(String sentence) {
		String[] str;
		Exception e = new Exception();
		e.fillInStackTrace();
		if (e.getStackTrace().length == 2) {
			str = matchTilda(sentence);
		} else {
			str = sentence.split("\\s+");
		}
		//Checks if the array is only one character and if that is a propositional constant
		if(str.length == 1 && propositionalConstant(str[0])) {
			return true;
		}
		//Checks if there is a ~ and calls the function again this time ignore the ~
		if(str[0].length() == 2 && str[0].charAt(0) == '~') {
			str[0] = Character.toString(str[0].charAt(1));
			return(legal(String.join(" ", str)));
		}
		//Checks if there is a propositional constant followed by a logical operator and ending in a propositional constant
		if(str.length >= 3 && str.length % 2 == 1) {
			for(int x = 0; x < str.length; x++) {
				if(x % 2 == 0) {
					if(!legal(str[x])) {
						return false;
					}
				} else {
					if(!logicalOperator(str[x])) {
						return false;
					}
				}
			}
			return true;
		}
		//Returns false if none of the three conditions are met
		return false;
	}

	public static String[] matchTilda(String sentence){
		String[] str = sentence.split("");
		int numOfNullChars = 0;
		for(int x = 0; x < str.length-1; x++) {
			if(str[x].equals("~")) {
				str[x] = str[x] + str[x+1];
				str[x+1] = "";
				numOfNullChars += 1;
			}
		}
		String[] str1 = Arrays.copyOf(str, str.length-numOfNullChars);
		int index = 0;
		for(int x = 0; x < str.length; x++) {
			if(!str[x].equals("")) {
				str1[index] = str[x];
				index += 1;
			}
		}
		return str1;
	}

	/**
	 * @param Word to check
	 * @return If the word is a propositional constant
	 */
	public static boolean propositionalConstant(String word) {
		//Checks if the string given is a propositional constant(either "p" or "q")
		if(Character.isLetter(word.charAt(0)) && word.length() == 1) {
			return true;
		}
		return false;
	}

	/**
	 * @param Word to check
	 * @return If the word is a valid logical operator
	 */
	public static boolean logicalOperator(String word) {
		if(word.equals("&") || word.equals("|") || word.equals("=>") || word.equals("<=>")) {
			return true;
		}
		return false;
	}
}
