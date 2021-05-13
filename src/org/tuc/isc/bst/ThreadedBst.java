package org.tuc.isc.bst;

import org.tuc.isc.util.MultiCounter;

/**
 *A class that can be used to implement a threaded binary search tree in an array with stack
 */
public class ThreadedBst {
    /**
     * Constants that help the code be more organized
     */
    private static final int RightThread = 4;
    private static final int LeftThread = 3;
    private static final int Right = 2;
    private static final int Left = 1;
    private static final int Info = 0;
    /**
     * Variables that are needed throughout the class
     */
    private int[][] data;
    private int parentIndex = -1;
    private int helperPointerRight,helperPointerLeft =0;
    private int tmpPointer=-1;
    private int Avail =0;



    /**
     * Constructor that initializes our data
     * @param N The size needed to initialize the array  with the data
     */
    public ThreadedBst(int N) {
        this.data = new int[N][5];
        InitializeArray();
    }


    /**
     * Insert a random generated key in data array
     * @param nodeIndex a variable which points to our nodes and at start points to the root
     * @param val The key that we insert to the array
     * @return the variable that points to our nodes
     */
    public  int InsertRandomKey(int nodeIndex ,int val) {

        while(MultiCounter.increaseCounter(4) &&  nodeIndex!= -1 && MultiCounter.increaseCounter(5) &&  Avail !=0){
            if (MultiCounter.increaseCounter(4) && val > data[nodeIndex][Info]) {
                MultiCounter.increaseCounter(4,2);
                parentIndex = nodeIndex;
                helperPointerRight = data[nodeIndex][Right];
                if(MultiCounter.increaseCounter(4) && data[nodeIndex][RightThread]==1) {                     //This check ensures we wont go into infinite recursion
                    MultiCounter.increaseCounter(4);
                    data[nodeIndex][Right] = -1;
                }
                MultiCounter.increaseCounter(4);
                nodeIndex=data[nodeIndex][Right];
            } else {
                MultiCounter.increaseCounter(4,2);
                parentIndex = nodeIndex;
                helperPointerLeft = data[nodeIndex][Left];
                if(MultiCounter.increaseCounter(4) && data[nodeIndex][LeftThread]==1) {                     //This check ensures we wont go into infinite recursion
                    MultiCounter.increaseCounter(4);
                    data[nodeIndex][Left] = -1;
                }
                MultiCounter.increaseCounter(4);
                nodeIndex=data[nodeIndex][Left];
            }
        }
            MultiCounter.increaseCounter(4,4);
            tmpPointer = GetNode();
            data[tmpPointer][Info] = val;
            data[tmpPointer][RightThread] = 1;
            data[tmpPointer][LeftThread] = 1;

            if (MultiCounter.increaseCounter(4) && parentIndex == -1) {
                MultiCounter.increaseCounter(4,2);
                data[tmpPointer][Left] = -1;
                data[tmpPointer][Right] = -1;
            } else if (MultiCounter.increaseCounter(4) && val > data[parentIndex][Info]) {
                MultiCounter.increaseCounter(4);
                data[tmpPointer][Left] = parentIndex;
                if (MultiCounter.increaseCounter(4) && data[parentIndex][RightThread] == 1) {
                    MultiCounter.increaseCounter(4);
                    data[tmpPointer][Right] = helperPointerRight;
                }
                MultiCounter.increaseCounter(4,2);
                data[parentIndex][RightThread] = 0;
                data[parentIndex][Right] = tmpPointer;
            } else {
                MultiCounter.increaseCounter(4);
                data[tmpPointer][Right] = parentIndex;
                if (MultiCounter.increaseCounter(4) && data[parentIndex][LeftThread] == 1) {
                    MultiCounter.increaseCounter(4);
                    data[tmpPointer][Left] = helperPointerLeft;
                }
                MultiCounter.increaseCounter(4,2);
                data[parentIndex][LeftThread] = 0;
                data[parentIndex][Left] = tmpPointer;
            }
        return nodeIndex;
        }



