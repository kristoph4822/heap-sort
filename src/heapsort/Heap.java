package heapsort;

import java.util.Arrays;


public class Heap <T extends Comparable<T>> implements HeapInterface <T> {
    
    private T[] array;
    
    public Heap(T[] array){
        
        if(array == null){
           
            throw new NullPointerException();
        }
        
        this.array = array;
    }
    
    //rekurencyjna funkcja do sprawdzania warunku kopca (rodzic >= dziecko)
    private void validatePut(int childIndex){
      
        int parentIndex = (childIndex - 1) / 2;
    
        if(childIndex > 0 && array[childIndex].compareTo(array[parentIndex]) > 0){
           
            T tmp = array[parentIndex];
            array[parentIndex] = array[childIndex];
            array[childIndex] = tmp;
       
            validatePut(parentIndex); //rekurencja
        }
    }
    
    //rekurencyjna funkcja do sprawdzania warunku kopca dla pop
    private void validatePop(int parentIndex){
      
        int maxIndex = parentIndex;
        int leftChild = parentIndex * 2 + 1;
        int rightChild = parentIndex * 2 + 2;
        
        if(leftChild < array.length && array[leftChild].compareTo(array[maxIndex]) > 0){
            
            maxIndex = leftChild;
        }
        
        if(rightChild < array.length && array[rightChild].compareTo(array[maxIndex]) > 0){
            
            maxIndex = rightChild;
        }
       
        if(maxIndex != parentIndex){
            
            T tmp = array[parentIndex];
            array[parentIndex] = array[maxIndex];
            array[maxIndex] = tmp;
            
            validatePop(maxIndex); //rekurencja
        }
    }
     
    
    @Override
    public void put(T item){ 
        
        if(item == null){
           
            throw new NullPointerException();
        }
                
        int n = array.length;
        array = Arrays.copyOf(array, n+1);
        array[n] = item;
        
        int id = array.length - 1;
        
        Heap h = new Heap(array);
        h.validatePut(id);
        array = (T[]) h.getArray();
    }

    @Override
    public T pop(){
                     
        T top = array[0];
        array[0] = array[array.length - 1];
        array = Arrays.copyOf(array, array.length - 1);
       
        int id = 0;
        
        Heap h = new Heap(array);
        h.validatePop(id);
        array = (T[]) h.getArray();
    
        return top;
    }
    
    public T[] getArray() {
        return this.array;
    }
}
