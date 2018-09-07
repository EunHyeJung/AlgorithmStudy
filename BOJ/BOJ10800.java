import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		try {
			BallGame game = new BallGame();
			game.init();
			game.getResult();
		} catch (IOException e) {

		}

	}
}



class BallGame {
	private static final int SIZE_MAX = 2000;
	private int n;
	private Queue<Ball> balls;
	private Map<Integer, Integer> res;

	public void init() throws IOException {
		this.n = Integer.parseInt(IOUtils.readInput());
		balls = new PriorityQueue<>();

		this.res = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String[] inputs = IOUtils.readInput().split(" ");
			int color = Integer.parseInt(inputs[0]);
			int size = Integer.parseInt(inputs[1]);
			balls.add(new Ball(i, color, size));
		}

	}

	public void getResult() throws IOException {
		playGame();

		for (int no = 1; no <= n; no++) {
			IOUtils.writeOuput(res.getOrDefault(no, 0));
		}
	}

	public void playGame() {

		Map<Integer, Integer> colorSum = new HashMap<>();

		int[] sizeCounter = new int[SIZE_MAX + 1];
		int curSum = 0;

		int dup = 0;
		Ball prevBall = null;
		while (!balls.isEmpty()) {
			Ball ball = balls.poll();
			int no = ball.getNo();
			int size = ball.getSize();
			int color = ball.getColor();

			int culColorSum = colorSum.getOrDefault(color, 0);
			int total = curSum - culColorSum;
			// 
			if (prevBall != null && prevBall.getColor() == ball.getColor() && prevBall.getSize() == ball.getSize()) {
				dup += 1;
			} else {
				dup = 0;
			}
			total -= (sizeCounter[size] - dup) * size;
			res.put(no, total);
			sizeCounter[size] += 1;

			//sizeColorCunter[size][color] += 1;

			colorSum.put(color, culColorSum + size);
			curSum += size;
			prevBall = ball;
		}
	}
}

class Ball implements Comparable<Ball> {
	private int no;
	private int color;
	private int size;

	public Ball(int no, int color, int size) {
		this.no = no;
		this.color = color;
		this.size = size;
	}

	public int getNo() {
		return no;
	}

	public int getColor() {
		return color;
	}

	public int getSize() {
		return size;
	}

	@Override
	public int compareTo(Ball b) {
		if (this.getSize() == b.getSize()) {
			return this.getColor() - b.getColor();
		}
		return this.getSize() - b.getSize();
	}
}


class IOUtils {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void writeOuput(int output) throws IOException {
		bw.write(output + "\n");
		bw.flush();
	}
}
