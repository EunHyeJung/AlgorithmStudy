/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.01.29
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[] chkRow = new boolean[m];
        boolean[] chkCol = new boolean[n];
        for (int i = 0 ; i< m; i++) {
            for (int j = 0; j <n; j++) {
                if (matrix[i][j] == 0) {
                    chkRow[i] = true;
                    chkCol[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (chkRow[i] || chkCol[j])
                    matrix[i][j] = 0;
            }
        }
    }
}
