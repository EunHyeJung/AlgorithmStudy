/*
* @source https://leetcode.com/problems/sort-characters-by-frequency/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.05
*/
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> chCntMap = new HashMap<>();

        for (int i = 0, n = s.length(); i < n; i++) {
            char ch = s.charAt(i);
            chCntMap.put(ch, chCntMap.getOrDefault(ch, 0) + 1);
        }
        List<Character> sortedList = chCntMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (char ch : sortedList) {
            sb.append(Character.toString(ch).repeat(chCntMap.get(ch)));
        }
        return sb.toString();
    }
}


