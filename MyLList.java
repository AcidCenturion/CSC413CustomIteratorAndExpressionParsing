public class MyLList<E extends Comparable < ? super E>> implements ListInterface<E>  {
    /* FIELDS */
    private Node head;
    private int size;

    /* CONSTRUCTOR */
    public MyLList()
    {
        head = null;
        size = 0;
    }

    /* GETTERS AND (NO) SETTERS */
    public Node getHead() {return head;}

    /* METHODS */
    /** In order to use comparable interface for the toArray function, I need this, but I don't use the Override
     * I would have used a similar definition for the compareTo function had that been on the GitHub, but ctrl+f
     * only found one instance of "compareTo" and it was not a definition for the function. **/
    public int compareTo(E obj)
    {
        return 0;
    }

    public void add(E newEntry)
    {
        //create new node
        Node newNode = new Node(newEntry);
        //first node added is a special case
        if(size == 0)
        {
            head = newNode;
        }
        else
        {
            //reach the end of the linked list and then add the node
            Node toEndNode = head;
            while(toEndNode.next != null)
            {
                toEndNode = toEndNode.next;
            }
            toEndNode.next = newNode;
        }
        size++;
        /* Below is shorter in time complexity but adds to front instead of back
        //create the new node
        Node newNode = new Node(newEntry);
        //next data is the node head points to
        newNode.setNext(head);
        //becomes the pointee of head node
        head = newNode;
        //increment size
        size++;
        */
    }

    public boolean add(int newPosition, E newEntry)
    {
        //invalid position; note position not index
        if(newPosition > size+1 || newPosition < 1) {
            return false;
        }
        else
        {
            //create a new node at the first position
            Node newNode = new Node(newEntry);
            if(newPosition == 1) {
                newNode.setNext(head);
                head = newNode;
            }
            else {
                //progress to desired position
                int count = newPosition - 1;
                Node currentNode = head;
                while (count > 1) {
                    currentNode = currentNode.getNext();
                    count--;
                }
                //set the new node
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
            //increment size
            size++;
            return true;
        }
    }

    public Comparable remove(int givenPosition)
    {
        //invalid position
        if(givenPosition > size || givenPosition < 1)
        {
            return null;
        }
        else {
            E toRet;
            //special case to remove the first node
            if(givenPosition == 1)
            {
                toRet = head.getData();
                head = head.getNext();
            }
            else {
                //progress to position (one in front)
                Node currentNode = head;
                int count = givenPosition;
                while (count > 2) {
                    currentNode = currentNode.getNext();
                    count--;
                }
                //remove the entry
                toRet = currentNode.getNext().getData();
                currentNode.setNext(currentNode.getNext().getNext());
            }
            size--;
            return toRet;
        }
    }

    public void clear()
    {
        head = null;
        size = 0;
    }

    public E replace(int givenPosition, E newEntry)
    {
        //invalid position
        if(givenPosition > size || givenPosition < 1)
        {
            return newEntry;
        }
        else {
            //progress to position
            Node currNode = head;
            int count = givenPosition;
            while(count > 1)
            {
                currNode = currNode.getNext();
                count--;
            }
            //replace entry and return
            E temp = currNode.getData();
            currNode.setData(newEntry);
            return temp;
        }
    }

    public Comparable getEntry(int givenPosition)
    {
        try {
            //throw error if out of bounds
            if (givenPosition < 1 || givenPosition > getLength()) {
                throw new LinkedListOutOfBoundsException("Given position is out of bounds");
            }

            //progress to position
            Node currNode = head;
            int count = givenPosition;
            while(count > 1)
            {
                currNode = currNode.getNext();
                count--;
            }

            return currNode.getData();
        }
        catch(LinkedListOutOfBoundsException exception)
        {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public Comparable[] toArray()
    {
        //if linked list is empty
        if(head == null)
        {
            return null;
        }

        //declare array to be returned
        E[] arr = (E[]) new Comparable[size];

        //traverse the linked list
        Node currNode = head;
        int pos = 0;
        while(currNode != null)
        {
            arr[pos] = currNode.getData();
            currNode = currNode.getNext();
            pos++;
        }

        return arr;
    }

    public boolean contains(E anEntry)
    {
        //traverse the entire
        Node currNode = head;
        while (currNode != null)
        {
            //set true if found
            if(currNode.getData().equals(anEntry))
            {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    public int getLength()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    /* HELPER CLASSES */
    private class Node {
        /* FIELDS */
        private E data; //Entry in bag
        private Node next; //Link to next Node

        /* CONSTRUCTORS */
        public Node(E dataPortion) {
            this(dataPortion, null);
        }

        public Node(E dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        /* GETTERS AND SETTERS */
        public E getData(){return data;}
        public Node getNext(){return next;}

        public void setData(E newData){data = newData;}
        public void setNext(Node newNext){next = newNext;}
    }
}

