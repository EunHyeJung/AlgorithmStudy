/*
* @source https://leetcode.com/problems/top-k-frequent-elements/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.20
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums) {
            int cnt = numMap.getOrDefault(num, 0);
            numMap.put(num, cnt + 1);
        }

        List<Integer> keyList = new ArrayList<>(numMap.keySet());
        Collections.sort(keyList, (o1, o2) -> ( numMap.get(o2).compareTo(numMap.get(o1))));
        int[] res = new int[k];
        for (int i = 0, n = keyList.size(); i < n; i++) {
            if (i == k)
                return res;
            res[i] = keyList.get(i);
            
        }
        return res;
    }
}
