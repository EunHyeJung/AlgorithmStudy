/*
* @source https://leetcode.com/problems/distribute-candies/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.04.28
*/
class Solution {
    public int distributeCandies(int[] candyType) {
        int limit = candyType.length / 2;
        Set<Integer> set =  new HashSet<Integer>();
        for (int candy : candyType) {
            set.add(candy);
            if (set.size() == limit)
                return limit;
        }
        return set.size();
    }
}
