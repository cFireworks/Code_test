package com.company.vivo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 数位之乘积满足要求的最小正整数
 * @author: cfireworks
 * @create: 2020-06-06 15:37
 **/
public class NumProduction {
    public static int solution (int n) {
        // write code here
        if(n < 4) return n;
        int[] zNum = {2,3,5,7};
        Stack<Integer> nums = new Stack<Integer>();
        for(int z : zNum){
            while(n%z == 0){
                n = n/z;
                nums.push(z);
            }
        }
        if(n > 1) return -1;
        int k = 1;
        int val = 0;
        int tmp = nums.pop();
        System.out.print(tmp+" ");
        List<Integer> res = new ArrayList();
        while(!nums.isEmpty()){
            int top = nums.pop();
            System.out.print(top+" ");
            if(tmp*top<10){
                tmp*=top;
                if(nums.isEmpty()) res.add(tmp);
            }
            else{
                res.add(tmp);
                tmp = top;
                if(nums.isEmpty()) res.add(tmp);
            }
        }
        res.sort((u,v)->v-u);
        for(int num:res){
            val += num*k;
            k*=10;
        }
        System.out.print("\n");
        return val;
    }
    public static void main(String[] args){
        int res = solution(362880);
        System.out.println(res);
    }
}
