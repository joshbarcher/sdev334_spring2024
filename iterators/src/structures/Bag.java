package structures;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * A Bag is fixed size data structure (it doesn't
 * grow) and does not have indices.
 */
public class Bag implements Iterable {
    private Object[] data;

    //the index for the next element in the bag
    private int nextSpot;

    //count the number of modifications
    private int modCount;

    public Bag(int capacity) {
        data = new Object[capacity];
    }

    public void add(Object element) {
        data[nextSpot++] = element;

        //something changed!
        modCount++;
    }

    public String toString() {
        return Arrays.toString(data);
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        private int nextIndex;
        private int savedModCount;

        public MyIterator() {
            savedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            checkConcurrentChanges();

            return nextIndex < data.length && data[nextIndex] != null;
        }

        private void checkConcurrentChanges() {
            //something changed in the bag!
            if (savedModCount != modCount) {
                throw new ConcurrentModificationException(
                        "Don't change the bag while iterating!");
            }
        }

        @Override
        public Object next() {
            checkConcurrentChanges();

            Object nextElement = data[nextIndex++];
            return nextElement;
        }
    }
}
