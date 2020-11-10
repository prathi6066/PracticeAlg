package prathi.learn.practicealg.dp;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][]input = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(input));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] board = new int[m][n];

        board[0][0] = grid[0][0];

        for (int i=1;i<m;i++) {
            board[i][0] = board[i-1][0] + grid[i][0];
        }

        for (int i=1;i<n;i++) {
            board[0][i] = board[0][i-1] + grid[0][i];
        }

        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                board[i][j] = Math.min(board[i-1][j] + grid[i][j], board[i][j-1] + grid[i][j]);
            }
        }

        return board[m-1][n-1];

    }
}
