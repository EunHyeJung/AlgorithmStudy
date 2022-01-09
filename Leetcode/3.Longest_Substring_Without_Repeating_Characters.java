/*
* @source https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.09
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, j = 0;
        for(int i = 0, n = s.length(); i < n; i++) {
            char curCh = s.charAt(i);
            if (map.containsKey(curCh)) {
                j = Math.max(map.get(curCh) + 1, j);
            }
            maxLength = Math.max(i - j + 1, maxLength);
            map.put(curCh, i);
        }
        return maxLength;
    }
}
