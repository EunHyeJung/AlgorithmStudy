/*
* @source https://leetcode.com/problems/search-a-2d-matrix/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.09
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1) return matrix[0][0] == target;

        for(int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
                int left = 0, right = n -1;
                while(left <= right) {
                    int pos = (left + right) / 2;
                    if (matrix[i][pos] == target) {
                        return true;
                    } else if(matrix[i][pos] > target) {
                        right = pos - 1;
                    } else {
                        left = pos + 1;
                    }
                }
            }
        }
        return false;
    }
}
