/*
* @source https://leetcode.com/problems/reverse-words-in-a-string/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.11
*/
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] splitArr = s.split(" ");
        for (int i = splitArr.length - 1; i >= 0; i--) {
            if (splitArr[i].trim().length() == 0)
                continue;
            res.append(splitArr[i] + " ");
        }
        return res.toString().trim();
    }
}
