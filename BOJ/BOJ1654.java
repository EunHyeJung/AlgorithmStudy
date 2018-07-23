import java.io.*;

/*
* BOJ 1654. 랜선 자르기
* https://www.acmicpc.net/problem/1654
* ehye826@gmail.com
*/
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int k = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        long[] lanCables = new long[k];
        long maxLength = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            lanCables[i] = Long.parseLong(br.readLine());
            maxLength = Math.max(lanCables[i], maxLength);
        }

        LanCableCutter lanCableCutter = new LanCableCutter(lanCables, k, n, maxLength);
        bw.write(lanCableCutter.getMaxCutLengthOfLanCable() + "\n");
        bw.flush();
        bw.close();
    }
}

class LanCableCutter {
    private long[] lanCables;
    private int k;
    private int n;
    private long maxLength;

    public LanCableCutter(long[] lanCables, int k, int n, long maxLength) {
        this.lanCables = lanCables;
        this.k = k;
        this.n = n;
        this.maxLength = maxLength;
    }

    public long getMaxCutLengthOfLanCable() {
        long cutLength = 0;
        long left = 1, right = maxLength;
        while (left <= right) {
            long pivotLength = (left + right) / 2;
            try {
                int cnt = getNumOfLans(pivotLength);
                if (cnt >= n) {
                    cutLength = Math.max(pivotLength, cutLength);
                    left = pivotLength + 1;
                } else {  // cnt < n
                    right = pivotLength - 1;
                }
            } catch (ArithmeticException e) {
                return cutLength;
            }
        }
        return cutLength;
    }

    public int getNumOfLans(long pivotLength) throws ArithmeticException {
        int cnt = 0;
        for (long lanLegnth : lanCables) {
            cnt += lanLegnth / pivotLength;
        }
        return cnt;
    }
}
