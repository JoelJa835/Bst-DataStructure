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


    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Tester test = new Tester();

        MultiCounter.resetCounter(1);
        test.CallToInsertKeys();
        System.out.println("Average comparison number per random key insertion for normal bst:"+MultiCounter.getCount(1)/test.RandKeys.length);
        System.out.println("\n");

        MultiCounter.resetCounter(2);
        test.CallToSearchKeys();
        System.out.println("Average comparison number per random search for normal bst:"+MultiCounter.getCount(2)/K1);
        System.out.println("\n");

        MultiCounter.resetCounter(3);
        test.CallToSearchKeysInRange(K1);
        System.out.println("Average comparison number per random search in Range (K=100) for normal bst:"+ MultiCounter.getCount(3)/K1);
        System.out.println("\n");

        MultiCounter.resetCounter(3);
        test.CallToSearchKeysInRange(K2);
        System.out.println("Average comparison number per random search in Range (K=1000) for normal bst:"+ MultiCounter.getCount(3)/K2);
        System.out.println("\n");

        MultiCounter.resetCounter(4);
        test.CallToInsertThreadedBstKeys();
        System.out.println("Average comparison number per random key insertion for threaded bst:"+MultiCounter.getCount(4)/test.RandKeys.length);
        System.out.println("\n");

        MultiCounter.resetCounter(5);
        test.CallToSearchThreadedBstKeys();
        System.out.println("Average comparison number per random search for threaded bst:"+MultiCounter.getCount(5)/K1);
        System.out.println("\n");

        MultiCounter.resetCounter(6);
        test.CallToSearchThreadedBstKeysInRange(K1);
        System.out.println("Average comparison number per random search in Range (K=100) for threaded bst:"+ MultiCounter.getCount(6)/K1);
        System.out.println("\n");

        MultiCounter.resetCounter(6);
        test.CallToSearchThreadedBstKeysInRange(K2);
        System.out.println("Average comparison number per random search in Range (K=1000) for threaded bst:"+ MultiCounter.getCount(6)/K2);
        System.out.println("\n");



        //test.CallBinarySearch(10);
        //System.out.println("Μέσος αριθμός συγκρίσεων ανά τυχαία αναζήτηση:"+MultiCounter.getCount(7)/K1);
        //MultiCounter.resetCounter(7);
        //test.CallBinarySearch(10);
        //System.out.println("Μέσος αριθμός συγκρίσεων ανά αναζήτηση εύρους(K=100):"+ MultiCounter.getCount(7));
        //MultiCounter.resetCounter(7);
        //test.CallBinarySearch(10);
        //System.out.println("Μέσος αριθμός συγκρίσεων ανά αναζήτηση εύρους(K=1000):"+ MultiCounter.getCount(7));

    }
}