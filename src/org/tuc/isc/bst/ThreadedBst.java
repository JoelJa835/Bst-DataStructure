package org.tuc.isc.bst;

import org.tuc.isc.util.MultiCounter;

/**
 *
 */
public class ThreadedBst {

    /**
     *
     */
    private static final int RightThread = 4;
    private static final int LeftThread = 3;
    private static final int Right = 2;
    private static final int Left = 1;
    private static final int Info = 0;
    private int[][] data;
    int parentIndex = -1;
    int helperPointerRight,helperPointerLeft =0;

    int tmpPointer=-1;
    private int Avail =0;



    /**
     * @param N
     */
    public ThreadedBst(int N) {
        this.data = new int[N][5];
        InitializeArray();
    }


    /**
     * @param rootIndex
     * @param val
     * @return
     */
    public  int InsertRandomKey(int rootIndex ,int val) {
        if(MultiCounter.increaseCounter(4) &&  rootIndex!= -1 && MultiCounter.increaseCounter(5) &&  Avail !=0){
            if (MultiCounter.increaseCounter(4) && val > data[rootIndex][Info]) {
                MultiCounter.increaseCounter(4);
                parentIndex = rootIndex;
                helperPointerRight = data[rootIndex][Right];
                if(MultiCounter.increaseCounter(4) && data[rootIndex][RightThread]==1) {                     //This check ensures we wont go into infinite recursion
                    MultiCounter.increaseCounter(4);
                    data[rootIndex][Right] = -1;
                }
                InsertRandomKey(data[rootIndex][Right], val);
            } else {
                MultiCounter.increaseCounter(4);
                parentIndex = rootIndex;
                helperPointerLeft = data[rootIndex][Left];
                if(MultiCounter.increaseCounter(4) && data[rootIndex][LeftThread]==1) {                     //This check ensures we wont go into infinite recursion
                    MultiCounter.increaseCounter(4);
                    data[rootIndex][Left] = -1;
                }
                InsertRandomKey(data[rootIndex][Left], val);
            }
        }
        else {
            MultiCounter.increaseCounter(4,3);
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
        }
        return rootIndex;
    }

    /**
     * @param rootIndex
     * @param val
     * @return
     */
    public int SearchRandomKey(int rootIndex,int val){

        while(MultiCounter.increaseCounter(5) && rootIndex!=-1) {
            if (MultiCounter.increaseCounter(5) &&  data[rootIndex][Info] == val) {
                //System.out.println("Found value:" + data[rootIndex][Info] + " at index: " + rootIndex);
                return rootIndex;
            }
            if(MultiCounter.increaseCounter(5) && data[rootIndex][LeftThread] == 1 && val< data[rootIndex][Info]  || MultiCounter.increaseCounter(5) && data[rootIndex][RightThread]==1 && val > data[rootIndex][Info] ){
                System.out.println("Key wasn't found");
                break;
            }
            if (MultiCounter.increaseCounter(5) && val < data[rootIndex][Info]) {
                MultiCounter.increaseCounter(5);
                rootIndex = data[rootIndex][Left];
            } else if(MultiCounter.increaseCounter(5) && val > data[rootIndex][Info]){
                MultiCounter.increaseCounter(5);
                rootIndex = data[rootIndex][Right];
            }
        }
    return rootIndex;
    }

    /**
     *
     * @param rootIndex
     * @param low
     * @param high
     * @return
     */
    public int SearchRange(int rootIndex,int low,int high) {
        MultiCounter.increaseCounter(6);
        int curIndex = SearchRandomKey(rootIndex,low);
        if(curIndex == -1){
            MultiCounter.increaseCounter(6);
            curIndex = leftMostNode(rootIndex);
        }
        while (MultiCounter.increaseCounter(6) && curIndex != -1) {
            if (MultiCounter.increaseCounter(6) && data[curIndex][Info] >= low) {
                if (MultiCounter.increaseCounter(6) && data[curIndex][Info] > high) {
                    break;
                }
                //System.out.println(data[curIndex][Info]);
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
     * @param nodeIndex
     * @return
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
     * @return
     */
    private int GetNode(){
        MultiCounter.increaseCounter(5,3);
        tmpPointer = Avail;
        Avail = data[Avail][Right];
        data[tmpPointer][Right]=-1;
        return tmpPointer;
    }


    /**
     * @param treePointer
     * @return
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
     *
     */
    private  void InitializeArray(){
        for(int i=data.length-1; i>=0; i--){
            FreeNode(i);
        }
    }

}
