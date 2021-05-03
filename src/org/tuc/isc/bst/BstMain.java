package org.tuc.isc.bst;


import org.tuc.isc.util.Generate;
import org.tuc.isc.util.MultiCounter;

import java.io.*;

// Driver class for BST tests
public class BstMain {
    private static final int K1=100;
    private static final int K2=1000;


    // Main routine for BST tests
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Tester test = new Tester();


        MultiCounter.resetCounter(1);
        MultiCounter.resetCounter(2);
        MultiCounter.resetCounter(3);
        MultiCounter.resetCounter(4);

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

        ThreadedBst tbst = new ThreadedBst(9);

        tbst.InsertRandomKey(0,45);
        tbst.InsertRandomKey(0,35);
        tbst.InsertRandomKey(0,55);
        tbst.InsertRandomKey(0,53);
        tbst.InsertRandomKey(0,42);
        tbst.InsertRandomKey(0,15);
        tbst.InsertRandomKey(0,105);
        tbst.InsertRandomKey(0,36);
        tbst.InsertRandomKey(0,43);

        //test.CallBinarySearch(10);
        System.out.println("Μέσος αριθμός συγκρίσεων ανά τυχαία αναζήτηση:"+MultiCounter.getCount(4));
        MultiCounter.resetCounter(4);
        //test.CallBinarySearch(10);
        System.out.println("Μέσος αριθμός συγκρίσεων ανά αναζήτηση εύρους(K=100):"+ MultiCounter.getCount(4));
        MultiCounter.resetCounter(4);
        //test.CallBinarySearch(10);
        System.out.println("Μέσος αριθμός συγκρίσεων ανά αναζήτηση εύρους(K=1000):"+ MultiCounter.getCount(4));











































//        BSTORIG tree = new BSTORIG();
//
//        System.out.println("IsEmpty: " + tree.isEmpty());
//        tree.insert(new IElem(10));
//        tree.print();
//        System.out.println("IsEmpty: " + tree.isEmpty());
//        tree.remove(10);
//        tree.print();
//        System.out.println("IsEmpty: " + tree.isEmpty());
//        tree.clear();
//        System.out.println("IsEmpty: " + tree.isEmpty());
//        tree.insert(new IElem(15));
//        System.out.println("IsEmpty: " + tree.isEmpty());
//        tree.find(15);
//        tree.print();
//        tree.remove(20);
//        System.out.println("Now, insert 20");
//        tree.insert(new IElem(20));
//        tree.print();
//        tree.remove(20);
//        tree.print();
//        tree.insert(new IElem(70));
//        System.out.println("IsEmpty: " + tree.isEmpty());
//        tree.insert(new IElem(35));
//        tree.insert(new IElem(20));
//        tree.insert(new IElem(17));
//        tree.insert(new IElem(15));
//        tree.insert(new IElem(19));
//        tree.insert(new IElem(100));
//        tree.insert(new IElem(90));
//        tree.insert(new IElem(95));
//        tree.insert(new IElem(1));
//        tree.print();
//        System.out.println("Find 100: " + tree.find(100));
//        System.out.println("Find 99: " + tree.find(99));
//        System.out.println("Find 20: " + tree.find(20));
//        System.out.println("Need to do some delete tests.");
//        System.out.println("Delete: 15");
//        tree.remove(15);
//        tree.print();
//        System.out.println("Delete: 15");
//        tree.remove(15);
//        tree.print();
//        System.out.println("Delete: 70");
//        tree.remove(70);
//        tree.print();
//
//        System.out.print("Do Preorder: \t");
//        tree.preorder();
//        System.out.print("Do Postoder: \t");
//        tree.postorder();
//        System.out.print("Do Inorder: \t");
//        tree.inorder();
//
//        System.out.println("Total number of tree nodes: " + tree.count());
//
//        tree.printRange(1, 200);
//        tree.printRange(16, 95);
//        tree.printRange(20, 85);
//
//        System.out.println("\nSave tree to file");
//        tree.saveBST("myfile");
//
//        System.out.println("Read tree form file");
//        BSTORIG tree1 = new BSTORIG("myfile");
//        tree1.preorder();
//        tree1.print();
//
//        tree.clear();
//        tree.print();
//        System.out.println("IsEmpty: " + tree.isEmpty());
//        System.out.println("That is all.");
//        System.in.read();
    }
}