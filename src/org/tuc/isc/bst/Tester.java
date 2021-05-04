package org.tuc.isc.bst;

import org.tuc.isc.util.Generate;
import org.tuc.isc.util.MultiCounter;

/**
 * A class that is useda
 */
public class Tester {
    private static final int START_INT = 1;
    private static final int END_INT = 1000001;
    private static final int NO_OF_ELEMENTS = 100000;
    private static final int NO_OF_RANDOM_SEARCHES = 100;

    Generate gen = new Generate();
    int[] RandKeys = gen.RandomInts(START_INT,END_INT,NO_OF_ELEMENTS);
    BstArray bst = new BstArray(RandKeys.length);
    ThreadedBst tBst = new ThreadedBst(RandKeys.length);
    Array arr = new Array(NO_OF_ELEMENTS);


    /**
     *Method that calls InsertRandomKey method 100 times, from class BstArray
     */
    public void CallToInsertKeys() {
        for (int i = 0; i < NO_OF_ELEMENTS; i++) {
            bst.InsertRandomKey(0, RandKeys[i]);
        }
    }


    /**
     * Method that calls SearchRange method 100 times, from class BstArray
     * @param K The range to search
     */
    public void CallToSearchKeysInRange(int K) {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            //System.out.println(i + ":");
            //System.out.println(RandKeys[i * 10] + " εως " + (RandKeys[i * 10] + K));
            bst.SearchRange(0, RandKeys[i * 10], (RandKeys[i * 10] + K));
            System.out.println();
        }
    }

    /**
     *Method that calls SearchRandomKey method 100 times, from class BstArray
     */
    public void CallToSearchKeys() {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            bst.SearchRandomKey(0, RandKeys[i * 10]);
        }
    }

    /**
     * Method that calls InsertRandomKey method 100 times, from class ThreadedBst
     */
    public void CallToInsertThreadedBstKeys() {
        for (int i = 0; i < NO_OF_ELEMENTS; i++) {
            tBst.InsertRandomKey(0,RandKeys[i]);
        }
    }

    /**
     * @param K
     */
    public void CallToSearchThreadedBstKeysInRange(int K) {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            //System.out.println(i + ":");
            //System.out.println(RandKeys[i * 10] + " εως " + (RandKeys[i * 10] + K));
            tBst.SearchRange(0, RandKeys[i * 10], (RandKeys[i * 10] + K));
            System.out.println();
        }
    }

    /**
     *
     */
    public void CallToSearchThreadedBstKeys() {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            //System.out.println("Key:"+RandKeys[i*10]);
            tBst.SearchRandomKey(0, RandKeys[i * 10]);
        }
    }




    /**
     *Method that calls binarySearch method 100 times from class Array
     */
    public void CallBinarySearch(){
        arr.InitializeArray();
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            arr.BinarySearch(START_INT, NO_OF_ELEMENTS, RandKeys[i]);
        }
    }

}