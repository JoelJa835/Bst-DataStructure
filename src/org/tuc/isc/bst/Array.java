package org.tuc.isc.bst;

import org.tuc.isc.util.MultiCounter;

/**
 *A class that can be used to implement binary search in sorted array
 */
public class Array {

    /**
     * Variable holding our keys
     */
    int[] table;
    private static final int Size = 10000;

    /**
     * Constructor that initializes the variable table[]
     *
     * @param N the size of the array
     */
    public Array(int N) {
        this.table = new int[N];
    }


    /**
     * Method that implements the binary search algorithm to find a key
     * @param key key to be found
     */
    public int BinarySearch(int first, int last, int key) {
        MultiCounter.increaseCounter(7);
        int mid = (first + last) / 2;
        while (MultiCounter.increaseCounter(7) && first <= last) {
            if (MultiCounter.increaseCounter(7) && table[mid] < key) {
                MultiCounter.increaseCounter(7);
                first = mid + 1;
            } else if (MultiCounter.increaseCounter(7) && table[mid] == key) {
                //System.out.println("Element is found at index: " + mid);
                return mid;
            } else {
                MultiCounter.increaseCounter(7);
                last = mid - 1;
            }
            MultiCounter.increaseCounter(7);
            mid = (first + last) / 2;
        }
        if (MultiCounter.increaseCounter(7) && first > last) {
            System.out.println("Element is not found!");
        }
        return 1;
    }

    /**
     * Method that finds keys in the given range
     * @param low lower bound
     * @param high higher bound
     */
    public void BinarySearchRange(int low, int high){   //Something breaks
        MultiCounter.increaseCounter(7);
        int ptr =BinarySearch(0,99999,low);
        while( MultiCounter.increaseCounter(7) && table[ptr]<=high && MultiCounter.increaseCounter(7) && ptr <table.length-1 ){
            //System.out.println(table[ptr]);
            MultiCounter.increaseCounter(7);
            ptr++;
        }
    }
}
