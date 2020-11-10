package prathi.learn.practicealg.dp;

public class UniquePathII {

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {0,0},
                {1,1},
                {0,0}};
        System.out.println(uniquePathsWithObstacles(input));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] board = new int[m][n];

        boolean isBlocked = false;
        for (int i = 0;i < m;i++) {

            if (obstacleGrid[i][0] != 1)
                board[i][0] = (isBlocked) ? 0: 1;
            else
                isBlocked = true;
        }

        isBlocked = false;
        for (int i = 1;i < n;i++) {
            if (obstacleGrid[0][i] != 1)
                board[0][i] = (isBlocked) ? 0: 1;
            else
                isBlocked = true;
        }

        for (int i=1;i<m; i++) {
            for (int j =1;j<n;j++) {
                if (obstacleGrid[i][j] != 1) {
                    board[i][j] = board[i-1][j] + board[i][j-1];
                } else {
                   board[i][j] = 0;
                }
            }
        }

        return  board[m-1][n-1];
    }
}
