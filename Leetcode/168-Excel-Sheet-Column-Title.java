/*
* @source https://leetcode.com/problems/excel-sheet-column-title/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.04
*/
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        if (columnNumber <= 26)
            return sb.append((char) (columnNumber + 64)).toString();

        while (columnNumber > 0) {
            if (columnNumber % 26 == 0) {
                remain = 26;
                columnNumber =  (columnNumber / 26) - 1;
            } else {
                remain = columnNumber % 26;
                columnNumber /= 26;
            }
            sb.append((char) (remain + 64));
        }
        return sb.reverse().toString();
    }
}
