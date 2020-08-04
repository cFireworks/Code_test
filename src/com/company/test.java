package com.company;

import java.util.*;

/**
 * @description:
 * @author: cfireworks
 * @create: 2020-03-24 16:46
 **/
public class test {

    public static int[] BitSort(int[] arr){
        if(arr.length < 2) return arr;
        int max = arr[0];
        int min = arr[0];
        for(int num : arr){
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        BitSet bitSet = new BitSet(max-min+1);
        for(int num : arr){
            bitSet.set(num-min);
        }
        int ind = 0;
        for(int i=0; i<=max-min; ++i){
            if(bitSet.get(i)){
                arr[ind++] = i+min;
            }
        }
        return arr;
    }

    public static int longestSum(int[] arr, int target){
        int n = arr.length;
        if(n < 1) return 0;
        int[] sum = new int[n+1];
        sum[0] = arr[0];
        for(int i=1; i<=n; ++i){
            sum[i] = sum[i-1] + arr[i-1];
        }
        int len = 0;
        int left = n;
        for(int i=n; i>0; --i){
            for(int j=0; j<left; ++j){
                if(sum[i]-sum[j] == target){
                   len = Math.max(len, i-j);
                   left = j;
                   break;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,5,-2,3};
        int target = 3;
        int[] nums2 = {-2,-1,2,1};
        int target2 = 1;
        int res = longestSum(nums, target);
        int res2 = longestSum(nums2, target2);
        System.out.println(res);
    }
}
