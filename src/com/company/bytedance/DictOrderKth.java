package com.company.bytedance;

/**
 * @description: leetcode 440. 字典序的第K小数字
 * @author: cfireworks
 * @create: 2020-06-15 23:41
 **/
public class DictOrderKth {

    private int getSteps(int n, int cur, int next){
        int steps = 0;
        while(cur <= n){
            steps += Math.min(n+1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return steps;
    }
    public int findKthNumber(int n, int k){
        int cur = 1;
        k = k -1;
        while(k>0){
            int steps = getSteps(n, cur, cur+1);
            if(steps > k){
                cur*=10;
                k -= 1;
            }else{
                cur += 1;
                k -= steps;
            }
        }
        return cur;
    }
}
