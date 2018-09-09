import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		try {
			CardGame cardGame = new CardGame();
			cardGame.playGame();
		} catch (IOException e) {

		}
	}
}

class CardGame {
	private int n;
	private Queue<Integer> queue;

	public CardGame() throws IOException {
		this.n = Integer.parseInt(IOUtils.readInput());
		this.queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
	}

	public void playGame() throws IOException {
		int card = 0;
		while (!queue.isEmpty()) {
			card = queue.poll();
			if (queue.isEmpty()) {
				IOUtils.writeOutput(card);
				return;
			}
			card = queue.poll();
			queue.add(card);
		}
		IOUtils.writeOutput(card);
	}
}
class IOUtils {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void writeOutput(int input) throws IOException {
		bw.write(input + "\n");
		bw.flush();
	}

}
