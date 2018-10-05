import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/9613
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.05
*/
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numOfCases = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for (int caseIdx = 0; caseIdx < numOfCases; caseIdx++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			long sumOfGcd = 0l;
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					sumOfGcd += (getGCD(nums[j], nums[k]));
				}
			}
			sb.append(sumOfGcd + "\n");

		}
		System.out.println(sb);
	}

	public static int getGCD(int num1, int num2) {
		while ((num1 % num2) > 0) {
			int tmp = num2;
			num2 = num1 % num2;
			num1 = tmp;
		}
		return num2;
	}

}
