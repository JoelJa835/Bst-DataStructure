package org.tuc.isc.bst;

import org.tuc.isc.util.Generate;
import org.tuc.isc.util.MultiCounter;

public class Tester {
    private static final int START_INT = 1;
    private static final int END_INT = 1000001;
    private static final int NO_OF_ELEMENTS = 100000;
    private static final int NO_OF_RANDOM_SEARCHES = 100;

    Generate gen = new Generate();
    int[] RandKeys = gen.RandomInts(START_INT,END_INT,NO_OF_ELEMENTS);
    BstArray bst = new BstArray(RandKeys.length);
    Array arr = new Array(NO_OF_ELEMENTS);


    public void CallToInsertKeys() {
        for (int i = 0; i < NO_OF_ELEMENTS; i++) {
            bst.InsertRandomKey(0, RandKeys[i]);
        }
    }


    public void CallToSearchKeysInRange(int K) {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            System.out.println(i + ":");
            System.out.println(RandKeys[i * 10] + " εως " + (RandKeys[i * 10] + K));
            bst.SearchRange(0, RandKeys[i * 10], (RandKeys[i * 10] + K));
            System.out.println();
        }
    }

    public void CallToSearchKeys() {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            bst.SearchRandomKey(0, RandKeys[i * 10]);
        }
    }

    public void CallBinarySearch(int key){
        arr.binarySearch(START_INT,NO_OF_ELEMENTS,key);
    }

}