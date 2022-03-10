/*
* @source https://leetcode.com/problems/fizz-buzz/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2022.03.10
*/
class Solution {
   public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
       boolean[] isDivisibleBy3 = new boolean[n + 1];
       boolean[] isDivisibleBy5 = new boolean[n + 1];
       for (int i = 3; i <= n; i+= 3) {
           isDivisibleBy3[i] = true;
       }
       for (int i = 5; i <= n; i+= 5) {
           isDivisibleBy5[i] = true;
       }
       
        for (int i = 1; i <= n; i++) {
            if (isDivisibleBy3[i] && isDivisibleBy5[i]) 
                res.add("FizzBuzz");
             else if (isDivisibleBy3[i]) 
                res.add("Fizz");
             else if (isDivisibleBy5[i]) 
                res.add("Buzz");
             else 
                 res.add(Integer.toString(i));
        }
        return res;
    }
}
