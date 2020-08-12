package heapsort;

import org.junit.Test;
import static org.junit.Assert.*;


public class HeapTest {
  
    //podstawy test put'a
    @Test
    public void testPutBasic() {
        
        Integer[] test = new Integer[]{9, 8, 6, 5, 4};
        Integer[] validation = new Integer[]{9, 8, 7, 5, 4, 6};
        
        Integer i = 7;
        Heap h = new Heap(test);
        h.put(i);
        
        assertArrayEquals(h.getArray(), validation);
    }
    
    //przekazanie nulla do put'a
    @Test (expected = NullPointerException.class)
    public void testNullInPut() {
        
        Double[] test = new Double[0];  
        Heap h = new Heap(test);
        
        Double item = null;
        h.put(item);
    }

    
    //podstawowy test pop'a
    @Test 
    public void testPop() {
        
        Integer[] test = new Integer[]{9, 8, 6, 5, 4};
        Integer[] validation = new Integer[]{8, 5, 6, 4};
        
        Heap h = new Heap(test);
        h.pop();
        
        assertArrayEquals(h.getArray(), validation);
    }
    
    //przekazanie nulla do konstruktora
    @Test (expected = NullPointerException.class)
    public void testNullInConstructor() {
        
        Double[] test = null;  
        Heap h = new Heap(test);
    }
}
