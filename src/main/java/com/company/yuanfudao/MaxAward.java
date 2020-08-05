package com.company.yuanfudao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 最大奖励值
 * @author: cfireworks
 * @create: 2020-08-01 19:54
 **/
public class MaxAward {

    public static int mod = 1000000003;
    static public void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new InputStreamReader(new FileInputStream("src/com/company/yuanfudao/input")));
        int N = sc.nextInt();
        for(int i=0; i<N; ++i){
            long A = sc.nextLong();
            int B = sc.nextInt();
        }
    }
}
class Node{
    public List<Node> next;
    public int val;
    public Node(int v){
        val = v;
        next = new ArrayList();
    }
}
