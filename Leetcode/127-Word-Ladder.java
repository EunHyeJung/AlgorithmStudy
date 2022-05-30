/*
* @source https://leetcode.com/problems/word-ladder/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.30
*/

class Solution {
       public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<wordLadder> queue = new LinkedList<>();
        Set<String> chkSet = new HashSet<>();
        chkSet.add(beginWord);
        queue.add(new wordLadder(beginWord, 1, chkSet));
        int len = beginWord.length();

        while (!queue.isEmpty()) {
            wordLadder curWordLadder = queue.poll();
            String  curWord = curWordLadder.getWord();
            int curStep = curWordLadder.getStep();
            chkSet = curWordLadder.getChkSet();

            if (curWord.equals(endWord)) {
                return curStep;
            }
            for (String word : wordList) {
                if (chkSet.contains(word))
                    continue;
                int diff = 0;
                for (int i = 0; i < len; i++) {
                    if (curWord.charAt(i) != word.charAt(i)) {
                        diff += 1;
                    }
                    if (diff > 1)
                        break;
                }
                if (diff <= 1) {
                    chkSet.add(word);
                    queue.add(new wordLadder(word, curStep + 1, chkSet));
                }
            }
        }

        return 0;
    }
}

class wordLadder {
    private String word;
    private int step;
    private Set<String> chkSet;
    public wordLadder(String word, int step, Set<String> chkSet) {
        this.word = word;
        this.step = step;
        this.chkSet = chkSet;
    }

    public String getWord() {
        return word;
    }

    public int getStep() {
        return step;
    }

    public Set<String> getChkSet() {
        return chkSet;
    }
}
