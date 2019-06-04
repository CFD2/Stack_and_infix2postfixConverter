import java.util.Scanner;

/**
 * Created by Vadim Yastrebov on 19/7/17.
 */
public class TestInfix2PostfixConverter {
    public static void main(String[] args) {
        //
        TestInfix2PostfixConverter test = new TestInfix2PostfixConverter();
        Infix2PostfixConverter converter = new Infix2PostfixConverter();

        System.out.println("--------------- TEST CASES ---------------");
        String infixExp = ("(10 + 3 * 4 / 6)");
        System.out.println("Infix: " + infixExp);
        String postfixExp = converter.convertPostfix(infixExp);
        System.out.println("Postfix: " + postfixExp);
        System.out.println("Result (12): " + converter.getPostfix(postfixExp));

        infixExp = ("12*3 - 4 + (18 / 6)");
        System.out.println("\nInfix: " + infixExp);
        postfixExp = converter.convertPostfix(infixExp);
        System.out.println("Postfix: " + postfixExp);
        System.out.println("Result (35): " + converter.getPostfix(postfixExp));

        infixExp = ("35 - 42* 17 /2 + 10");
        System.out.println("\nInfix: " + infixExp);
        postfixExp = converter.convertPostfix(infixExp);
        System.out.println("Postfix: " + postfixExp);
        System.out.println("Result (-312): " + converter.getPostfix(postfixExp));

        infixExp = ("3 * (4 + 5)");
        System.out.println("\nInfix: " + infixExp);
        postfixExp = converter.convertPostfix(infixExp);
        System.out.println("Postfix: " + postfixExp);
        System.out.println("Result (27): " + converter.getPostfix(postfixExp));

        infixExp = ("3 * ( 17 - (5+2))/(2+3)");
        System.out.println("\nInfix: " + infixExp);
        postfixExp = converter.convertPostfix(infixExp);
        System.out.println("Postfix: " + postfixExp);
        System.out.println("Result (6): " + converter.getPostfix(postfixExp));
        System.out.println("--------------- END TEST CASES ---------------");


        while (true) {
            System.out.println("\nType in your infix epxression. Type \"quit\" to... uhm... quit: ");
            infixExp = new Scanner(System.in).nextLine();
            if (infixExp.equals("quit")) {
                System.exit(0);
            } else {
                System.out.println("\n Infix: " + infixExp);
                postfixExp = converter.convertPostfix(infixExp);
                System.out.println("Postfix: " + postfixExp);
                System.out.println("Result: " + converter.getPostfix(postfixExp));
            }
        }

    }
}
