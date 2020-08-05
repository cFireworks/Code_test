package com.company;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ReverseTask extends RecursiveTask<String> {
    private static final int Threshold = 2;
    private String str;
    private int start;
    private int end;
    public ReverseTask(String str, int start, int end){
        this.str = str.substring(start, end);
        this.start = start;
        this.end = end;
    }

    @Override
    protected String compute() {
        boolean canCompute = (end-start) < Threshold;
        if(canCompute){
            return str;
        }else{
            int len = end - start;
            ReverseTask leftTask = new ReverseTask(str, 0, len>>1);
            ReverseTask rightTask = new ReverseTask(str, len>>1, len);
            leftTask.fork();
            rightTask.fork();
            String leftResult = leftTask.join();
            String rightResult = rightTask.join();
            return rightResult + leftResult;
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        String str;
        //String str = "abcde";
        //String str = "a";
        //String str = "";
        System.out.print("请输入任意字符:\n");
        str = sc.nextLine();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ReverseTask task = new ReverseTask(str, 0, str.length());
        Future<String> result = forkJoinPool.submit(task);
        try{
            System.out.println(result.get());;
        }catch(InterruptedException e){
            System.out.println(e);
        }catch(ExecutionException e){
            System.out.println(e);
        }
    }

    public String reverse(String s){
        int len = s.length();
        if(len<2) return s;
        String left = s.substring(0, len>>1);
        String right = s.substring(len>>1,len);
        return reverse(right)+reverse(left);
    }

}
