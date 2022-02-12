/*
* @source https://leetcode.com/problems/rotate-image/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.12
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return;
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) continue;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
