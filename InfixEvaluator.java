//import java.util.Iterator;

public class InfixEvaluator extends ExpressionDriver{
    public static void evaluateInfix(String str)
    {
        //reusing linked list instead of creating a stack to save time lol. will be used like a stack
        LinkedListWithIterator<String> operatorStack = new LinkedListWithIterator<>();
        LinkedListWithIterator<String> valueStack = new LinkedListWithIterator<>();

        //traverse, add token to stack
        for(int i = 0; i < str.length(); i++)
        {
            //find and add operators
            if(str.charAt(i) == '(' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*'
                    || str.charAt(i) == '/')
            {
                operatorStack.add(str.charAt(i));
            }
            //find and add variables a, b, c, and d
            else if (str.charAt(i) == 'a' || str.charAt(i) == 'b' || str.charAt(i) == 'c'
                    || str.charAt(i) == 'd')
            {
                //add the numbers into the value stack
                if(str.charAt(i) == 'a'){valueStack.add(getA());}
                else if(str.charAt(i) == 'b'){valueStack.add(getB());}
                else if(str.charAt(i) == 'c'){valueStack.add(getC());}
                else if(str.charAt(i) == 'd'){valueStack.add(getD());}
            }
            //found closing bracket )
            else if (str.charAt(i) == ')')
            {
                //operator to use is next in stack
                char operator = (char)operatorStack.remove(operatorStack.getLength());

                //remove operands (reverse order - first in last out),
                // evaluate based on operator, then add back to stack
                int operand2 = (int)valueStack.remove(valueStack.getLength());
                int operand1 = (int)valueStack.remove(valueStack.getLength());
                int res;

                if(operator == '+'){
                    res = operand1 + operand2;
                    valueStack.add(res);
                }
                else if(operator == '-'){
                    res = operand1 - operand2;
                    valueStack.add(res);
                }
                else if(operator == '*'){
                    res = operand1 * operand2;
                    valueStack.add(res);
                }
                else if(operator == '/'){
                    res = operand1 / operand2;
                    valueStack.add(res);
                }

                //remove open bracket
                operatorStack.remove(operatorStack.getLength());
            }
            //other unknown character encountered, including numbers, variables outside the 4, etc.
            else {
                System.out.println("Unknown found in equation. Please check infixEquation in ExpressionDriver.");
            }
        }

        System.out.println("Using the given numbers in the equation, " + str + ", your result is: " +
                valueStack.remove(1));

        //printLinkedList(operatorStack);
        //printLinkedList(valueStack);
    }

    /*
    public static void printLinkedList(LinkedListWithIterator<String> inputList){
        System.out.println("Linked List currently has " + inputList.getLength() + " items.");

        Iterator iter = inputList.getIterator();
        while (iter.hasNext()){
            System.out.println((char)iter.next());
        }

        System.out.println();
    }
    */
}
