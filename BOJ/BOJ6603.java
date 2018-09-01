import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		try {
			Lotto lotto = new Lotto();
			lotto.execute();
		} catch (IOException e) {

		}
	}

}

class Lotto {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static final int N = 6;
	private List<Integer> numList;
	private List<Integer> selectedNumList;

	public void execute() throws IOException {
		while (true) {
			String[] inputs = br.readLine().split(" ");
			int k = Integer.parseInt(inputs[0]);

			if (k == 0) {
				bw.close();
				br.close();
				return;
			}
			numList = new ArrayList<>();
			selectedNumList = new ArrayList<>();

			for (int i = 1; i <= k; i++) {
				numList.add(Integer.parseInt(inputs[i]));
			}

			selectNums(0, k);

			bw.write("\n");
			bw.flush();
		}

	}

	public void selectNums(int idx, int k) throws IOException {
		if (selectedNumList.size() == N) {
			for (int num : selectedNumList) {
				bw.write(num + " ");

			}
			bw.write("\n");
			return;
		}
		for (int i = idx; i < k; i++) {
			selectedNumList.add(numList.get(i));
			selectNums(i + 1, k);
			selectedNumList.remove(numList.get(i));
		}

	}

}
