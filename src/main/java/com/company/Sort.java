package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class Sort {
    public static void main(String argv[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = sc.nextInt();
        }

        Sort sort = new Sort();
//        sort.quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        sort.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    void heapSort(int[] arr){
        buildHeap(arr);
        for(int N=arr.length-1; N>0; --N){
            swap(arr, 0, N);
            heapfy(arr, 0, N);
        }
    }
    void buildHeap(int[] arr){
        for(int i=arr.length/2-1; i>=0; --i){
            heapfy(arr, i, arr.length);
        }
    }
    void heapfy(int[] arr, int root, int len){
        if(len < 2) return;
        int tmp = arr[root];
        int child;
        for(; (child = root*2+1)<len; root = child){
            if(child+1 < len && arr[child] < arr[child+1]){
                child++;
            }
            if(tmp < arr[child]){
                arr[root] = arr[child];
            }else{
                break;
            }
        }
        arr[root] = tmp;
    }

    public void bubbleSort(int[] arr){
        int n = arr.length;
        for(int j = n; j>0; --j){
            for(int i=1; i<j; ++i){
                if(arr[i] < arr[i-1]){
                    swap(arr, i-1, i);
                }
            }
        }
    }


    public void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int splitIndex = partition(arr, start, end);
        quickSort(arr, start, splitIndex-1);
        quickSort(arr, splitIndex+1, end);
        return;
    }
    private int partition(int[] arr, int start, int end){
        int index = start + 1;
        for(int i = index; i<=end; i++){
            if(arr[i] < arr[start]){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, start ,index-1);
        return index-1;
    }

    private void swap(int[] arr, int i, int j){
        if(i==j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
}
