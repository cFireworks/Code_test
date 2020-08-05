package com.company.pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
// 5 1 9 9 1 4 9 3 1 2 3 6 5 9 8
public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] lunch = new int[n][2];
        int[][] dinner = new int[m][2];
        for(int i=0; i<n; ++i){
            lunch[i][0] = sc.nextInt();
            lunch[i][1] = sc.nextInt();
        }
        for(int i=0; i<m; ++i){
            dinner[i][0] = sc.nextInt();
            dinner[i][1] = sc.nextInt();
        }
        Arrays.sort(dinner, (u,v)->v[1]-u[1]);
        Arrays.sort(lunch, (u,v)->v[1]-u[1]);

        long Ksum = 0;
        long Tsum = 0;
        long kmin = Long.MAX_VALUE;
        boolean flag = false;
        for(int i=0; i<n; ++i){
            if(Tsum >= t){
                flag = true;
                kmin = Ksum<kmin?Ksum:kmin;
                break;
            }
            Tsum = lunch[i][1];
            Ksum = lunch[i][0];
            if(Tsum > t){
                flag = true;
                kmin = Ksum<kmin?Ksum:kmin;
                continue;
            }
            for(int j=0; j<m; ++j){
                Tsum += dinner[j][1];
                Ksum += dinner[j][0];
                if(Tsum < t) break;
                kmin = Ksum<kmin?Ksum:kmin;
                Tsum -= dinner[j][1];
                Ksum -= dinner[j][0];
            }
        }
        Arrays.sort(dinner, (u,v)->{
            if(u[1]==v[1]) return u[0]-v[0];
            else return v[1]-u[1];
        });
        Arrays.sort(lunch, (u,v)->{
            if(u[1]==v[1]) return u[0]-v[0];
            else return v[1]-u[1];
        });
        for(int i=0; i<=m; ++i){
            for(int j=0; j<=n; ++j){
                if(lunch[i][1] + dinner[j][1] >= t){
                    kmin = Math.min(kmin, lunch[i][0]+dinner[j][0]);
                    flag = true;
                }else{
                    break;
                }
            }
        }
        Ksum = 0;
        Tsum = 0;
        for(int i=0; i<m; ++i){
            if(Tsum >= t){
                kmin = Ksum<kmin?Ksum:kmin;
                break;
            }
            Tsum = dinner[i][1];
            Ksum = dinner[i][0];
            if(Tsum > t){
                kmin = Ksum<kmin?Ksum:kmin;
                continue;
            }
            for(int j=0; j<n; ++j){
                Tsum += lunch[j][1];
                Ksum += lunch[j][0];
                if(Tsum < t) break;
                kmin = Ksum<kmin?Ksum:kmin;
                Tsum -= lunch[j][1];
                Ksum -= lunch[j][0];
            }
        }
        if(t == 0)
            System.out.println(0);
        else
            System.out.println(kmin);

    }
}
