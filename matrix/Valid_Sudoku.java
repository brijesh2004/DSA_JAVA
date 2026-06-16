public class Valid_Sudoku{
     public boolean isValidSudoku(char[][] board) {

        int n = board.length;
        // validate each row
        for (int i = 0; i < n; i++) {
            Map<Character, Boolean> mp = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (mp.containsKey(board[i][j]))
                        return false;
                    mp.put(board[i][j], true);
                }
            }
        }

        // validate each col
        for (int i = 0; i < n; i++) {
            Map<Character, Boolean> mp = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (board[j][i] != '.') {
                    if (mp.containsKey(board[j][i]))
                        return false;
                    mp.put(board[j][i], true);
                }
            }
        }

        // now validate each 3x3 box

        for (int x = 0; x < n; x += 3) {
            for (int y = 0; y < n; y += 3) {
                Map<Character, Boolean> mp = new HashMap<>();
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (board[i][j] != '.') {
                            if (mp.containsKey(board[i][j]))
                                return false;
                            mp.put(board[i][j], true);
                        }
                    }
                }
            }
        }

        return true;

    }
}