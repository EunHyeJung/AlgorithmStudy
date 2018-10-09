import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* @source https://www.acmicpc.net/problem/1965
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.09
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] box = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (box[i] > box[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxCnt = Math.max(dp[i], maxCnt);
        }

        System.out.println(maxCnt);
    }
}
