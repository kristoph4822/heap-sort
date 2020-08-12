package heapsort;


public interface HeapInterface <T extends Comparable<T>> {
         
        public void put(T item); // dodaje element do kopca
        public T pop(); // pobiera element "największy" wg naturalnej kolejności
    }
