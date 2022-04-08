package labuladong;

import java.util.Arrays;
import java.util.Comparator;

public class RusiaEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]> () {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        if (envelopes.length == 1){
            return 1;
        }

        int[] tops = new int[envelopes.length];
        tops[0] = envelopes[0][1];
        int count = 1;
        for (int i = 1; i < envelopes.length; i++){
            if (count == 1) {
                if (envelopes[i][1] > tops[0]) tops[count++] = envelopes[i][1];
                else tops[0] = envelopes[i][1];
                continue;
            }
            if (tops[count - 1] < envelopes[i][1]) {
                tops[count++] = envelopes[i][1];
                continue;
            }
            int left = 0, right = count - 1;
            int mid = (right + left) /2;
            while (left < right){
                if (tops[mid] < envelopes[i][1]){
                    left = mid + 1;
                }else {
                    right = mid;
                }
                mid = (right + left) / 2;
            }
            tops[left] = envelopes[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new RusiaEnvelopes().maxEnvelopes(new int[][]{{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}}));
    }
}
