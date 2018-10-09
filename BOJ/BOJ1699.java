import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* @source https://www.acmicpc.net/problem/1699
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.10
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int k = 1; k * k <= i; k++) {
                dp[i] = Math.min(dp[i - k * k] + 1, dp[i]);
            }
        }
        System.out.println(dp[n]);

    }


}