    /**
     * Search for a random key  and prints the index at where the key was found
     * @param nodeIndex  variable which points to our nodes and at start points to the root
     * @param val the key to be searched
     * @return the index  of the node that was last used or if the key is found  it returns the index to that key
     */
    public int SearchRandomKey(int nodeIndex,int val){

        while(MultiCounter.increaseCounter(5) && nodeIndex!=-1) {
            if (MultiCounter.increaseCounter(5) &&  data[nodeIndex][Info] == val) {
                //System.out.println("Found value:" + data[rootIndex][Info] + " at index: " + rootIndex); //It is commented because too many prints are done and the results can't be seen easily
                return nodeIndex;
            }
            if(MultiCounter.increaseCounter(5) && data[nodeIndex][LeftThread] == 1 && val< data[nodeIndex][Info]  || MultiCounter.increaseCounter(5) && data[nodeIndex][RightThread]==1 && val > data[nodeIndex][Info] ){
                System.out.println("Key wasn't found");
                break;
            }
            if (MultiCounter.increaseCounter(5) && val < data[nodeIndex][Info]) {
                MultiCounter.increaseCounter(5);
                nodeIndex= data[nodeIndex][Left];
            } else if(MultiCounter.increaseCounter(5) && val > data[nodeIndex][Info]){
                MultiCounter.increaseCounter(5);
                nodeIndex= data[nodeIndex][Right];
            }
        }
    return nodeIndex;
    }

    /**
     * Search for keys in a given range and everytime a key is found, it is printed out.
     * @param rootIndex points to the root of our tree
     * @param low  lower limit of range
     * @param high higher limir of range
     * @return the current index
     */
    public int SearchRange(int rootIndex,int low,int high) {
        MultiCounter.increaseCounter(6);
        int curIndex = SearchRandomKey(rootIndex,low);
        if(MultiCounter.increaseCounter(6) &&curIndex == -1){           //If low isn't found, find left most Node and start searching for the next key greater than low.
            MultiCounter.increaseCounter(6);
            curIndex = leftMostNode(rootIndex);
        }
        while (MultiCounter.increaseCounter(6) && curIndex != -1) {
            if (MultiCounter.increaseCounter(6) && data[curIndex][Info] >= low) {
                if (MultiCounter.increaseCounter(6) && data[curIndex][Info] > high) {
                    break;
                }
                //System.out.println(data[curIndex][Info]); //It is commented because too many prints are done and the results can't be seen easily
            }
            if (MultiCounter.increaseCounter(6) && data[curIndex][RightThread] == 1) {
                MultiCounter.increaseCounter(6);
                curIndex = data[curIndex][Right];
            } else {
                MultiCounter.increaseCounter(6);
                curIndex = leftMostNode(data[curIndex][Right]);

            }
        }
        return curIndex;
    }

    /**
     * Method that finds the leftmost node
     * @param nodeIndex variable which points to our nodes and at start points to the root
     * @return the variable that points to our nodes(nodeIndex)
     */
    public int leftMostNode(int nodeIndex){
        if(MultiCounter.increaseCounter(6) && nodeIndex==-1){
            return 0;
        }else{
            while(MultiCounter.increaseCounter(6) && data[nodeIndex][Left]!=-1 && MultiCounter.increaseCounter(6) && data[nodeIndex][LeftThread] !=1){
                MultiCounter.increaseCounter(6);
                nodeIndex = data[nodeIndex][Left];
            }
            return nodeIndex;
        }
    }


    /**
     * Method that takes account the Avail variable and "pops" the first element from stack
     * @return the next available node that is ready be used
     */
    private int GetNode(){
        MultiCounter.increaseCounter(5,3);
        tmpPointer = Avail;
        Avail = data[Avail][Right];
        data[tmpPointer][Right]=-1;
        return tmpPointer;
    }


    /**
     * Method that frees a node and pushes it in stack declaring that there is an empty space to be used
     */
    private int FreeNode(int treePointer){
        if(data[treePointer][Info] != -1 && data[treePointer][1] != -1 ) {
            data[treePointer][Info] = -1;
            data[treePointer][Left] = -1;
            data[treePointer][LeftThread] = -1;
            data[treePointer][RightThread] = -1;
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
