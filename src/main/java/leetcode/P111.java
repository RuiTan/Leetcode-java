package leetcode;

import jianzhi.TreeNode;

import java.util.*;

public class P111 {
    private List<List<Integer>> result = new LinkedList<>();
    private List<Integer> temp = new LinkedList<>();

    private void operate(TreeNode node){
        temp.add(node.val);
    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null){
                    operate(node);
                    if (height != 0 && (node.left == null || node.right == null))
                        return ++height;
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
            }
            result.add(new LinkedList<>(temp));
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        System.out.println(new P111().minDepth(TreeNode.generateTree(new Integer[]{3,9,20,null,null,15,7})));
    }
}
