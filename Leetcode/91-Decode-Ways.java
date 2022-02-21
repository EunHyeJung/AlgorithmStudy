/*
* @source https://leetcode.com/problems/decode-ways/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.02.21
*/
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        if (n == 1 || nums[0] == 0)
            return nums[0] == 0 ? 0 : 1;

        int[] dp = new int[n];
        dp[0] = 1;
        if (nums[0] == 0 && nums[1] == 0)
            return 0;
        else if (nums[1] == 0 && nums[0] > 2)
            return 0;
        else if (nums[1] == 0 || nums[0] > 2 || (nums[0] > 1 && nums[1] > 6))
            dp[1] = dp[0];
        else if(nums[0] <= 2)
            dp[1] = dp[0] + 1;
        
        for(int i = 2; i < n; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0)
                return 0;
            else if (nums[i] == 0) {
                if (nums[i - 1] > 2)
                    return 0;
                else
                  dp[i] = dp[i - 2];
            } else if (nums[i] > 0 && nums[i - 1] == 0)
                dp[i] = dp[i - 1];
            else if (nums[i] > 0 && nums[i - 1] > 0) {
                if (nums[i - 1] > 2 || (nums[i - 1] > 1 && nums[i] > 6))
                    dp[i] = dp[i - 1];
                else
                    dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

         return dp[n - 1];
    }
}
