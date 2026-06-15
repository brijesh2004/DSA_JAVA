public class Game_of_Life{
     public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<List<Integer>> ch = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cntLives = 0;
                if (i - 1 >= 0 && board[i - 1][j] == 1)
                    cntLives++;
                if (j - 1 >= 0 && board[i][j - 1] == 1)
                    cntLives++;
                if (i + 1 < m && board[i + 1][j] == 1)
                    cntLives++;
                if (j + 1 < n && board[i][j + 1] == 1)
                    cntLives++;
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1)
                    cntLives++;
                if (i - 1 >= 0 && j + 1 <n && board[i - 1][j + 1] == 1)
                    cntLives++;
                if (i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] == 1)
                    cntLives++;
                if (i + 1 <m && j + 1 < n && board[i + 1][j + 1] == 1)
                    cntLives++;

                if (board[i][j] == 1) {
                    if (cntLives == 2 || cntLives == 3) {

                    } else {
                        ch.add(new ArrayList<>(Arrays.asList(i, j)));
                    }

                } else if (board[i][j] == 0) {
                    if (cntLives == 3) {
                        ch.add(new ArrayList<>(Arrays.asList(i, j)));
                    }
                }
            }

        }

        for (int i = 0; i < ch.size(); i++) {
            int x = ch.get(i).get(0);
            int y = ch.get(i).get(1);
            if(board[x][y]==0){
                board[x][y]=1;
            }else{
                board[x][y]=0;
            }
        }
    }

}