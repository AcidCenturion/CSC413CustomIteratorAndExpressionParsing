import java.util.Scanner;
public class ExpressionDriver {
    /* FIELDS */
    private static final String infixExpression = "((a+b)*(c+d))";
    private static final String postfixExpression = "ac-b^d+"; //((a-c)^b)+d
    private static int a;
    private static int b;
    private static int c;
    private static int d;
    private String endRequested = "Default";
    private Scanner input = new Scanner(System.in);

    /* CONSTRUCTORS */
    public ExpressionDriver(){}

    /* GETTERS AND SETTERS */
    public static int getA(){return a;}
    public static int getB(){return b;}
    public static int getC(){return c;}
    public static int getD(){return d;}

    /* METHODS */
    public void expressionRunner()
    {
        while(!endRequested.equals("no")){
            //get inputs for variable values
            System.out.println("Please enter an integer for number a");
            a = input.nextInt();
            System.out.println("Please enter an integer for number b");
            b = input.nextInt();
            System.out.println("Please enter an integer for number c");
            c = input.nextInt();
            System.out.println("Please enter an integer for number d");
            d = input.nextInt();

            System.out.println("The numbers you have chosen are: " +
                    "a = " + a + ", " +
                    "b = " + b + ", " +
                    "c = " + c + ", " +
                    "d = " + d);

            //call evaluator functions
            InfixEvaluator infixCalc = new InfixEvaluator();
            infixCalc.evaluateInfix(infixExpression);
            PostFixEvaluator postfixCalc = new PostFixEvaluator();
            postfixCalc.evaluatePostfix(postfixExpression);

            System.out.println();

            //ask user if repeating is desired
            System.out.println("Would you like to compute another set of numbers? Enter any input to continue, " +
                    "or type \"no\" to stop.");
            endRequested = input.next();
            System.out.println();
        }
    }
}
