package org.tuc.isc.bst;

import org.tuc.isc.util.MultiCounter;

public class ThreadedBst {
    private static final int RightThread = 4;
    private static final int LeftThread = 3;
    private static final int Right = 2;
    private static final int Left = 1;
    private static final int Info = 0;
    private int data [][];
    int helperPointer;
    private int Avail =-1;
    private int rootIndex = -1;


    public ThreadedBst(int N) {
        this.data = new int[N][5];
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
                if(MultiCounter.increaseCounter(1) && data[rootIndex][RightThread] == 1){
                    MultiCounter.increaseCounter(1, 3);
                    data[rootIndex][Right] = Avail;
                    data[rootIndex][RightThread] = 0;
                    data[Avail ][RightThread] = 1;
                    InsertRandomKey(Avail, val);
                    if(MultiCounter.increaseCounter(1) && Avail != -1) {
                        MultiCounter.increaseCounter(1);
                        data[helperPointer][Right] = rootIndex - 1;
                    }

                }
                else {
                    MultiCounter.increaseCounter(1);
                    data[rootIndex][Right] = InsertRandomKey(data[rootIndex][Right], val);
                    if(MultiCounter.increaseCounter(1) && Avail == -1 && MultiCounter.increaseCounter(1) && rootIndex >=1) {
                        MultiCounter.increaseCounter(1, 3);
                        data[helperPointer][Right] = rootIndex - 1;
                        data[helperPointer][Left] = data[rootIndex][Right];
                        data[helperPointer][LeftThread] = 1;
                    }
                }
            } else {
                if (MultiCounter.increaseCounter(1) && data[rootIndex][RightThread] == 1) {
                    MultiCounter.increaseCounter(1, 4);
                    data[rootIndex][Right] = GetNode();
                    data[data[rootIndex][Right]][Info] = val;
                    data[data[rootIndex][Right]][LeftThread] = 1;
                    data[rootIndex][RightThread] = 0;
                }
                else{
                    MultiCounter.increaseCounter(1, 5);
                    data[rootIndex][Right] = GetNode();
                    data[data[rootIndex][Right]][Info] = val;
                    data[data[rootIndex][Right]][LeftThread] = 1;
                    data[rootIndex][RightThread] = 0;
                    data[data[rootIndex][Right]][Left]= rootIndex;
                }
            }
        }
        else{
            if (MultiCounter.increaseCounter(1) && data[rootIndex][Left] != -1) {
                if(MultiCounter.increaseCounter(1) && data[rootIndex][LeftThread] ==1){
                    MultiCounter.increaseCounter(1, 3);
                    data[rootIndex][Left] = Avail;
                    data[rootIndex][LeftThread] = 0;
                    data[Avail][LeftThread] = 1;
                    InsertRandomKey(Avail, val);
                    if(MultiCounter.increaseCounter(1) && Avail != -1) {
                        MultiCounter.increaseCounter(1);
                        data[helperPointer][Left] = rootIndex - 1;
                    }

                }
                else {
                    MultiCounter.increaseCounter(1);
                    data[rootIndex][Left] = InsertRandomKey(data[rootIndex][Left], val);
                    if(MultiCounter.increaseCounter(1) && Avail == -1 && MultiCounter.increaseCounter(1) && rootIndex >=1) {
                        MultiCounter.increaseCounter(1, 3);
                        data[helperPointer][Left] = rootIndex - 1;
                        data[helperPointer][Right] = data[rootIndex][Left];
                        data[helperPointer][RightThread] = 1;
                    }

                }
            } else {
                if(MultiCounter.increaseCounter(1) && data[rootIndex][LeftThread] == 1) {
                    MultiCounter.increaseCounter(1, 4);
                    data[rootIndex][Left] = GetNode();
                    data[data[rootIndex][Left]][Info] = val;
                    data[data[rootIndex][Left]][RightThread] = 1;
                    data[rootIndex][LeftThread] = 0;
                }
                else{
                    MultiCounter.increaseCounter(1, 5);
                    data[rootIndex][Left] = GetNode();
                    data[data[rootIndex][Left]][Info] = val;
                    data[data[rootIndex][Left]][RightThread] = 1;
                    data[rootIndex][LeftThread] = 0;
                    data[data[rootIndex][Left]][Right] = rootIndex;
                }
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
        helperPointer =Avail;
        Avail = data[Avail][Right];
        data[helperPointer][Right]=-1;
        return helperPointer;
    }


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
    private  void InitializeArray(){
        for(int i=data.length-1; i>=0; i--){
            FreeNode(i);
        }
    }

}
