package com.company;

import java.util.*;

/**
 * @description: tencent
 * @author: cfireworks
 * @create: 2020-04-26 19:59
 **/
public class Tencent {
    private static double calculate(List<int[]> A, List<int[]> B){
        double min = Double.MAX_VALUE;
        for(int[] a : A){
            for(int[] b : B){
                double ppa = (a[0] - b[0])*(a[0] - b[0]);
                double ppb = (a[1] - b[1])*(a[1] - b[1]);
                min = Math.min(min, Math.sqrt(ppa+ppb));
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casecnt = sc.nextInt();
        for(int i=0; i<casecnt; ++i){
            int n = sc.nextInt();
            List<int[]> inputA = new ArrayList<>();
            for(int j=0; j<n; ++j){
                int[] pair = new int[2];
                pair[0] = sc.nextInt();
                pair[1] = sc.nextInt();
                inputA.add(pair);
            }
            List<int[]> inputB = new ArrayList<>();
            for(int j=0; j<n; ++j){
                int[] pair = new int[2];
                pair[0] = sc.nextInt();
                pair[1] = sc.nextInt();
                inputB.add(pair);
            }
            System.out.println(calculate(inputA, inputB));

        }
    }
}

//    Stack<Integer> stack1 = new Stack();
//    Stack<Integer> stack2 = new Stack();
//    int top=-1;
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//        for(int i=0; i<n; i++){
//        String str = sc.next();
//        if(str.equals("add")){
//        int val = sc.nextInt();
//        if(stack1.isEmpty() && stack2.isEmpty()) top = val;
//        if(stack2.isEmpty()) stack1.push(val);
//        else{
//        while(!stack2.isEmpty()){
//        stack1.push(stack2.pop());
//        }
//        stack1.push(val);
//        }
//        }
//        else if(str.equals("poll")){
//        if(stack2.isEmpty()) {
//        while (!stack1.isEmpty()) {
//        stack2.push(stack1.pop());
//        }
//        }
//        stack2.pop();
//        if(stack2.isEmpty()) top = -1;
//        else top = stack2.peek();
//        }
//        else if(str.equals("peek")){
//        if(top != -1) System.out.println(top);
//        }
//        }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i=0;i<n;i++){
//            int q = sc.nextInt();
//            Queue<Integer> queue=new LinkedList<>();
//            for(int j=0;j<q;j++){
//                String str=sc.next();
//                if(str.equals("PUSH")){
//                    int value=sc.nextInt();
//                    queue.add(value);
//                }
//                else if(str.equals("TOP")){
//                    if(queue.peek()==null) System.out.println(-1);
//                    else System.out.println(queue.peek());
//                }
//                else if(str.equals("POP")){
//                    if(queue.poll()==null)
//                        System.out.println(-1);
//                }
//                else if(str.equals("SIZE")){
//                    System.out.println(queue.size());
//                }
//                else if(str.equals("CLEAR")){
//                    queue.clear();
//                }
//            }
//        }
//    }