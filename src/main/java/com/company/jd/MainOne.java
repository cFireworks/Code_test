package com.company.jd;

import java.util.Scanner;

public class MainOne {

    public static void calcSum(int n){
        // 1/5*(2*n)(2*n-1)
        double sum = 0;
        for(int i=1; i<=n; ++i){
            sum += 1.0/(2*i*(2*i-1));
        }
        System.out.println(String.format("%.4f",sum/5));
    }

    public static boolean isSu(int n){
        if(n < 4) return true;
        int k = (int)Math.sqrt(n*1.0);
        for(int i=2; i<=k;++i){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isHuiWen(int n){
        if(n<10)
            return true;
        int tmp = 0;
        int ori = n;
        while(n > 0){
            tmp = tmp*10 + n%10;
            n /= 10;
        }
        return tmp == ori;
    }

    public static int calCount(int n, int m){
        int count = 0;
        for(int num = n; num <= m; ++num){
            int inds = num/10 + 1;
            int head = num;
            int tail = 0;
            int flag = 1;
            for(int ind=0; ind < inds; ++ind){
                int t = head%10;
                head /= 10;
                int newNum = head*flag + tail;
                if(isHuiWen(newNum) && isSu(newNum)){
                    count++;
                    break;
                }
                tail = tail*10 + t;
                flag *= 10;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = calCount(n, m);
        System.out.println(res);
    }
}
