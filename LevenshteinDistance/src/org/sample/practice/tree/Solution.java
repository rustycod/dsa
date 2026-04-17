package org.sample.practice.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    
    
    public int minDepth(TreeNode root) {

    // Corner case
    if (root == null)
        return 0;

    // Base case : Leaf Node. This accounts for height = 1.
    if (root.left == null && root.right == null)
        return 1;

    // If left subtree is NULL, recur for right subtree
    if (root.left == null)
        return minDepth(root.right) + 1;

    // If right subtree is NULL, recur for left subtree
    if (root.right == null)
        return minDepth(root.left) + 1;

    return Math.min(minDepth(root.left),
                    minDepth(root.right)) + 1;


    }
    
    
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;
    }

    private int getHeight(TreeNode root) {

        if(root == null) return 0;

        int leftHeight = diameterOfBinaryTree(root.left);
        int rightHeight = diameterOfBinaryTree(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);

    }
    
    // Input: arr[] = {10, 5, 3, 4, 3, 5, 6}
    
    public int findFirstRepeatingElement(int[] arr) {
    	
    	int firstRepeatingElement = -1;
    	
    	Map<Integer, Integer> countMap = new HashMap<>();
    	
    	for(int num : arr) {
    		countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    	}
    	
    
    	return firstRepeatingElement;
    	
    }
    
    
    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0) {
        	return -1;
        }
        
        if(nums.length == 1) return nums[0];
    	
    	// array is sorted already
        if(nums[0] < nums[nums.length-1]) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        int mid = 0;

        while(start <= end) {

            mid = start + (end - start) / 2;

            if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }

            if(nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
        
    }
    
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // tree 1
        /*TreeNode n1 = new TreeNode(1);        
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;        
        TreeNode n4 = new TreeNode(4);
        n2.left = n4;        
        TreeNode n5 = new TreeNode(5);
        n2.right = n5;       
        TreeNode n6 = new TreeNode(6);
        n5.left = n6;*/
        
        /*TreeNode n1 = new TreeNode(1);        
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;*/
      
       int[] nums = new int[] {2,3,4,5,6,7,1};
        
       
        System.out.println("pivot: "+sol.findMin(nums));
        
        
        
    }
}
