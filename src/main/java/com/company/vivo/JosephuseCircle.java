package com.company.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @description: 循环链表，M的倍数出列，出列顺序
 * 将N（N<10000）个人排成一排，从第1个人开始报数；如果报数是M的倍数就出列，报到队尾后则回到队头继续报，直到所有人都出列；
 * @author: cfireworks
 * @create: 2020-06-07 12:02
 **/
public class JosephuseCircle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
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

    private static String solution(int[] input) {

        // TODO Write your code here

        return null;
    }
}
