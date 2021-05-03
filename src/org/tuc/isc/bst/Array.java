package org.tuc.isc.bst;

import org.tuc.isc.util.MultiCounter;

public class Array {

    /**
     *
     */
    int[] table;
    private static final int Size= 1000000;

    /**
     * @param N
     */
    public Array(int N) {
       this.table = new int[N];
    }

    /**
     *
     */
    public void InitializeArray(){
        for(int i=0; i<Size; i++){
            table[i]=i+1;
        }
    }

    /**
     * @param first
     * @param last
     * @param key
     * @return
     */
    public int BinarySearch(int first,int last,int key){
        if (MultiCounter.increaseCounter(7) && last>=first){
            MultiCounter.increaseCounter(7);
            int mid = first + (last - first)/2;
            if (MultiCounter.increaseCounter(7) && table[mid] == key){
                return mid;
            }
            if (MultiCounter.increaseCounter(7) && table[mid] > key){
                return BinarySearch( first, mid-1, key);//search in left subarray
            }else{
                return BinarySearch(mid+1, last, key);//search in right subarray
            }
        }
        return -1;
    }
}
