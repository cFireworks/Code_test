package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;


public class Solution {
    private List<String> res = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root){
        if(root == null) return res;
        dfs(root, "");
        return res;
    }
    private void dfs(TreeNode root, String path){
        if(root.left == null && root.right == null){
            res.add(path + root.val);
            return;
        }else if(root.left == null){
            dfs(root.right, path + root.val + "->");
        }else if(root.right == null){
            dfs(root.left, path + root.val + "->");
        }else{
            dfs(root.left, path + root.val + "->");
            dfs(root.right, path + root.val + "->");
        }
        return;
    }

    public static void main(String[] args){
        int[] board = {1,2,3,-1,5};
        List<TreeNode> queue = new ArrayList();
        Set<Integer> hashset = new HashSet();
        for(int i:board){
            TreeNode node;
            if(i == -1){
                node = null;
            }else{
                node = new TreeNode(i);
            }
            queue.add(node);
        }
        for(int i=0; i<queue.size()/2; i++){
            TreeNode cur = queue.get(i);
            cur.left = queue.get(i*2 + 1);
            cur.right = queue.get(i*2 + 2);
        }
        TreeNode root = queue.get(0);
        String word = "ba";
        Solution solution = new Solution();
        List<String> out = solution.binaryTreePaths(root);


        System.out.println(out.toString());
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}