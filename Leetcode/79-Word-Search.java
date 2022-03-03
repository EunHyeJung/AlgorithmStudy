/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.03
*/
class Solution {
    public boolean isExist = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] chk;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    chk = new boolean[m][n];
                    chk[i][j] = true;
                    explore(board, word.toCharArray(), i, j, 0, chk);
                    if (isExist)
                        return true;
                }
            }
        }


        return false;
    }

  public void  explore(char[][] board, char[] word, int i, int j, int cur, boolean[][] chk)   {
        if (cur + 1 == word.length) {
            isExist = true;
            return;
        }

        if (i + 1 < board.length && board[i + 1][j] == word[cur + 1] && !chk[i + 1][j]) {
            chk[i + 1][j] = true;
            explore(board, word, i + 1, j, cur + 1, chk);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == word[cur + 1] && !chk[i][j + 1]) {
            chk[i][j + 1] = true;
            explore(board, word, i, j + 1, cur + 1, chk);
        }
        if (i - 1 >= 0 && board[i - 1][j] == word[cur + 1] && !chk[i - 1 ][j]) {
            chk[i - 1][j] = true;
            explore(board, word, i - 1, j , cur + 1, chk);
        }
        if (j - 1 >= 0 && board[i][j - 1] == word[cur + 1] && !chk[i][j - 1]) {
            chk[i][j - 1] = true;
            explore(board, word, i, j - 1 , cur + 1, chk);
        }
        if (!isExist)
            chk[i][j] = false;
    }
}
