/*
* @source https://leetcode.com/problems/ransom-note/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.03.13
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineChk = new int[26];
        for (int i = 0, n = magazine.length(); i < n; i++) {
            magazineChk[magazine.charAt(i) - '0' - 49] += 1;
        }
        for (int i = 0, n = ransomNote.length(); i < n; i++) {
            int idx = ransomNote.charAt(i) - '0' - 49;
            magazineChk[idx] -= 1;
            if (magazineChk[idx] < 0)
                return false;
        }
        return true;
    }
}
