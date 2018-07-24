import java.io.*;

/*
* @author EunHyeJung
* @email ehye826@gmail.com
* @linke https://www.acmicpc.net/problem/2512
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        long[] localBudegts = new long[n];
        
        long maxLocalBudget = Long.MIN_VALUE;
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            localBudegts[i] = Long.parseLong(inputs[i]);
            maxLocalBudget = Math.max(localBudegts[i], maxLocalBudget);
        }

        long nationalBudget = Long.parseLong(br.readLine());

        long left = 1, right = maxLocalBudget;
        long ans = 0;
        while (left <= right) {
            long pivotBudget = (left + right) / 2;
            long sumOfBudgets = 0;

            for (Long budget : localBudegts) {
                sumOfBudgets += (budget > pivotBudget) ? pivotBudget : budget;
            }

            if (sumOfBudgets <= nationalBudget) {
                ans = Math.max(pivotBudget, ans);
                left = pivotBudget + 1;
            } else {
                right = pivotBudget - 1;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
