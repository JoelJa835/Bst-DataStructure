package org.tuc.isc.bst;

import org.tuc.isc.util.Generate;
import org.tuc.isc.util.MultiCounter;

import java.util.Arrays;
import java.util.Random;

/**
 * A class that is used to help clean up our main function
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
            int num = getRandomKeys(NO_OF_RANDOM_SEARCHES,RandKeys)[i];
            //System.out.println(i + ":");
            //System.out.println(num + " εως " + (num + K));
            bst.SearchRange(0,num , (num + K));
            //System.out.println();
        }
    }

    /**
     *Method that calls SearchRandomKey method 100 times, from class BstArray
     */
    public void CallToSearchKeys() {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            bst.SearchRandomKey(0, getRandomKeys(NO_OF_RANDOM_SEARCHES,RandKeys)[i]);
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
     * Method that calls SearchRange method 100 times from class ThreadedBst
     * @param K Determines what value we will add in our num parameter
     */
    public void CallToSearchThreadedBstKeysInRange(int K) {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            int num = getRandomKeys(NO_OF_RANDOM_SEARCHES,RandKeys)[i];
            //System.out.println(i + ":");
            //System.out.println(num + " εως " + (num + K));
            tBst.SearchRange(0, num, (num+K));
            //System.out.println();
        }
    }

    /**
     *Method that calls SearchRandomKey method 100 times from class ThreadedBst
     */
    public void CallToSearchThreadedBstKeys() {
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            tBst.SearchRandomKey(0, getRandomKeys(NO_OF_RANDOM_SEARCHES,RandKeys)[i]);
        }
    }


    /**
     *Initialize the array variable 'talbe' from class Array with random keys and then sort it
     */
    public void initializeArrayBS(){
        for(int i=0; i<NO_OF_ELEMENTS; i++ ){
            arr.table[i] = getRandomKeys(NO_OF_ELEMENTS,RandKeys)[i];
        }
        Arrays.sort(arr.table);
    }
    /**
     *Method that calls binarySearch method 100 times from class Array
     */
    public void CallBinarySearch(){
        initializeArrayBS();
        for (int i = 0; i < NO_OF_RANDOM_SEARCHES; i++) {
            arr.BinarySearch(START_INT, NO_OF_ELEMENTS, RandKeys[i]);
        }
    }

    /**
     * Method that fills an array of size n with random generated keys
     * @param n Size of array
     * @param keys Array of generated keys
     * @return returns an array of size n filled with random keys
     */
    public static int[] getRandomKeys(int n, int[] keys) {

        Random rand = new Random();
        int[] array = new int[n];

        for(int i=0; i<n; i++) {
            array[i] = keys[rand.nextInt(keys.length)];
        }
        return array;
    }

}