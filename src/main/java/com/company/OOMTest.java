package com.company;

import java.io.FileReader;
import java.util.*;
import java.io.BufferedReader;

public class OOMTest {
    static class OOMObject{}

    public static void main(String[] args){
        String[] filenameA = {"A","B"};
        String[] filenameB = {"B","C"};
//        //read file  A
//        Map<String,Boolean> hashmap = new HashMap();
//        for(String str:filenameA) {
//            hashmap.put(str, true);
//        }
//        //read file B
//        for(String str:filenameB){
//            if(hashmap.containsKey(str) && hashmap.get(str)==true){
//                System.out.println(str);
//                hashmap.put(str, false);
//            }
//        }
//        //分割数量
//        int splitCount = 2^10;
//        List<ArrayList<String>> targetFileA = new ArrayList<>();
//        for(int i=0; i<splitCount;i++){
//            targetFileA.add(new ArrayList<String>());
//        }
//        //read file A and split file
//        for(String str:filenameA){
//            int index = str.hashCode()%splitCount;
//            targetFileA.get(index).add(str);
//        }
//        List<ArrayList<String>> targetFileB = new ArrayList<>();
//        //read file B and split file
//        for(String str:filenameB){
//            int index = str.hashCode()%splitCount;
//            targetFileB.get(index).add(str);
//        }
//        for(int i=0; i<splitCount;i++){
//            List<String> tarA = targetFileA.get(i);
//            List<String> tarB = targetFileB.get(i);
//            //read file  A
//            Map<String,Boolean> splitHashmap = new HashMap();
//            for(String str:tarA) {
//                splitHashmap.put(str, true);
//            }
//            //read file B
//            for(String str:tarB){
//                if(splitHashmap.containsKey(str) && splitHashmap.get(str)==true){
//                    System.out.println(str);
//                    splitHashmap.put(str, false);
//                }
//            }
//        }
        int m = 100, n = 10000;
        int[][] list = new int[m][n];
        // 文件内元素的索引
        int[] index = new int[m];
        // 头m个元素的值，以及对应的文件索引
        int[] curVal = new int[m];
        int[] fileIndex = new int[m];
        for(int i=0; i<index.length; i++){
            curVal[i] = list[i][index[i]];
            fileIndex[i] = i;
        }
        buildHeap(curVal, fileIndex);
        // heap是否空
        int heapLen = curVal.length;
        while(heapLen>0){
            System.out.println(curVal[0]);
            int find = fileIndex[0];
            index[find] ++;
            // 判断index[find]是否超出长度
            if(list[find].length==index[find]) {
                swap(curVal, 0, heapLen - 1);
                swap(fileIndex, 0, heapLen - 1);
                heapLen--;
            }else{
                curVal[0] = list[find][index[find]];
            }
            heapfy(curVal, 0, heapLen, fileIndex);
        }

    }
    private static void buildHeap(int[] arr, int[] index){
        for(int i=arr.length/2-1; i>=0; i--){
            heapfy(arr, i, arr.length, index);
        }
        return;
    }
    private static void heapfy(int[] arr, int root, int len, int[] index){
        int tmp = arr[root];
        int tmpIndex = index[root];
        int left = root*2+1;
        while(left < len){
            if(left+1<len && arr[left+1]<arr[left]){
                left++;
            }
            if(arr[left] > tmp){
                break;
            }
            arr[root] = arr[left];
            index[root] = index[left];
            root = left;
        }
        arr[root] = tmp;
        index[root] = tmpIndex;
        return;
    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
