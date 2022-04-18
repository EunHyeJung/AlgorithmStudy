/*
* @source https://leetcode.com/problems/search-a-2d-matrix-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.18
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int row = 0; row < n; row++) {
            if (matrix[row][0] > target)
                return false;
            if (matrix[row][m - 1] < target)
                continue;            
            if (binarySearch(matrix[row], m, target))
                return true;
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int n, int target) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int midPos = (left + right) / 2;
            if (arr[midPos] == target)
                return true;
            else if (arr[midPos] > target)
                right = midPos - 1;
            else
                left = midPos + 1;
        }
        return false;
    }
}
