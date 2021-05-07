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
     * @param N The size needed to initialize the array with the data
     */
    public BstArray(int N) {
        this.data = new int[N][3];
        InitializeArray();
    }


    /**
     * Inserts a random generated key in data array
     * @param nodeIndex a variable which points to our nodes and at start points to the root
     * @param val  The key that we insert to the array
     * @return the variable that points to our nodes
     */
        public int InsertRandomKey(int nodeIndex, int val) {
            if (MultiCounter.increaseCounter(1) && this.data[nodeIndex][0] == -1) {
                MultiCounter.increaseCounter(1);
                this.GetNode();
                return this.data[nodeIndex][0] = val;
            } else {
                if (MultiCounter.increaseCounter(1) && val > this.data[nodeIndex][0]) {
                    if (MultiCounter.increaseCounter(1) && this.data[nodeIndex][2] != -1) {
                        MultiCounter.increaseCounter(1);
                        this.data[nodeIndex][2] = this.InsertRandomKey(this.data[nodeIndex][2], val);
                    } else {
                        MultiCounter.increaseCounter(1, 2);
                        this.data[nodeIndex][2] = this.GetNode();
                        this.data[this.data[nodeIndex][2]][0] = val;
                    }
                } else if (MultiCounter.increaseCounter(1) && this.data[nodeIndex][1] != -1) {
                    MultiCounter.increaseCounter(1);
                    this.data[nodeIndex][1] = this.InsertRandomKey(this.data[nodeIndex][1], val);
                } else {
                    MultiCounter.increaseCounter(1, 2);
                    this.data[nodeIndex][1] = this.GetNode();
                    this.data[this.data[nodeIndex][1]][0] = val;
                }

                return nodeIndex;
            }
        }


    /**
     * Search for a random key  and prints the index at where the key was found
     * @param nodeIndex a variable which points to our nodes and at start points to the root
     * @param val The key to be searched
     * @return Returns the index where the key was or wasn't found
     */
    public int SearchRandomKey(int nodeIndex,int val){
        if(MultiCounter.increaseCounter(2) && nodeIndex == -1){
            System.out.println("Value wasnt found in tree");
           return nodeIndex;
        }
        if(MultiCounter.increaseCounter(2) && val < data[nodeIndex][Info]){
            return SearchRandomKey(data[nodeIndex][Left],val);
        }
        else if(MultiCounter.increaseCounter(2) && data[nodeIndex][Info] == val) {
            //System.out.println("Found value:"+data[rootIndex][Info]+" at index: "+rootIndex ); //It is commented because too many prints are done and the results can't be seen easily
            return nodeIndex;
        }
        else{
            return SearchRandomKey(data[nodeIndex][Right],val);
        }

    }

    /**
     * Search for keys in a given range and everytime a key is found, it is printed out.
     * @param nodeIndex a variable which points to our nodes and at start points to the root
     * @param low
     * @param high
     * @return
     */
    public int SearchRange(int nodeIndex,int low,int high){
        if (MultiCounter.increaseCounter(3) && data[nodeIndex][Info] == -1) {
            return -1;
        }
        if (MultiCounter.increaseCounter(3) && low <=data[nodeIndex][Info]) {
            if(MultiCounter.increaseCounter(3) && data[nodeIndex][Left] != -1) {
                SearchRange(data[nodeIndex][Left],low,high);
            }
        }
        if (MultiCounter.increaseCounter(3) && low <= data[nodeIndex][Info] && MultiCounter.increaseCounter(3) && high >= data[nodeIndex][Info]) {
            //System.out.print(data[rootIndex][Info] + " ");
        }
        if (MultiCounter.increaseCounter(3) && high >= data[nodeIndex][Info]) {
            if(MultiCounter.increaseCounter(3) && data[nodeIndex][Right] != -1) {
                SearchRange(data[nodeIndex][Right],low,high);
            }
        }
        return nodeIndex;
    }


    /**
     *Method that takes account the Avail variable and "pops" the first element from stack
     * @return the next available node that is ready be used
     */
    private int GetNode(){
        MultiCounter.increaseCounter(1,3);
        int treePointer =Avail;
        Avail = data[Avail][Right];
        data[treePointer][Right]=-1;
        return treePointer;
    }

    /**
     * Method that frees a node and pushes it in stack declaring that there is an empty space to be used
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
     *Initializes the data array
     */
    private  void InitializeArray(){
        for(int i=data.length-1; i>=0; i--){
            FreeNode(i);
        }
    }
}