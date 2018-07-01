import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Hackerrank. Alternating Characters
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.07.01
 * @link https://www.hackerrank.com/challenges/alternating-characters/problem?
 *       h_l=playlist&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-
 *       kit&slugs%5B%5D=strings
 */

public class Solution {

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		int cnt = 0;
		for (int i = 1, n = s.length(); i < n; i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				cnt++;
			}
		}
		return cnt;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = alternatingCharacters(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
