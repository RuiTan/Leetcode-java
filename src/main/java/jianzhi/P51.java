package jianzhi;

import java.util.LinkedList;
import java.util.List;

public class P51 {
    private List<List<String>> result = new LinkedList<>();
    private int[][] chess;
    private int[] indices;
    private List<String> queens;

    private void generateQueen(int n) {
        StringBuilder sb = new StringBuilder();
        queens = new LinkedList<>();
        for (int i = 0; i < n; i++) sb.append('.');
        for (int i = 0; i < n; i++) {
            sb.replace(i, i+1, "Q");
            queens.add(sb.toString());
            sb.replace(i, i+1, ".");
        }
    }

    private void markRelated(int i, int j, int n, int mark){
        for (int k = 0; k < n; k++) {
            chess[k][j] += mark;
        }
        int x = i, y = j;
        while (x>=0 && x<=n-1 && y>=0 && y <= n-1){
            chess[x][y] += mark;
            x--;
            y++;
        }
        x = i; y = j;
        while (x>=0 && x<=n-1 && y>=0 && y <= n-1){
            chess[x][y] += mark;
            x++;
            y++;
        }
        x = i; y = j;
        while (x>=0 && x<=n-1 && y>=0 && y <= n-1){
            chess[x][y] += mark;
            x--;
            y--;
        }
        x = i; y = j;
        while (x>=0 && x<=n-1 && y>=0 && y <= n-1) {
            chess[x][y] += mark;
            x++;
            y--;
        }
    }

    public void dfs(int n, int i){
        if (i >= n) {
            LinkedList<String> tmp = new LinkedList<>();
            for (int k: indices) {
                tmp.addLast(queens.get(k));
            }
            result.add(tmp);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (chess[i][j] == 0) {
                indices[i] = j;
                markRelated(i, j, n, 1);
                dfs(n, i+1);
                markRelated(i, j, n, -1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        chess = new int[n][n];
        indices = new int[n];
        generateQueen(n);
        dfs(n, 0);
        return result;
    }

    public static void main(String[] args) {
        P51 sol = new P51();
        System.out.println(sol.solveNQueens(7));
        System.out.println(sol.result.size());
    }
}
