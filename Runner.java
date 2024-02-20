import java.util.Iterator;
public class Runner{
    public static void main (String[]args) {



        /** QUESTION 1: CUSTOM ITERATOR **/
        LinkedListWithIterator<String> testList = new LinkedListWithIterator<>();

        /* ADD TEST */
        System.out.println("TESTING ADD: SHOULD PRINT A, B, C");
        testList.add("A");
        testList.add("B");
        testList.add("C");

        printLinkedList(testList);

        System.out.println("TESTING W/ POSITION: SHOULD PRINT A, D, B, C");
        testList.add(8, "X");
        testList.add(2, "D");

        printLinkedList(testList);

        /* REMOVE TEST */
        System.out.println("TESTING REMOVE: SHOULD PRINT A, B, C");
        testList.remove(8);
        testList.remove(2);

        printLinkedList(testList);

        /* REPLACE TEST */
        System.out.println("TESTING REPLACE: SHOULD PRINT A, M, C");
        testList.replace(0, "X");
        testList.replace(2, "M");

        printLinkedList(testList);

        /* GET ENTRY TEST */
        System.out.println("TESTING GET ENTRY: SHOULD PRINT C");
        System.out.println(testList.getEntry(3));
        System.out.println("SHOULD PRINT POSITION OUT OF BOUNDS");
        testList.getEntry(8);

        System.out.println();

        /* TO ARRAY TEST */
        System.out.println("TESTING TO ARRAY: SHOULD PRINT A, M, C");
        Comparable[] testArr = testList.toArray();

        for(int i = 0; i < testArr.length; i++)
        {
            System.out.println(testArr[i]);
        }
        System.out.println();

        /* CONTAINS TEST */
        System.out.println("TESTING DOES CONTAIN: SHOULD PRINT TRUE, FALSE");
        System.out.println(testList.contains("M"));
        System.out.println(testList.contains("X"));

        System.out.println();

        /* IS EMPTY AND CLEAR TEST */
        System.out.println("TESTING IS EMPTY AND CLEAR: SHOULD PRINT FALSE, TRUE");
        System.out.println(testList.isEmpty());
        testList.clear();
        System.out.println(testList.isEmpty());

        System.out.println();



        /** QUESTION 2: EXPRESSION PARSING **/
        ExpressionDriver expDrive = new ExpressionDriver();

        expDrive.expressionRunner();
    }

    /* HELPER METHODS */
    public static void printLinkedList(LinkedListWithIterator<String> inputList){
        /* ALSO A GET LENGTH TEST */
        System.out.println("Linked List currently has " + inputList.getLength() + " items.");

        Iterator iter = inputList.getIterator();
        while (iter.hasNext()){
            System.out.println((String)iter.next());
        }

        System.out.println();
    }
}
