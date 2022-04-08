package leetcode;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P752 {
    private Queue<Integer> queue = new LinkedList<>();
    private Set<Integer> set = new HashSet<>();
    private DecimalFormat df = new DecimalFormat("0000");

    private boolean addNext(int curr) {
        int[] v = new int[4];
        v[0] = curr/1000;
        v[1] = curr/100 - v[0]*10;
        v[2] = curr/10 - v[0]*100 - v[1]*10;
        v[3] = curr - v[0]*1000 - v[1]*100 - v[2]*10;
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                int temp = v[i];
                v[i] = j == 0 ? v[i] + -1 : v[i] + 1;
                v[i] = v[i] == -1 ? 9 : v[i] == 10 ? 0 : v[i];
                int next = v[0] * 1000 + v[1] * 100 + v[2] * 10 + v[3];
                if (!set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                    flag = true;
                }
                v[i] = temp;
            }
        }
        return flag;
    }

    public int openLock(String[] deadends, String target) {
        for (String d: deadends) {
            set.add(Integer.valueOf(d));
        }
        if (set.contains(0)) return -1;
        queue.offer(0);
        set.add(0);
        int height = 0;
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                flag = addNext(curr) || flag;
                if (Integer.parseInt(target) == curr){
                    return height;
                }
            }
            // 说明这一轮遍历下来，都遍历过了或者都在死亡列表中
            // 这里有个小前提，遍历过的节点不可能出现在当前Queue里面，也就是说当前节点
            //不可能转动一次变成这一层的任何一个节点，因此在set中，说明要么死亡、要么
            //死循环
            if (!flag) return -1;
            height++;
        }
        return -1;
    }

    public int openLockDoubleBFS(String[] deadends, String target) {
        for (String d: deadends) {
            set.add(Integer.parseInt(d));
        }
        if (set.contains(0)) return -1;
        Set<Integer> q1 = new HashSet<>();
        Set<Integer> q2 = new HashSet<>();
        q1.add(0);
        q2.add(Integer.parseInt(target));
        int height = 0;
        while (!q1.isEmpty() && !q2.isEmpty()){
            Set<Integer> temp = new HashSet<>();
            boolean flag = false;
            for (Integer curr : q1) {
                if (set.contains(curr))
                    continue;
                set.add(curr);
                if (q2.contains(curr))
                    return height;
                char[] strIs = df.format(curr).toCharArray();
                for (int i = 0; i < 4; i++) {
                    // pushDown
                    strIs[i] = strIs[i] == '0' ? '9' : (char) (strIs[i] - 1);
                    int pushDown = Integer.parseInt(new String(strIs));
                    if (!set.contains(pushDown)) {
                        temp.add(pushDown);
                        flag = true;
                    }
                    strIs[i] = strIs[i] == '9' ? '1' : strIs[i] == '8' ? '0' : (char) (strIs[i] + 2);
                    int pushUp = Integer.parseInt(new String(strIs));
                    if (!set.contains(pushUp)) {
                        temp.add(pushUp);
                        flag = true;
                    }
                    strIs[i] = strIs[i] == '0' ? '9' : (char) (strIs[i] - 1);
                }
            }
            if (!flag) return -1;
            if (temp.size() > q2.size()){
                q1 = q2;
                q2 = temp;
            }else {
                q1 = temp;
            }
            height++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new P752().openLockDoubleBFS(
                new String[] {"0201","0101","0102","1212","2002"},
                "0202"
        ));
    }
}
