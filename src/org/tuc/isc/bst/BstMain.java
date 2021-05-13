package org.tuc.isc.bst;


import org.tuc.isc.util.Generate;
import org.tuc.isc.util.MultiCounter;

import java.io.*;

/**
 *Class that contains main function , calls all the functions we need and prints the results
 */
public class BstMain {
    private static final int K1=100;
    private static final int K2=1000;
    private static final int NO_OF_RANDOM_SEARCHES = 100;


    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Tester test = new Tester();

        System.out.println("Binary Search Tree : ");
        MultiCounter.resetCounter(1);
        test.CallToInsertKeys();
        System.out.println("Average comparison number per random key insertion for normal bst:"+MultiCounter.getCount(1)/test.RandKeys.length);

        MultiCounter.resetCounter(2);
        test.CallToSearchKeys();
        System.out.println("Average comparison number per random search for normal bst:"+MultiCounter.getCount(2)/NO_OF_RANDOM_SEARCHES);

        MultiCounter.resetCounter(3);
        test.CallToSearchKeysInRange(K1);
        System.out.println("Average comparison number per random search in Range (K=100) for normal bst:"+ MultiCounter.getCount(3)/NO_OF_RANDOM_SEARCHES);

        MultiCounter.resetCounter(3);
        test.CallToSearchKeysInRange(K2);
        System.out.println("Average comparison number per random search in Range (K=1000) for normal bst:"+ MultiCounter.getCount(3)/NO_OF_RANDOM_SEARCHES);
        System.out.println("\n");

        System.out.println("Threaded Binary Search Tree : ");
        MultiCounter.resetCounter(4);
        test.CallToInsertThreadedBstKeys();
        System.out.println("Average comparison number per random key insertion for threaded bst:"+MultiCounter.getCount(4)/test.RandKeys.length);

        MultiCounter.resetCounter(5);
        test.CallToSearchThreadedBstKeys();
        System.out.println("Average comparison number per random search for threaded bst:"+MultiCounter.getCount(5)/NO_OF_RANDOM_SEARCHES);

        MultiCounter.resetCounter(6);
        test.CallToSearchThreadedBstKeysInRange(K1);
        System.out.println("Average comparison number per random search in Range (K=100) for threaded bst:"+ MultiCounter.getCount(6)/NO_OF_RANDOM_SEARCHES);

        MultiCounter.resetCounter(6);
        test.CallToSearchThreadedBstKeysInRange(K2);
        System.out.println("Average comparison number per random search in Range (K=1000) for threaded bst:"+ MultiCounter.getCount(6)/NO_OF_RANDOM_SEARCHES);
        System.out.println("\n");

        System.out.println("Sorted Array : ");
        MultiCounter.resetCounter(7);
        test.CallBinarySearch();
        System.out.println("Average comparison number for random search:"+MultiCounter.getCount(7)/NO_OF_RANDOM_SEARCHES);

        MultiCounter.resetCounter(7);
        test.CallBinarySearchRange(K1);
        System.out.println("Average comparison number per random search in Range (K=100) for sorted array:"+ MultiCounter.getCount(7)/NO_OF_RANDOM_SEARCHES);

        MultiCounter.resetCounter(7);
        test.CallBinarySearchRange(K2);
        System.out.println("Average comparison number per random search in Range (K=1000) for sorted array:"+ MultiCounter.getCount(7)/NO_OF_RANDOM_SEARCHES);

    }
}