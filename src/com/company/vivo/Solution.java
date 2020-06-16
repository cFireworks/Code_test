package com.company.vivo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
                // write your code here
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}