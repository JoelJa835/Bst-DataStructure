package org.tuc.isc.bst;


import org.tuc.isc.util.MultiCounter;

public class BstArray {


    private static final int Right = 2;
    private static final int Left = 1;
    private static final int Info = 0;
    private int data [][];
    private int Avail =-1;


    public BstArray(int N) {
        this.data = new int[N][3];
        InitializeArray();
    }


    public  int InsertRandomKey(int rootIndex ,int val) {

        if (MultiCounter.increaseCounter(1) && data[rootIndex][Info] == -1) {
            MultiCounter.increaseCounter(1);
            GetNode();
            return data[rootIndex][0] = val;
        }

        if (MultiCounter.increaseCounter(1) && val > data[rootIndex][Info]) {

            if (MultiCounter.increaseCounter(1) && data[rootIndex][Right] != -1) {
                MultiCounter.increaseCounter(1);
                data[rootIndex][Right] = InsertRandomKey(data[rootIndex][Right], val);
            } else {
                MultiCounter.increaseCounter(1,2);
                data[rootIndex][Right] = GetNode();
                data[data[rootIndex][Right]][Info] = val;
            }
        }
        else{
            if (MultiCounter.increaseCounter(1) && data[rootIndex][Left] != -1) {
                MultiCounter.increaseCounter(1);
                data[rootIndex][Left] =InsertRandomKey(data[rootIndex][Left], val);
            } else {
                MultiCounter.increaseCounter(1,2);
                data[rootIndex][Left]=GetNode();
                data[data[rootIndex][Left]][Info] =val;
            }
        }
        return rootIndex;
    }

    public int SearchRandomKey(int rootIndex,int val){
        if(MultiCounter.increaseCounter(2) && data[rootIndex][Right] ==  -1 && data[rootIndex][Left] ==-1){
            System.out.println("Value wasnt found in tree");
            return rootIndex;
        }
        if(MultiCounter.increaseCounter(2) && data[rootIndex][Info] == val) {
            System.out.println("Found value:"+data[rootIndex][Info]+" at index: "+rootIndex );
            return rootIndex;
        }
        if(MultiCounter.increaseCounter(2) && val < data[rootIndex][Info]){
            return SearchRandomKey(data[rootIndex][Left],val);
        }
        else{
            return SearchRandomKey(data[rootIndex][Right],val);
        }

    }
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
            System.out.print(data[rootIndex][Info] + " ");
        }

        if (MultiCounter.increaseCounter(3) && high >= data[rootIndex][Info]) {
            if(MultiCounter.increaseCounter(3) && data[rootIndex][Right] != -1) {
                SearchRange(data[rootIndex][Right],low,high);
            }

        }
        return rootIndex;
    }


    private int GetNode(){
        MultiCounter.increaseCounter(1,3);
        int treePointer =Avail;
        Avail = data[Avail][Right];
        data[treePointer][Right]=-1;
        return treePointer;
    }


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
    public void print(){
        for(int i=0; i< data.length;i++){

            System.out.println(data[i][Info]);
            System.out.println(data[i][Left]);
            System.out.println(data[i][Right]);
        }
    }


    private  void InitializeArray(){
        for(int i=data.length-1; i>=0; i--){
            FreeNode(i);
        }
    }
}