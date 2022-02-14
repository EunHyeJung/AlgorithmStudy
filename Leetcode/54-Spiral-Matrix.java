/*
* @source https://leetcode.com/problems/spiral-matrix/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.14
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1) {
            res.add(matrix[0][0]);
            return res;
        }
        
        boolean[][] chk = new boolean[m][n];
        int i = 0, j = 0;
        boolean flag = true;
        res.add(matrix[i][j]);
        chk[i][j] = true;
        while (true) {
            while(j + 1 < n && !chk[i][j + 1]) {
                res.add(matrix[i][j + 1]);
                chk[i][j + 1] = true;
                j += 1;
                flag = false;
            }

            if (!flag)
                j = j >= n ? j - 1 : j;
            else
                flag = true;

            while(i + 1 < m && !chk[i + 1][j]) {
                res.add(matrix[i + 1][j]);
                chk[i + 1][j] = true;
                i += 1;
                flag = false;
            }

            if (!flag)
                i = i >= m ? i - 1 : i;
            else
                flag = true;

            while(j - 1>= 0 && !chk[i][j - 1]) {
                res.add(matrix[i][j - 1]);
                chk[i][j - 1] = true;
                j -= 1;
                flag = false;
            }

            if (!flag)
                j = j < 0 ? j + 1 : j;
            else
                flag = true;

            while(i - 1 >= 0 && !chk[i - 1][j]) {
                res.add(matrix[i - 1][j]);
                chk[i - 1][j] = true;
                i -= 1;
                flag = false;
            }
            if (!flag)
                i = i < 0 ? i + 1 : i;
            else
                flag = true;

            if (flag)
                break;
            flag = true;
        }
        return res;
    }
}
