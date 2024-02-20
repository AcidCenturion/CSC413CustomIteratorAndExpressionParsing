import java.util.Iterator;

public class PostFixEvaluator extends ExpressionDriver{
    public static void evaluatePostfix(String str)
    {
        //reusing linked list instead of creating a stack to save time lol. will be used like a stack
        LinkedListWithIterator<String> valueStack = new LinkedListWithIterator<>();

        //traverse the expression
        for(int i = 0; i < str.length(); i++)
        {
            //find and add variables a, b, c, and d
            if(str.charAt(i) == 'a' || str.charAt(i) == 'b' || str.charAt(i) == 'c' || str.charAt(i) == 'd')
            {
                //add the numbers into the value stack
                if(str.charAt(i) == 'a'){valueStack.add(getA());}
                else if(str.charAt(i) == 'b'){valueStack.add(getB());}
                else if(str.charAt(i) == 'c'){valueStack.add(getC());}
                else if(str.charAt(i) == 'd'){valueStack.add(getD());}
            }
            //if the character is an operator, commence operation!
            else if (str.charAt(i) == '(' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*'
                    || str.charAt(i) == '/' || str.charAt(i) == '^')
            {
                //remove operands (reverse order - first in last out),
                // evaluate based on operator, then add back to stack
                int operand2 = (int)valueStack.remove(valueStack.getLength());
                int operand1 = (int)valueStack.remove(valueStack.getLength());
                int res = 1;

                if(str.charAt(i) == '+'){
                    res = operand1 + operand2;
                    valueStack.add(res);
                }
                else if(str.charAt(i) == '-'){
                    res = operand1 - operand2;
                    valueStack.add(res);
                }
                else if(str.charAt(i) == '*'){
                    res = operand1 * operand2;
                    valueStack.add(res);
                }
                else if(str.charAt(i) == '/'){
                    res = operand1 / operand2;
                    valueStack.add(res);
                }
                else if(str.charAt(i) == '^'){
                    for(int j = 0; j < operand2; j++){
                        res *= operand1;
                    }
                    valueStack.add(res);
                }
            }
            //other unknown character encountered, including numbers, variables outside the 4, etc.
            else {
                System.out.println("Unknown found in equation. Please check infixEquation in ExpressionDriver.");
            }
        }

        System.out.println("Using the given numbers in the equation, " + str + ", your result is: " +
                valueStack.remove(1));

        //printLinkedList(valueStack);
    }

    /*
    public static void printLinkedList(LinkedListWithIterator<String> inputList){
        System.out.println("Linked List currently has " + inputList.getLength() + " items.");

        Iterator iter = inputList.getIterator();
        while (iter.hasNext()){
            System.out.println((int)iter.next());
        }

        System.out.println();
    }
    */
}
