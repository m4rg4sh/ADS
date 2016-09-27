package P01_Brackets;

/**
 * This class implements a Bracket Tester for the ADS module @ ZHAW
 * @author Stefan Epprecht <epprest1@students.zhaw.ch>
 */
class BracketTester {

    /**
     * Tests whether a given input is correctly parenthesised
     * @param input String to check
     * @return boolean whether it is correctly parenthesised
     */
    static boolean isCorrectlyParenthesised(String input) {
        boolean isCorrect = true;
        Stack<Character> stack = new Stack();

        input = input.replaceAll("[^(){}<>\\[\\]]+","");
        char[] brackets = input.toCharArray();

        for(char currentChar : brackets) {
            if ('{' == currentChar || '[' == currentChar || '(' == currentChar || '<' == currentChar) {
                stack.push(currentChar);
            } else if (stack.isEmpty()){
                isCorrect = false;
            } else if (currentChar == '>' && !(stack.pop() == '<')) {
                isCorrect = false;
            } else if (currentChar == ')' && !(stack.pop() == '(')) {
                isCorrect = false;
            } else if (currentChar == ']' && !(stack.pop() == '[')) {
                isCorrect = false;
            } else if (currentChar == '}' && !(stack.pop() == '{')) {
                isCorrect = false;
            }
        }

        if(!stack.isEmpty()) {
            isCorrect = false;
        }

        return isCorrect;
    }
}
