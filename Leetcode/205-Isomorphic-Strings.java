/*
* @source https://leetcode.com/problems/isomorphic-strings/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.19
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n == 1)
            return true;
        Map<Character, Character> map = new HashMap<>();
        boolean[] flag = new boolean[128];
        for (int i = 0; i < n; i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if (!map.containsKey(sCh)) {
                if (flag[(int) tCh])
                    return false;
                map.put(sCh, tCh);
                flag[(int) tCh] = true;
                continue;
            }
            if (map.get(sCh) != tCh)
                return false;
        }
        return true;
    }
}
