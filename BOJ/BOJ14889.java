import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
* @source https://www.acmicpc.net/problem/14889
* @author EunHyeJung
* @email ehye826@gamil.com
* @date 2018.09.18
*/
public class Main {
	public static void main(String[] args) {
		try {
			TeamMaker teamMaker = new TeamMaker();
			IOUtils.writeOutput(teamMaker.getMinValueOfAbility());
		} catch (IOException e) {

		}
	}
}

class TeamMaker {
	private int n;
	private int[][] people;
	private int minValue;
	private int numOfTeamMember;
	private boolean[] chk;

	public TeamMaker() throws IOException {
		this.init();
		this.minValue = Integer.MAX_VALUE;
	}

	public void init() throws IOException {
		this.n = Integer.parseInt(IOUtils.readInput());
		this.numOfTeamMember = n / 2;
		this.chk = new boolean[n];
		this.people = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] inputs = IOUtils.readInput().split(" ");
			for (int j = 0; j < n; j++) {
				people[i][j] = Integer.parseInt(inputs[j]);
			}
		}

	}

  // 2개의 팀으로 분할하는 함수 
  // boolean 배열을 이용해 true, false 두 개의 부류로 나눔.
	public void divideMember(int idx, int cur) {
		if (idx >= numOfTeamMember) {
			calculateValue();
			return;
		}

		for (int i = cur; i < n; i++) {
			chk[i] = true;
			divideMember(idx + 1, i + 1);
			chk[i] = false;
		}
	}


  // 각 팀의 능력치를 계산하는 함수
  // chk[i] 값이 true이면 스타트팀, fasle이면 링크팀으로 
	public void calculateValue() {
		int startTeamValue = 0;
		int linkTeamValue = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (chk[i] && chk[j]) {
					startTeamValue += people[i][j];
				} else if (!chk[i] && !chk[j]) {
					linkTeamValue += people[i][j];
				}
			}
		}
		minValue = Math.min(minValue, Math.abs(linkTeamValue - startTeamValue));
	}

	public int getMinValueOfAbility() {
		divideMember(0, 0);
		return minValue;
	}

}

class IOUtils {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String readInput() throws IOException {
		return br.readLine();
	}

	public static void writeOutput(int output) throws IOException {
		bw.write(output + "\n");
		bw.flush();
	}
}
