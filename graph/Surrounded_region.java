public class Surrounded_region{
     private void solve(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        solve(i - 1, j, board);
        solve(i + 1, j, board);
        solve(i, j - 1, board);
        solve(i, j + 1, board);

    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // Mark all boundary-connected O's as safe
        for (int i = 0; i < n; i++) {
            solve(i, 0, board);
            solve(i, m - 1, board);
        }

        for (int j = 0; j < m; j++) {
            solve(0, j, board);
            solve(n - 1, j, board);
        }

        // Convert surrounded O -> X
        // Convert safe O -> O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}