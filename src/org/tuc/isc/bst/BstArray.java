package org.tuc.isc.bst;


import org.tuc.isc.util.MultiCounter;

/**
 * A class that can be used to implement a binary search tree in an array with stack
 */
public class BstArray {


    /**
     * Constants that help the code be more organized
     */
    private static final int Right = 2;
    private static final int Left = 1;
    private static final int Info = 0;

    /**
     * Variable holding our data,
     */
    private int data [][];
    private int Avail =-1;


    /**
     * Constructor that initializes our data
     * @param N The size needed to initialize array data
     */
    public BstArray(int N) {
        this.data = new int[N][3];
        InitializeArray();
    }


    /**
     * Inserts a random generated key in data array
     * @param rootIndex
     * @param val  The key that we insert to the array
     * @return
     */
        public int InsertRandomKey(int rootIndex, int val) {
            if (MultiCounter.increaseCounter(1) && this.data[rootIndex][0] == -1) {
                MultiCounter.increaseCounter(1);
                this.GetNode();
                return this.data[rootIndex][0] = val;
            } else {
                if (MultiCounter.increaseCounter(1) && val > this.data[rootIndex][0]) {
                    if (MultiCounter.increaseCounter(1) && this.data[rootIndex][2] != -1) {
                        MultiCounter.increaseCounter(1);
                        this.data[rootIndex][2] = this.InsertRandomKey(this.data[rootIndex][2], val);
                    } else {
                        MultiCounter.increaseCounter(1, 2);
                        this.data[rootIndex][2] = this.GetNode();
                        this.data[this.data[rootIndex][2]][0] = val;
                    }
                } else if (MultiCounter.increaseCounter(1) && this.data[rootIndex][1] != -1) {
                    MultiCounter.increaseCounter(1);
                    this.data[rootIndex][1] = this.InsertRandomKey(this.data[rootIndex][1], val);
                } else {
                    MultiCounter.increaseCounter(1, 2);
                    this.data[rootIndex][1] = this.GetNode();
                    this.data[this.data[rootIndex][1]][0] = val;
                }

                return rootIndex;
            }
        }


    /**
     * Searches for a random key  and prints the index at where the key was found
     * @param rootIndex
     * @param val The key to be searched
     * @return Returns the index where the key was or wasn't found
     */
    public int SearchRandomKey(int rootIndex,int val){
        if(MultiCounter.increaseCounter(2) && rootIndex == -1){
            System.out.println("Value wasnt found in tree");
           return rootIndex;
        }
        if(MultiCounter.increaseCounter(2) && val < data[rootIndex][Info]){
            return SearchRandomKey(data[rootIndex][Left],val);
        }
        else if(MultiCounter.increaseCounter(2) && data[rootIndex][Info] == val) {
            //System.out.println("Found value:"+data[rootIndex][Info]+" at index: "+rootIndex );
            return rootIndex;
        }
        else{
            return SearchRandomKey(data[rootIndex][Right],val);
        }

    }

    /**
     * Searches for keys in a given range and everytime a key is found, it is printed out.
     * @param rootIndex
     * @param low
     * @param high
     * @return
     */
    public int SearchRange(int rootIndex,int low,int high){

        if (MultiCounter.increaseCounter(3) && data[rootIndex][Info] == -1) {
            return -1;
        }

        if (MultiCounter.increaseCounter(3) && low <=data[rootIndex][Info]) {
            if(MultiCounter.increaseCounter(3) && data[rootIndex][Left] != -1) {
                SearchRange(data[rootIndex][Left],low,high);
            }
        }

        if (MultiCounter.increaseCounter(3) && low <= data[rootIndex][Info] && MultiCounter.increaseCounter(3) && high >= data[rootIndex][Info]) {
            //System.out.print(data[rootIndex][Info] + " ");
        }

        if (MultiCounter.increaseCounter(3) && high >= data[rootIndex][Info]) {
            if(MultiCounter.increaseCounter(3) && data[rootIndex][Right] != -1) {
                SearchRange(data[rootIndex][Right],low,high);
            }

        }
        return rootIndex;
    }


    /**
     *
     * @return
     */
    private int GetNode(){
        MultiCounter.increaseCounter(1,3);
        int treePointer =Avail;
        Avail = data[Avail][Right];
        data[treePointer][Right]=-1;
        return treePointer;
    }


    /**
     * @param treePointer
     * @return
     */
    private int FreeNode(int treePointer){
        if(data[treePointer][Info] != -1 && data[treePointer][1] != -1 ) {
            data[treePointer][Info] = -1;
            data[treePointer][Left] = -1;
            data[treePointer][Right] = Avail;
            Avail = treePointer;
            return 1;
        }
        else{
            System.out.println("The data in given tree pointer are already null");
            return 0;
        }

    }

    /**
     *
     */
    public void print(){
        for(int i=0; i< data.length;i++){

            System.out.println(data[i][Info]);
            System.out.println(data[i][Left]);
            System.out.println(data[i][Right]);
        }
    }


    /**
     *Initializes the data array
     */
    private  void InitializeArray(){
        for(int i=data.length-1; i>=0; i--){
            FreeNode(i);
        }
    }
}