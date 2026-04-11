package org.sample.practice.tree;

import java.util.LinkedList;
import java.util.List;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
     
     @Override
     public String toString() {
         return ""+this.val;
     }
 }

public class Solution {

    private List<String> list = new LinkedList<>();
    private String path = new String();
    
    public List<String> binaryTreePaths(TreeNode root) {

        // base condition
        if(root == null) return null; 
       

        // add root.val in string
        path = add(path, root.val);

        // if it's leaf node, print the path
        if(root.left == null && root.right == null) {
            String copy = new String(path);
            list.add(copy);
        } else {
            binaryTreePaths(root.left);
            binaryTreePaths(root.right);
        }
        
        // remove root.val in string
        path = remove(path, root.val);

        return list;
    }

    private String add(String str, int val) {

        if(str.isBlank()) {
            str += val;
        } else {
            str += "->"+val;
        }
        return str;
    }

    private String remove(String str, int val) {

        if(str.contains("->")) {
            str = str.replace("->"+val, "");            
        } else {
            str = str.replace(""+val, "");
        }
        return str;
    }
    
    

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        TreeNode n1 = new TreeNode(1);
        
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        
        TreeNode n4 = new TreeNode(5);
        n2.right = n4;
        
        sol.binaryTreePaths(n1);
        
        System.out.println("list: "+sol.list);
        
    }
}
