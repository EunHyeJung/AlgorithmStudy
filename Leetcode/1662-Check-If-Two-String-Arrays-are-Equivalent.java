/*
* @source https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.06.19
*/
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for (String word : word1) {
            sb1.append(word);
        }
        for (String word : word2) {
            sb2.append(word);
        }
        
        return sb1.toString().equals(sb2.toString());
    }
}
