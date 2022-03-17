/*
* @source https://leetcode.com/problems/intersection-of-two-arrays-ii/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.17
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length, n2 = nums2.length;
        List<Integer> numList = new ArrayList<>();
        int idx1 = 0, idx2 = 0;

        while(idx1 < n1 && idx2 < n2) {
            if (nums1[idx1] == nums2[idx2]) {
                numList.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else { // nums1[idx1] > nums2[idx2]
                idx2++;
            }
        }

        return numList.stream().mapToInt(Integer::intValue).toArray();
    }

}
