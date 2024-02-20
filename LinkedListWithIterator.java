import java.util.Iterator;
import java.util.NoSuchElementException;
public class LinkedListWithIterator<E> extends MyLList{
    public Iterator<E> getIterator()
    {
        return new IteratorForLinkedList();
    }

    /* HELPER CLASSES */
    private class IteratorForLinkedList implements Iterator<E>
    {
        /** I just used the one on the GitHub, changing variable names as I perused the code to understand
         * how it works. **/
        /* FIELDS */
        private int nextIndex;
        private boolean isIterating;

        /* NO GETTERS OR SETTERS */

        /* CONSTRUCTORS */
        public IteratorForLinkedList()
        {
            nextIndex = 1;
            isIterating = false;
        }

        /* METHODS */
        public boolean hasNext()
        {
            return nextIndex <= getLength();
        }

        public E next()
        {
            if (hasNext())
            {
                isIterating = true;
                E nextEntry = (E) getEntry(nextIndex);
                nextIndex++; // Advance iterator

                return nextEntry;
            } // end if
            else
                throw new NoSuchElementException("Illegal call to next();" +
                        "iterator is after end of list.");
        } // end next

        public void remove()
        {
            if (isIterating)
            {
                // nextPosition was incremented by the call to next, so it
                // is 1 more than the position number of the entry to be removed
                nextIndex--;  // Index of next entry in iteration
                LinkedListWithIterator.this.remove(nextIndex);
                isIterating = false;	// Reset flag
            } // end if
            else
                throw new IllegalStateException("Illegal call to remove(); " +
                        "next() was not called.");
        } // end remove
    }
}
