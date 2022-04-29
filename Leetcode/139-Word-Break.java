/*
* @source https://leetcode.com/problems/word-break/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.30
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];


        for (int i = 0; i < n; i++) {
            String word = s.substring(0, i + 1);
            if (wordDict.contains(word))
                dp[i] = true;
            else {
                for (int j = 0; j <= i; j++) {
                  String wordSubStr = word.substring(j, i + 1);
                  if (word.equals("ab")) {
                      System.out.println(wordSubStr);
                  }
                  if (j == 0) {
                      dp[i] = wordDict.contains(wordSubStr) ? true : false;
                  } else if (dp[j - 1] && wordDict.contains(wordSubStr)) {
                      dp[i] = true;
                      break;
                  }
                }
            }
        }
        for (int i= 0; i <n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[n - 1];
    }
}
