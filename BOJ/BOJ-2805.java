import java.io.*;

/*
* https://www.acmicpc.net/problem/2805
* ehye826@gamil.com
*/
public class Main {

    public static void main(String[] args) {
        try {
            TreeCutter treeCutter = new TreeCutter();
            treeCutter.inputData();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(treeCutter.getMaxHeightOfTree() +" \n");
            bw.flush();

        } catch (IOException e) {

        }
    }
}

class TreeCutter {
    private int n;
    private long[] trees;
    private long m;
    private long maxHeight;

    public void inputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        this.n = Integer.parseInt(inputs[0]);
        this.m = Integer.parseInt(inputs[1]);
        this.maxHeight = Long.MIN_VALUE;

        this.trees = new long[n];
        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            this.trees[i] = Long.parseLong(inputs[i]);
            this.maxHeight = Math.max(trees[i], maxHeight);
        }
    }

    public long getMaxHeightOfTree() {
        long res = 0;
        long left = 0, right = maxHeight;

        while (left <= right) {
            long cutHeight = (left + right) / 2;
            if (cutHeight < 1) {
                cutHeight = right;
            }
            long sumOfHeight = 0;

            if ((sumOfHeight = getHeightOfTree(cutHeight)) >= m) {
                res = Math.max(res, cutHeight);
                left = cutHeight + 1;
            } else {
                right = cutHeight - 1;
            }

        }

        return res;
    }

    public long getHeightOfTree(long cutHeight) {
        long sumOfHeight = 0;
        for (long height : trees) {
            sumOfHeight += (cutHeight < height ? height - cutHeight : 0);
        }
        return sumOfHeight;
    }
}

