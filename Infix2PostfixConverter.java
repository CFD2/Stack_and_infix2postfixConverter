import java.util.Objects;

/**
 * Created by Vadim Yastrebov on 19/7/17.
 */
public class Infix2PostfixConverter {
    /**
     * This method converts infix expression into postfix using the provided algorithm (see Carrano)
     * @param infixExp is the input parameter which consists of infix expression to be converted into postfix notation
     * @return converted expression as a string
     */
    public String convertPostfix(String infixExp) {
        StackReferenceBased<Character> stack = new StackReferenceBased<>();
        StringBuilder postfixExp = new StringBuilder();
        for (char ch : infixExp.toCharArray()) {
            if (ch >= '0' && ch <= '9') {   //if a number
                postfixExp.append(ch);
            } else if (ch ==' ') {  //if a blank space
            } else if (ch =='(') {  //if opening bracket
                stack.push(ch);
            } else if (ch == ')') { //if closing bracket
                while (stack.peek() != '(') {
                    postfixExp.append(' '); //insert space for everything to work properly and to get a perfectly spaced expression in the end
                    postfixExp.append(stack.pop());
                }
                char openParen = stack.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {  //if operators. treat them according to the precedence()
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(ch) <= precedence(stack.peek())) {
                    postfixExp.append(' '); //insert another space here
                    postfixExp.append(stack.pop());
                }
                postfixExp.append(' '); //and another space here
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            postfixExp.append(' '); //and another space here... when we reached the end
            postfixExp.append(stack.pop()); //get the rest of the stack back into expression
        }

        return postfixExp.toString();   //because StringBuilder we need to upcast this into String

    }

    /**
     * This method calculates a postfix expression and returns the result.
     * @param postfixExp is the expression in postfix notation
     * @return calculated result of postfix expression
     */
    public double getPostfix(String postfixExp) {
        String[] s = postfixExp.split("\\s+");  //postfix expression is being split by one or many whitespaces (using RegEx) and then stored as array of Strings
        StackReferenceBased<Double> stack = new StackReferenceBased<>();
        for (String k : s) {
            if (k.matches("\\d+")) {    //if a String arr[k] matches many digits we push it.
                stack.push(Double.parseDouble(k));
            } else if (k.matches("[+/*-]")) {   //if it matches an operator then we pop the last two operands from the stack
                double val2 = stack.pop();
                double val1 = stack.pop();
                /*
                 * make the required calculations with the current operator and push the result back onto stack
                 */
                switch (k) {
                    case "+":
                        stack.push(val1 + val2);
                        break;
                    case "-":
                        stack.push(val1 - val2);
                        break;
                    case "*":
                        stack.push(val1 * val2);
                        break;
                    case "/":
                        stack.push(val1 / val2);
                        break;
//                    case "^": //if we need to raise to the power... just uncomment here. not sure if this will work though.
//                        stack.push(val1 ^ val2);
//                        break;

                }
            }
        }
        return stack.pop(); //the result will be the top of the stack => return it
    }

    /**
     * This method determines the precedence of operator and returns a number according to the precedence rules.
     * @param ch operator char passed in the method
     * @return the precedence value judging by the passed operator. The bigger is the number - the higher is the precedence of this operator.
     */
    private int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        else if (ch == '/' || ch == '*') return 2;
//        else if (ch == '^') return 3;     //uncomment here if there's a need.
        else throw new IllegalArgumentException("There's no such operator!");
    }
}
