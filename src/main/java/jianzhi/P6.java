package jianzhi;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P6 {
    public int[] twoSum(int[] numbers, int target) {
        int sum;
        int i = 0, j = numbers.length - 1;
        while (i < j){
            sum = numbers[i] + numbers[j];
            if (sum == target){
                break;
            }else if (sum > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{i, j};
    }
}
