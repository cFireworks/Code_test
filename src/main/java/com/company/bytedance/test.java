package com.company.bytedance;

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
    static List<Integer> list = new ArrayList<>();

    public static void worker(){
        synchronized (list){
            while(true){
                list.add(0);
                list.remove(list.size()-1);
            }
        }
    }
    static volatile int[] a = new int[3];

    public static void te(int num) throws InterruptedException {
        a[0] = 1;
        System.out.println(a[0]);
    }

    public static void lcs(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] dp = new int[s1.length+1][s2.length+1];
        int max = 0;
        for(int i=0; i<s1.length; ++i){
            for(int j=0; j<s2.length; ++j){
                if(s1[i] == s2[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws InterruptedException {
        lcs("abcdef", "bcd");
        // System.out.println(num);
    }
}
