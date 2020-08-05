package com.company;


//private static boolean isEight(String str){
//        if(str.length()< 3) return false;
//        if(str.charAt(0) != '0' || (str.charAt(1) != 'x' || str.charAt(1) != 'X')){
//        return false;
//        }
//        // 判断数字是不是0,1,2...9 a,b,c..f A,B,C...,F
//        for(int i=2; i<str.length(); i++){
//        if(str.charAt(i)-'a' >= 0 && str.charAt(i)-'f'<=0) continue;
//        if(str.charAt(i)-'A' >= 0 && str.charAt(i)-'F'<=0) continue;
//        if(str.charAt(i)-'0' >= 0 && str.charAt(i)-'9'<=0) continue;
//        return false;
//        }
//        return true;
//        }
//    static String[] label = {"addr", "mask", "val"};
//    static List<String> res = new ArrayList();
//    private static void search(String str, String keyword){
//        if(str.length()<18 ) return;
//        int left = str.indexOf('['), right = str.indexOf(']');
//        if(left == -1) return;
//        if(left<keyword.length()) {
//            search(str.substring(right), keyword);
//            return;
//        }
//        if(right < left) {
//            search(str.substring(left-keyword.length()), keyword);
//            return;
//        }
//        String prefix = str.substring(left-keyword.length(), left);
//        if(prefix.equals(keyword)){
//            String[] paramlist = str.substring(left+1, right).split(",");
//            String[] words = new String[3];
//            if(paramlist.length == 3){
//                boolean flag = true;
//                for(int i=0; i<3; i++) {
//                    String[] eq = paramlist[i].split("=");
//                    if(eq[0].equals(label[i]) && eq[1].length() > 2 && eq[1].charAt(0)=='0' && (eq[1].charAt(1)=='x' || eq[1].charAt(1)=='X')){
//                        words[i] = eq[1];
//                    }else{
//                        flag = false;
//                        break;
//                    }
//                }
//                if(flag){
//                    StringJoiner joiner = new StringJoiner(" ");
//                    for(String s:words) joiner.add(s);
//                    res.add(joiner.toString());
//                }
//            }
//        }
//        search(str.substring(right), keyword);
//    }
/**
 * @description:
 * @author: cfireworks
 * @create: 2020-03-24 20:21
 **/
//    public static String addInteger(String s1,String s2) {//整数大数相加
//        StringBuffer result = new StringBuffer();
//        //反转字符串，便于从低位相加
//        s1=new StringBuffer(s1).reverse().toString();
//        s2=new StringBuffer(s2).reverse().toString();
//        int len1=s1.length();
//        int len2=s2.length();
//        int maxlen=len1>len2?len1:len2;
//        //不足位补0，对齐数字
//        if(len1>len2){
//            for(int i=len2;i<len1;i++)
//                s2+="0";
//        }else if (len1<len2) {
//            for(int i=len1;i<len2;i++)
//                s1+="0";
//        }
//        boolean overflow=false;//溢出标志位
//        int takeflow=0;//进位标志位
//        //逐位相加
//        int HEX = 9;
//        for(int i=0;i<maxlen;i++){
//            if(i==maxlen-1){
//                int sum=Integer.parseInt(s1.charAt(i)+"")+Integer.parseInt(s2.charAt(i)+"")+takeflow;
//                if(sum>=HEX){
//                    result.append(sum-HEX);
//                    takeflow=1;
//                    overflow=true;
//                }else {
//                    result.append(sum);
//                    takeflow=0;
//                }
//            }else {
//                int sum=Integer.parseInt(s1.charAt(i)+"")+Integer.parseInt(s2.charAt(i)+"")+takeflow;
//                if(sum>=HEX){
//                    result.append(sum-HEX);
//                    takeflow=1;
//                }else {
//                    result.append(sum);
//                    takeflow=0;
//                }
//            }
//        }
//        if(overflow){
//            result.append(1);
//        }
//        return result.reverse().toString();
//    }
//
//    private static String addDecimal(String s1,String s2) {
//        int dindex1=s1.indexOf('.');//找出两个数的小数点位置，用于分割数字
//        int dindex2=s2.indexOf('.');
//        String z1 = "";//第一个数的整数部分
//        String z2 = "";//第二个数的整数部分
//        String d1 = "";//第一个数的小数部分
//        String d2 = "";
//        StringBuffer result = new StringBuffer();//存放结果
//        if(dindex1!=-1){//第一个数没有小数部分
//            z1=s1.substring(0, dindex1);
//            d1=s1.substring(dindex1+1);
//        }else{//有
//            z1=s1;
//            d1="";
//        }
//        if(dindex2!=-1){
//            z2=s2.substring(0, dindex2);
//            d2=s2.substring(dindex2+1);
//        }else{
//            z2=s2;
//            d2="";
//        }
//        result.append(addInteger(z1, z2));//两个数的整数部分相加结果
//        //求出两个数小数部分较长的一个的长度，可用于判断小数部分相加后有无进位
//        int maxlen=d1.length()>d2.length()?d1.length():d2.length();
//        String dres = addInteger(d1, d2);//小数部分相加结果
//        if (maxlen<dres.length()) {//小数部分相加后有进位
//            result=new StringBuffer(addInteger(result.toString(), "1"));
//            if (dindex1!=-1||dindex2!=-1) {//两个数中至少有一个带小数
//                result.append(".");
//            }
//            dres=dres.substring(1);
//            result.append(dres);
//        } else {//小数部分相加后无进位
//            if (dindex1!=-1||dindex2!=-1) {
//                result.append(".");
//            }
//            result.append(dres);
//        }
//        return result.toString();
//    }
//        for(int i=0; i<n; i++){
//            if(i+1 == n || arr[i] != arr[i+1]){
//                count++;
//                arr[index++] = arr[i];
//            }
//        }

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        long start = k/n;
        k%=n;
        if(k == 0)
            System.out.println("("+arr[(int)start-1]+","+arr[n-1]+")");
        else if(k>n*n)
            System.out.println("("+arr[n-1]+","+arr[n-1]+")");
        else
            System.out.println("("+arr[(int)start]+","+arr[(int)k-1]+")");
    }
}
