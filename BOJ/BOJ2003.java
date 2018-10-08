import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/2003
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2018.10.08
*/
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = i; j < n; j++) {
                    sum += nums[j];
                    if (sum >= m) {
                        cnt = (sum == m) ? cnt + 1 : cnt;
                        break;
                    }
                }
            }
            System.out.println(cnt);

        } catch (IOException e) {

        }
    }
}

