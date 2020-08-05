package com.company.pdd;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; ++i){
            arr[i] = sc.nextInt();
        }
        if(k == 0){
            System.out.println("paradox");
        }else{
            int count = 0;
            boolean flag = true;
            for(int i=0; i<n; ++i){
                if(arr[i] == k){
                    if(i == n-1){
                        System.out.println("0 "+count);
                    }else{
                        System.out.println("paradox");
                    }
                    flag = false;
                    break;
                }
                else if(arr[i]>k){
                    k = arr[i] - k;
                    count++;
                }else{
                    k -= arr[i];
                }
            }
            if(flag){
                System.out.println(""+k+" "+count);
            }
        }
    }
}
