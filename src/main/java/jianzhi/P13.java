package jianzhi;

public class P13 {
    private int[][] matrix;
    private int[][] sum;

    public P13(int[][] matrix) {
        this.matrix = matrix;
        sum = new int[matrix.length+1][matrix[0].length+1];
        sum[1][1] = matrix[0][0];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        for (int i = 0; i < row2+1; i++) {
            int s = 0;
            for (int j = 0; j < col2+1; j++) {
                s += matrix[i][j];
                sum[i+1][j+1] = i == 0 ? s : sum[i][j+1] + s;
            }
        }
        return this.sum[row2+1][col2+1] - this.sum[row1][col2+1] - this.sum[row2+1][col1]
                + this.sum[row1][col1];
    }

    public static void main(String[] args) {
        P13 p13 = new P13(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(p13.sumRegion(2, 1, 4, 3));
    }
}

/**
 *
 ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 */