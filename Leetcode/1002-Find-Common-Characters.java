/*
* @source https://leetcode.com/problems/find-common-characters/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.15
*/
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int[][] charArr = new int[n][26];
        for (int i = 0; i < n; i++) {
            char[] wordChArr = words[i].toCharArray();
            for (int j = 0, m = wordChArr.length; j < m; j++) {
                charArr[i][(int) wordChArr[j] - 97] += 1;
            }
        }
        for (int i = 0; i <= 25; i++) {
            int cnt = charArr[0][i];
            char ch = (char) (i + 97);
            if (cnt > 0) {
                for (int j = 1; j < n; j++) {
                    cnt = Math.min(charArr[j][i], cnt);
                    if (cnt == 0)   break;
                }
                while(cnt > 0) {
                    res.add(Character.toString(ch));
                    cnt -= 1;
                }
            }
        }
        return res;
    }
}
