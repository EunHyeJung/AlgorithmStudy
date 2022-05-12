/*
* @source https://leetcode.com/problems/detect-capital/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.12
*/
class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        for (int i = 1; i < n; i++) {
            boolean isUpperCase = Character.isUpperCase(word.charAt(i));
            if (Character.isLowerCase(word.charAt(i - 1)) && isUpperCase)
                return false;
            if (i > 1 && Character.isUpperCase(word.charAt(i - 1)) && !isUpperCase)
                return false;
        }
        return true;
    }
}
