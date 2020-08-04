package com.template.tree;

import java.util.Stack;

/**
 * 从先序遍历还原二叉树
 */
public class RecoverTree1028 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public TreeNode recoverFromPreorder(String S) {
        if(S.length()<1 || S == null) return null;
        int num = 0, index = 0, size=0;
        for(char c; index<S.length() && (c = S.charAt(index))!='-';++index){
            num *= 10;
            num += c-'0';
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode node = new TreeNode(num);
        TreeNode root = node;
        stack.push(node);
        while(index < S.length()){
            size = 0;
            for(char c; index<S.length() && (c = S.charAt(index))=='-';++index){
                size++;
            }
            num = 0;
            for(char c; index<S.length() && (c = S.charAt(index))!='-';++index){
                num *= 10;
                num +=  c-'0';
            }
            while(size < stack.size()){
                stack.pop();
            }
            node = stack.peek();
            TreeNode tmp = new TreeNode(num);
            if(node.left == null) node.left = tmp;
            else node.right = tmp;
            stack.push(tmp);
        }
        return root;
    }
}
