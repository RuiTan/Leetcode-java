package leetcode;

import java.util.Arrays;

public class P354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (x, y) -> {
            if (x[0] == y[0]) return y[1] - x[1];
            else return x[0] - y[0];
        });
        int len = envelopes.length;
        int[] heaps = new int[len];
        Arrays.fill(heaps, Integer.MAX_VALUE);
        int maxIndex = 0;
        for (int[] envelope : envelopes){
            int left = 0, right = maxIndex - 1;
            int curr = envelope[1];
            if (maxIndex == 0) {
                heaps[0] = curr;
                maxIndex++;
                continue;
            }
            if (curr <= heaps[left]) {
                heaps[0] = curr;
                continue;
            }
            if (curr > heaps[right]) {
                heaps[maxIndex++] = curr;
                continue;
            }
            while (left < right) {
                int mid = (left + right) / 2;
                if (mid == left) {
                    heaps[right] = curr;
                    break;
                }
                if (curr < heaps[mid]) {
                    right = mid;
                } else if(curr > heaps[mid]) {
                    left = mid;
                } else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(heaps));
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(new P354().maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}}));
    }
}
