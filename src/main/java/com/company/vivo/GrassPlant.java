package com.company.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @description: 间隔种树
 * @author: cfireworks
 * @create: 2020-06-07 15:12
 **/
public class GrassPlant {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int maxn = 0;
        int[] input = new int[size];
        for(int i=0; i<size; ++i){
            input[i] = sc.nextInt();
            if(input[i] == 0) maxn++;
        }
        int res = 0;
        for(int i=0; i<=maxn; i++){
            int[] tmp = new int[size];
            for(int j=0;j<size; ++j) tmp[j] = input[j];
            if(canPlant(tmp, i)){
                res = i;
            }
        }
        System.out.println(res);

    }
    public static boolean canPlant(int[] input, int n){
        int i=0;
        int count = 0;
        while(i<input.length){
            if(input[i] == 0 && (i==0 || input[i-1]==0) && (i==input.length-1 || input[i+1] == 0) ){
                input[i++]=1;
                count++;
            }
            if(count>=n) return true;
            i++;
        }
        return false;
    }
}
