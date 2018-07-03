import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 819. Most Common Word
 * 
 * @author EunHyeJung
 * @email ehye826@gmail.com
 * @date 2018.07.03
 * @link https://leetcode.com/problems/most-common-word/description/
 */

public class Solution {

	public String mostCommonWord(String paragraph, String[] bannedWords) {
		String[] splits = paragraph.toLowerCase().split(" ");

		Map<String, Integer> wordCounter = new HashMap<>();
		boolean isBannedWord = false;

		for (String split : splits) {
			String word = split.replaceAll("[^A-Za-z]", "");
			isBannedWord = false;
			for (String bannedWord : bannedWords) {
				if (word.equals(bannedWord)) {
					isBannedWord = true;
					break;
				}

			}
			if (!isBannedWord) {
				wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
			}

		}

		int maxCnt = Integer.MIN_VALUE;
		String mostCommonWord = null;

		for (String word : wordCounter.keySet()) {
			if (maxCnt < wordCounter.get(word)) {
				maxCnt = wordCounter.get(word);
				mostCommonWord = word;
			}
		}

		return mostCommonWord;
	}

	public static void main(String[] args) {
		String[] bannedWords = {};
		String res = new Solution().mostCommonWord("a.", bannedWords);
		System.out.println(res);
	}
}
