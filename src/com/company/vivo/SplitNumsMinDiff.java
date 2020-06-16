package com.company.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @description: 数组分为两部分，使得两部分的差最小
 * @author: cfireworks
 * @create: 2020-06-07 11:38
 **/
public class SplitNumsMinDiff {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }
    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    public static int zeroOneBag(int N, int V, int[] C, int[] W){
        // 初始化背包
        int[] dp = new int[V+1];
        // 计算
        for(int i=0; i<N; ++i){
            // ZeroOnePack
            for(int v = V; v>=C[i]; --v){
                dp[v] = Math.max(dp[v], dp[v-C[i]]+W[i]);
            }
        }
        return dp[V];
    }


    private static int solution(int[] input) {

        // TODO Write your code here
        int sum = 0, n = input.length;
        for (int weight : input) sum += weight;
        int rows = (n + 1) / 2, cols = sum / 2;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < n; i++) {
            int weight = input[i];
            for (int j = Math.min(rows, i + 1); j > 0; j--) { // 注意
                for (int k = cols; k >= weight; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - 1][k - weight] + weight);
                }
            }
        }
        if ((n & 1) == 0) return sum - dp[rows][cols] * 2;
        return sum - Math.max(dp[rows][cols], dp[rows - 1][cols]) * 2;
    }

//    private static int solution(int[] input) {
//
//        // TODO Write your code here
//        int sum = 0;
//        for(int num : input){
//            sum += num;
//        }
//        int[] w = new int[input.length];
//        for(int i=0; i<input.length; i++){
//            w[i] = input[i]*2;
//        }
//        // 求2 subsum最大
//        int res = zeroOneBag(input.length, sum, w, w);
//
//        return sum-res;
//    }
}
