package com.company.tplink;

import java.util.*;

/**
 * @description:
 * @author: cfireworks
 * @create: 2020-03-24 16:46
 **/
public class SecondTurn {

    private int max = 0;

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int v){
            this.val = v;
        }
    }

    public int maxSamePathLen(TreeNode root){
        if(root == null) return 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int sizeLeft = 0, sizeRight = 0;
        if(root.left != null && root.val == root.left.val) {
            sizeLeft = maxSamePathLen(root.left) + 1;
        }
        if(root.right != null && root.val == root.right.val){
            sizeRight = maxSamePathLen(root.right)+1;
        }
        max = Math.max(max, sizeLeft+sizeRight);
        Map<Integer, Set<String>> hashmap = new HashMap();
        hashmap.computeIfAbsent(1, k->new HashSet());

        return Math.max(sizeLeft, sizeRight);
    }

    public boolean canGrow(int[] arr, int n){
        int i = 0, size = arr.length, count = 0;
        while(i < size){
            if(arr[i] == 0 && (i==0 || arr[i-1] == 0) && (i == size-1 || arr[i+1] == 0)){
                arr[i++] = 1;
                count++;
            }
            if(count >= n){
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(",");
        // rand(5) [0,4]  [0,6]
    }
}
