import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/2609
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.05
*/
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		int gcd = getGCD(Math.max(num1, num2), Math.min(num1, num2));
		int lcm = getLCM(num1, num2, gcd);
		System.out.println(gcd);
		System.out.println(lcm);
	}

	public static int getGCD(int num1, int num2) {
		while ((num1 % num2) > 0) {
			int tmp = num2;
			num2 = num1 % num2;
			num1 = tmp;
		}
		return num2;
	}

	public static int getLCM(int num1, int num2, int gcd) {
		return gcd * (num1 / gcd) * (num2 / gcd);
	}

}
