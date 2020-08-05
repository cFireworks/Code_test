package com.company.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<int[]> inputs = new ArrayList();
        for(int i=0; i<m; ++i){
            int[] tmp = new int[6];
            for(int j=0; j<6; ++j){
                tmp[j] = sc.nextInt();
            }
        }
        // 上下和左右可以直接交换
        // 左右和前后交换需要调换其中一个顺序
        // 上下和前后交换需要调换一个顺序
        // 将每一个情况依据上下进行变换，尽量统一
        for(int[] list : inputs){
            if(list[0] == 1) continue;
        }
    }
    public static void convert(int[] list){
        for(int i=0; i<3; ++i){
            if(list[i*2] == 1 || list[i*2+1] == 1){

            }
        }
    }
}
