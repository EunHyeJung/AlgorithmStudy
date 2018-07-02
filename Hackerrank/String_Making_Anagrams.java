package Etc;

/**
 * Hackerrank. Strings: Making Anagrams
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.07.02
 * @link https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=playlist&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-kit&slugs%5B%5D=strings
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {

	public static final int N = 26;

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {
		int cnt = 0;
		int[] aCharFreq = new int[N];
		int[] bCharFreq = new int[N];

		int i = 0;
		int aLength = a.length(), bLength = b.length();
		for (int n = Math.min(aLength, bLength); i < n; i++) {
			aCharFreq[a.charAt(i) - 97]++;
			bCharFreq[b.charAt(i) - 97]++;
		}
		if (aLength < bLength) {
			while (i < bLength) {
				bCharFreq[b.charAt(i) - 97]++;
				i++;
			}
		} else { // aLength >= bLength;
			while (i < aLength) {
				aCharFreq[a.charAt(i) - 97]++;
				i++;
			}
		}

		for (i = 0; i < N; i++) {
			cnt += (Math.abs(aCharFreq[i] - bCharFreq[i]));
		}
		return cnt;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = scanner.nextLine();

		String b = scanner.nextLine();

		int res = makeAnagram(a, b);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
