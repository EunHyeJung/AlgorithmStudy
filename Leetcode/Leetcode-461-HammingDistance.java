/*
* @source https://leetcode.com/problems/hamming-distance/description/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.09.29
*/
class Solution {
	public int hammingDistance(int x, int y) {
		int cnt = 0;
		int n = x ^ y;
    
		while (n > 0) {
			cnt += (n & 1);
			n >>= 1;
		}
		return cnt;
	}
}
