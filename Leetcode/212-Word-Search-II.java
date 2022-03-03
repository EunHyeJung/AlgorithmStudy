/*
* @source https://leetcode.com/problems/word-search-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.03
*/
class Solution {
    public List<String> res = null;
    private boolean isExist = false;

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        for(String word : words) {
            char ch = word.charAt(0);
            List<String> wordsList = null;
            if (!map.containsKey(ch))
                wordsList = new ArrayList<>();
            else
                wordsList = map.get(ch);
            wordsList.add(word);
            map.put(ch, wordsList);
        }
        boolean[][] chk = null;
        for (int i = 0, m = board.length; i < m; i++) {
            for (int j = 0, n = board[0].length; j < n; j++) {
                if (map.containsKey(board[i][j])) {
                    List<String> wordList = map.get(board[i][j]);
                    for(String word : wordList) {
                        chk = new boolean[m][n];
                        chk[i][j] = true;
                        isExist = false;
                        explore(board, word.toCharArray(), i, j, 0, chk);
                    }
                }
            }
        }

        return res;
    }
    public void  explore(char[][] board, char[] word, int i, int j, int cur, boolean[][] chk) {
        if (isExist)
            return;
        if (cur + 1 == word.length) {
            String existWord = new String(word);
            isExist = true;
            if (res.contains(existWord))
                return;                 
            res.add(existWord);
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
