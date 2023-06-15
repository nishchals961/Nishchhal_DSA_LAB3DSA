import java.util.Stack;

class BalancedBrackets {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}');
    }

    public static void main(String[] args) {
        String input1 = "( [ [ { } ] ] )";
        if (isBalanced(input1)) {
            System.out.println("The entered string has balanced brackets");
        } else {
            System.out.println("The entered string does not contain balanced brackets");
        }

        String input2 = "( [ [ { } ] ] ) )";
        if (isBalanced(input2)) {
            System.out.println("The entered string has balanced brackets");
        } else {
            System.out.println("The entered string does not contain balanced brackets");
        }
    }
}
