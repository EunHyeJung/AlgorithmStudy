/*
* @source https://leetcode.com/problems/group-anagrams/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.01.16
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for(String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String sortedStr = new String(tmp);
            List<String> strList = strMap.getOrDefault(sortedStr, new ArrayList<>());
            strList.add(str);
            strMap.put(sortedStr, strList);
        }


        List<List<String>> res = new ArrayList<>();
        for(String str : strMap.keySet()) {
            res.add(strMap.get(str));
        }
        return res;
    }
}
