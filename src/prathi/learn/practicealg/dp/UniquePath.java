package prathi.learn.practicealg.dp;

public class UniquePath {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
    // base case - > board[0][any] = 1 and board[any][0] = 1, board[0][0] = 0
    // board[i][j] = board[i-1][j] + board[i][j-1]
    private static int uniquePaths(int m, int n) {

        int[][] board = new int[m][n];

        for (int i = 0;i< m; i++) {
            board[i][0] = 1;
        }

        for (int i =0; i< n ;i++) {
            board[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                board[i][j] = board[i-1][j] + board[i][j-1];
            }
        }

        return board[m-1][n-1];

    }
}
