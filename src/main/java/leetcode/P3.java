package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P3 {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<Character>();
        int length = 0;
        for (Character i : s.toCharArray()){
            if (queue.contains(i)){
                Character j;
                do {
                    j = queue.poll();
                }while (j != i);
            }
            queue.offer(i);
            length = Math.max(length, queue.size());
        }
        return length;
    }

    public static void main(String[] args){
        System.out.println(new P3().lengthOfLongestSubstring("abcabcabc"));
    }
}


