import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		try {
			Teacher teacher = new Teacher();
			IOUtils.writeOutput(teacher.getMaxLearnWordCnt());
		} catch (IOException e) {

		}
	}

}

class Teacher {
	private int n, k;
	private List<Set<Character>> words;
	private int maxCnt;
	private Set<Character> alphabets;

	public Teacher() throws IOException {
		String[] inputs = IOUtils.readInput().split(" ");
		n = Integer.parseInt(inputs[0]);
		k = Integer.parseInt(inputs[1]);
		words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char[] word = IOUtils.readInput().toCharArray();
			Set<Character> set = new HashSet<>(Arrays.asList('a', 'n', 't', 'i', 'c'));
			for (int j = 4, len = word.length - 4; j < len; j++) {
				set.add(word[j]);
			}
			if (set.size() <= k) {
				words.add(set);
			}
		}
		maxCnt = 0;
		alphabets = new HashSet<>(Arrays.asList('a', 'n', 't', 'i', 'c'));

	}

	public int getMaxLearnWordCnt() {
		checkLearnWords(k, 0, alphabets);
		return maxCnt;
	}

	public void checkLearnWords(int k, int cur, Set<Character> alphabets) {
		if (alphabets.size() == k) {
			int cnt = 0;
			for (Set<Character> word : words) {
				if (alphabets.containsAll(word)) {
					cnt += 1;
				}
			}
			maxCnt = Math.max(cnt, maxCnt);
			return;
		}
		for (int i = cur; i < 26; i++) {
			if (alphabets.contains((char) (i + 97))) {
				continue;
			}
			alphabets.add((char) (i + 97));
			checkLearnWords(k, i + 1, alphabets);
			alphabets.remove((char) (i + 97));
		}
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
