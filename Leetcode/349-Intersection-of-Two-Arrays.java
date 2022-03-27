/*
* @source https://leetcode.com/problems/intersection-of-two-arrays/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.27
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersectionSet = new HashSet<>();
        int[] numCount = new int[1001];
        for (int i = 0, n = nums1.length; i < n; i++) {
            numCount[nums1[i]] += 1;
        }
        for (int i = 0, n = nums2.length; i < n; i++) {
            if (numCount[nums2[i]] > 0) {
                intersectionSet.add(nums2[i]);
                numCount[nums2[i]] -= 1;
            }
        }
        
        int[] res = new int[intersectionSet.size()];
        int idx = 0;
        for (int num : intersectionSet) {
            res[idx++] = num;
        }
        return res;
    }
}
