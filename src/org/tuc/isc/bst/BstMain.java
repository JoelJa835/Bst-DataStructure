package org.tuc.isc.bst;


import org.tuc.isc.util.Generate;
import org.tuc.isc.util.MultiCounter;

import java.io.*;

/**
 *
 */
// Driver class for BST tests
public class BstMain {

    /**
     *
     */
    private static final int K1=100;
    private static final int K2=1000;


    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Tester test = new Tester();



        MultiCounter.resetCounter(1);
        MultiCounter.resetCounter(2);
        MultiCounter.resetCounter(3);
        MultiCounter.resetCounter(4);
        MultiCounter.resetCounter(5);

//        test.CallToInsertKeys();
//        System.out.println("Μεσος αριθμός συγκρίσεων ανα εισαγωγή:"+MultiCounter.getCount(1)/test.RandKeys.length);
//
//        test.CallToSearchKeys();
//        System.out.println("Μέσος αριθμός συγκρίσεων ανά τυχαία αναζήτηση:"+MultiCounter.getCount(2)/K1);
//
//        test.CallToSearchKeysInRange(K1);
//        System.out.println("Μέσος αριθμός συγκρίσεων ανά αναζήτηση εύρους(K=100):"+ MultiCounter.getCount(3)/K1);
//
//        MultiCounter.resetCounter(3);
//        test.CallToSearchKeysInRange(K2);
//        System.out.println("Μέσος αριθμός συγκρίσεων ανά αναζήτηση εύρους(K=1000):"+ MultiCounter.getCount(3)/K1);


        //test.CallBinarySearch(10);
        //System.out.println("Μέσος αριθμός συγκρίσεων ανά τυχαία αναζήτηση:"+MultiCounter.getCount(4)/K1);
        //MultiCounter.resetCounter(5);
        //test.CallBinarySearch(10);
        //System.out.println("Μέσος αριθμός συγκρίσεων ανά αναζήτηση εύρους(K=100):"+ MultiCounter.getCount(5));
        //MultiCounter.resetCounter(5);
        //test.CallBinarySearch(10);
        //System.out.println("Μέσος αριθμός συγκρίσεων ανά αναζήτηση εύρους(K=1000):"+ MultiCounter.getCount(5));

    }
}