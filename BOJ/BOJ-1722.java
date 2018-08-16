import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static long getOrder(int[] target, int n) {
		long order = 0;
		long[] fact = new long[n + 1];
		fact[0] = 1;
		for (int i = 1; i <= n; i++) {
			fact[i] = fact[i - 1] * i;
		}

		boolean[] chk = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			int num = target[i] - 1;
			int j = num;
			while (j >= 0) {
				if (chk[j]) {
					num -= 1;
				}
				j -= 1;
			}
			chk[target[i]] = true;
			order += num * fact[n - (i + 1)];
		}
		return order + 1;
	}

	public static int[] getPermutation(int n, long order) {
		int[] permutation = new int[n];
		boolean[] chk = new boolean[n + 1];
		long[] fact = new long[n + 1];
		fact[0] = 1;
		for (int i = 1; i <= n; i++) {
			fact[i] = fact[i - 1] * i;
		}

		for (int i = 0; i < n; i++) {
			int j = 1, num = 1;
			while (chk[num]) {
				num += 1;
			}
			while (order - (fact[n - (i + 1)] * j) > 0) {
				j += 1;
				num += 1;
				while (chk[num]) {
					num += 1;
				}
			}
			order -= (fact[n - (i + 1)] * (j - 1));

			while (chk[num]) {
				num += 1;
			}
			chk[num] = true;
			permutation[i] = num;

		}
		return permutation;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String[] inputs = br.readLine().split(" ");
		int type = Integer.parseInt(inputs[0]);
		switch (type) {
		case 1:
			int[] permutation = getPermutation(n, Long.parseLong(inputs[1]));
			for (int num : permutation) {
				bw.write(num + " ");
			}
			break;
		case 2:
			int[] target = new int[n];
			for (int i = 0; i < n; i++) {
				target[i] = Integer.parseInt(inputs[i + 1]);
			}
			long order = getOrder(target, n);
			bw.write(order + "\n");
			break;
		}
		bw.flush();
	}

}
