import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @source https://www.acmicpc.net/problem/1806
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
            int s = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");

            int[] nums = new int[n+1];
            for (int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(getMinLength(nums, n, s));

        } catch (IOException e) {

        }
    }

    public static int getMinLength(int[] nums, int n, int s) {
        int leftPointer = 1, rightPointer = 1;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        while (rightPointer <= n) {
            sum += nums[rightPointer];
            if (sum >= s) {
                while (sum - nums[leftPointer] >= s) {
                    sum -= nums[leftPointer];
                    leftPointer += 1;
                }
                length = Math.min(length, (rightPointer - leftPointer + 1));
            }
            rightPointer += 1;
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }

}

