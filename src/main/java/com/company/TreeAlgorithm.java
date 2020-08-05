package com.company;

import java.util.Scanner;

/**
 * @description: 树相关算法
 * @author: cfireworks
 * @create: 2020-05-26 12:23
 **/
public class TreeAlgorithm {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String argv[]){
        Scanner sc = new Scanner(System.in);

    }

    /**
     * 判断两棵树是否相同
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSame(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        else if(root1==null || root2==null) return false;
        else return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
