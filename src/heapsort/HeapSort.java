package heapsort;


public class HeapSort implements ListSorterAlgorithm {

    @Override
    public double[] Sort(double[] unsortedVector){
        
        if(unsortedVector == null){
           
            throw new NullPointerException();
        }
        
        double[] finalArray = new double[unsortedVector.length];
        Double item;
        Heap h = new Heap(new Double[0]);
         
        for(int i = 0; i < unsortedVector.length; i++){
 
            item = unsortedVector[i];
            h.put(item);
        }
        
        for(int i = unsortedVector.length - 1; i >= 0; i--){
            
            Double tmp = (Double)h.pop();
            finalArray[i] = tmp.doubleValue();
        }
        
        return finalArray;
    }
}

    
    

