package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P46 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> current = new ArrayList<>();
    private boolean[] flags;

    private void dfs(int[] nums) {
        if (current.size() == nums.length + 1){
            List<Integer> tmp = new ArrayList<>(current.subList(1, current.size()));
            result.add(tmp);
            return;
        }
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                current.add(nums[i]);
                flags[i] = true;
                dfs(nums);
                flags[i] = false;
                current.remove(Integer.valueOf(nums[i]));
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        current.add(Integer.MIN_VALUE);
        flags = new boolean[nums.length];
        dfs(nums);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P46().permute(new int[]{1,2,3}));
    }
}
