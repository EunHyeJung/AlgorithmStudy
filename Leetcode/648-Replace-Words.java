/*
* @source https://leetcode.com/problems/replace-words/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.30
*/
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Map<Character, List<String>> wordDictionary = new HashMap<>();
        for (String word : dictionary) {
            char stCh = word.charAt(0);
            List<String> wordList = wordDictionary.getOrDefault(stCh, new ArrayList<>());
            wordList.add(word);
            Collections.sort(wordList);
            wordDictionary.put(stCh, wordList);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            char stCh = word.charAt(0);
            List<String> wordList = wordDictionary.getOrDefault(stCh, new ArrayList<>());
            boolean isFind = false;
            
            for (String candidateWord : wordList) {
                if (word.startsWith(candidateWord)) {
                    sb.append(candidateWord);
                    isFind = true;
                    break;
                }
            }
            if (!isFind)
                sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
