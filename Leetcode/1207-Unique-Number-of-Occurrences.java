/*
* @source https://leetcode.com/problems/same-tree/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.05.26
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i- 1]) {
                if (map.getOrDefault(cnt, -9999) != -9999)
                    return false;
                map.put(cnt, arr[i - 1]);
                cnt = 0;
            }
            cnt += 1;
        }

        return map.getOrDefault(cnt, -9999) == -9999;
    }
}
