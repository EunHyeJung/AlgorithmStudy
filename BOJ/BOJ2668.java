import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			NumPicker numPicker = new NumPicker();
			numPicker.init();
			numPicker.pickNums();
			numPicker.printSelectedNums();
		} catch (IOException e) {

		}
	}

}

class NumPicker {
	public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private int[] nums;
	private boolean[] isSelected;
	private int n;

	public void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		nums = new int[n + 1];
		isSelected = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
	}

	public void pickNums() {
		for (int i = 1; i <= n; i++) {
			if (i == nums[i]) {
				isSelected[i] = true;
			} else {
				boolean[] chk = new boolean[n + 1];
				chk[i] = true;
				dfs(i, nums[i], chk);

			}
		}

	}

	public void printSelectedNums() throws IOException {
		StringBuilder res = new StringBuilder();
		int cnt = 0;
		for (int num = 1; num <= n; num++) {
			if (isSelected[num]) {
				res.append(num + "\n");
				cnt += 1;
			}
		}
		res.insert(0, cnt + "\n");
		bw.write(res.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public void dfs(int stIdx, int idx, boolean[] chk) {
		if (stIdx == idx) {
			for (int num = 1; num < chk.length; num++) {
				if (chk[num]) {
					isSelected[num] = true;
				}
			}
		}

		if (!chk[idx]) {
			chk[idx] = true;
			dfs(stIdx, nums[idx], chk);
		}

	}

}
