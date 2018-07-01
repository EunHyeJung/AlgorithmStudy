
/**
 * Leetcode. 476. Number Complement
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.07.01
 * @link https://leetcode.com/problems/number-complement/discuss/130294/Java-2-
 *       Solutions-beats-99
 */

public class Solution {

	public int findComplement(int num) {
		int i = 0, res = 0;

		while (num > 0) {
			res = res + ((num % 2 == 1 ? 0 : 1) * (int) Math.pow(2, i++));
			num /= 2;
		}
		return res;
	}

	public static void main(String[] args) {
		int num = 5;
		System.out.println(new Solution().findComplement(num));

	}
}
