package com.template.strings;

/**
 * @description: KMP，字符串匹配
 * @author: cfireworks
 * @create: 2020-06-11 21:46
 **/
public class KMP {

    public static int[] calNextArray(char[] str){
        int n = str.length, k = -1, ind = 0;
        int[] next = new int[n];
        next[0] = -1;
        while(ind < n-1){
            if(k == -1 || str[ind] == str[k]){
                next[++ind] = ++k;
                if(str[ind] == str[k]) next[ind] = next[k];
            }else{
                k = next[k];
            }
        }
        return next;
    }

    public static int kmp(char[] target, char[] pattern){
        int[] next = calNextArray(pattern);
        int i=0,j=0, m=target.length, n=pattern.length;
        while(i < m && j < n){
            if(j == -1 || target[i] == pattern[j]){
                i++;
                j++;
                if(j == n) break;
            }else{
                j = next[j];
            }
        }
        if(j == n) return i-n;
        else return -1;
    }

    public static void main(String[] args){
        String str1 = "abcdefg";
        String str2 = "cde";
        char[] astr1 = str1.toCharArray();
        char[] astr2 = str2.toCharArray();
        System.out.println(kmp(astr1,astr2));
    }
}
