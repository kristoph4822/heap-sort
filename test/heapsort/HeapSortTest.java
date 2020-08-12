package heapsort;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;


public class HeapSortTest {
  
    //podstawowy test
    @Test
    public void testSortBasic() {
        double[] test = new double[]{9.8, 6.4, 6.9, 5.2, 7.9};
        double[] validation = new double[]{5.2, 6.4, 6.9, 7.9, 9.8};
        
        HeapSort hs = new HeapSort();
        test = hs.Sort(test);
        
        assertTrue(Arrays.equals(test, validation));
    }
    
    //duże dane
     @Test
    public void testSortBigArray() {
       
        int N = 1000;
        
        double[] test = new double[N];
        double[] validation = new double[N];
        
        for(int i = 0; i < N; i++){
            test[i] = i;
            validation[i] = i;
        }
        
        test[0] = 999;
        test[999] = 0;
        
        HeapSort hs = new HeapSort();
        test = hs.Sort(test);
        
        assertTrue(Arrays.equals(test, validation));
    }
    
    //test dla null'a na wejściu
    @Test(expected = NullPointerException.class)
    public void testSortEmptyArray() {
      
        double[] test = null;
        
        HeapSort hs = new HeapSort();
        test = hs.Sort(test);
    }
    
}
