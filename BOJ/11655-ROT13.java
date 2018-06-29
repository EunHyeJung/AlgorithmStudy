import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 11655. ROT13
 * @author EunHyeJung 
 * @email ehye826@gmail.com
 * @date 2018.06.29
 * @link https://www.acmicpc.net/problem/11655
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		StringBuffer res = new StringBuffer();
		for (int i = 0, n = input.length(); i < n; i++) {
			char ch = input.charAt(i);

			if (Character.isUpperCase(ch)) {
				ch += 13;
				if (ch > 90) {
					ch -= 26;
				}
			} else if (Character.isLowerCase(ch)) {
				ch += 13;
				if (ch > 122) {
					ch -= 26;
				}
			}
			res.append(ch);
		}
		System.out.println(res);

	}
}