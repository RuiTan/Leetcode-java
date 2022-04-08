package jianzhi;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return val < 0 ? "null" : String.valueOf(val);
    }

    public static TreeNode generateTree(Integer[] nums) {
        int length = nums.length;
        int max = 0x80000000;
        int size = 0;
        for (int i = 31; i > 0; i--) {
            if (length == max) {
                size = i;
                break;
            }
            if ((length & max) == max){
                size = i + 1;
                break;
            }
            length = length << 1;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = createNode(nums[0]);
        nodes.offer(root);
        for (int i = 1; i <= size; i++) {
            TreeNode temp = null;
            for (int j = 1 << i; j < (1 << (i+1)); j++) {
                if (j >= nums.length) break;
                if ((j & 1) == 0) {
                    temp = nodes.poll();
                    if (temp != null){
                        temp.left = createNode(nums[j-1]);
                        nodes.offer(temp.left);
                    }
                }else{
                    if (temp != null){
                        temp.right = createNode(nums[j-1]);
                        nodes.offer(temp.right);
                    }
                }
            }
        }
        return root;
    }

    public static TreeNode createNode(Integer num){
        if (num == null) return null;
        TreeNode node = new TreeNode(num);
        return node;
    }

    public static void printTree(TreeNode node) {
        if (node == null) {
            System.out.print("null, ");
            return;
        }
        System.out.print(node.val + "(");
        printTree(node.left);
        printTree(node.right);
        System.out.print("), ");
    }

    public static TreeNode preTraverse(int index, Integer[] nums){
        if (index > nums.length) {
            return null;
        }
        if (nums[index - 1] == null) {
            return null;
        }
        TreeNode node = new TreeNode(nums[index - 1]);
        node.left = preTraverse(index * 2, nums);
        node.right = preTraverse(index * 2 + 1, nums);
        return node;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Integer[] nums = new Integer[]{1, 2, null, 3, 4, null};
        TreeNode root = preTraverse(1, nums);
        root = generateTree(nums);
        printTree(root);
    }
}
