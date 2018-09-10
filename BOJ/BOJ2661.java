import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		new Main().solveProblem(n);
	}
	
	public void solveProblem(int n) {
		makeSeq("", n);
	}

	public  boolean makeSeq(String seq, int n) {
		if (seq.length() == n) {
			System.out.println(seq);
			return true;
		} else if (seq.length() > n) {
			return false;
		}
		for (int i = 1; i <= 3; i++) {
			if (isGoodSeq(seq + i) && makeSeq(seq + i, n)) {
				return true;
			}
		}
		return false;
	}

	public  boolean isGoodSeq(String seq) {
		for (int i = 0, n = seq.length(); i < n; i++) {
			for (int j = 1; i + 2 * j <= n; j++) {
				if (seq.substring(i, i + j).equals(seq.substring(i + j, i + 2 * j))) {
					return false;
				}

			}
		}
		return true;
	}
}
