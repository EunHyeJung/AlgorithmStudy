import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/10942
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.12
*/
public class Main {
    public static void main(String[] args) throws IOException {

        try {
            PalindromeIdentifier palindromeIdentifier = new PalindromeIdentifier();
            palindromeIdentifier.respondQuestion();
        } catch (IOException e) {

        }
    }
}

class PalindromeIdentifier {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int n;
    private int[] nums;
    private int[][] dp;

    public PalindromeIdentifier() throws IOException {
        this.n = Integer.parseInt(br.readLine());
        this.nums = new int[n];
        this.dp = new int[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    public void respondQuestion() throws IOException {
        chk(0, n - 1);

        int m = Integer.parseInt(br.readLine());
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            chk(s - 1, e - 1);
            int response = dp[s - 1][e - 1] == 1 ? 1 : 0;
            output.append(response + "\n");
        }
        System.out.println(output);
    }

    public int chk(int s, int e) {
        if (dp[s][e] > 0) {
            return dp[s][e];
        }
        if (s == e) {
            return (dp[s][e] = 1);
        }
        if (e - s == 1) { //  1 1, 1 2
            return (dp[s][e] = nums[s] == nums[e] ? 1 : 2);
        } else {
            if (nums[s] == nums[e]) {
                dp[s][e] = chk(s + 1, e - 1);
            } else {
                dp[s][e] = 2;
            }
        }
        return dp[s][e];
    }
}
