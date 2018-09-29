- - -      
<i> Note </i>     
- - -     
     

### 2진수에서 비트가 1로 표기된 갯수를 얻는법
    
* <b> Integer.bitCount() </b>      
  
  java.lnag.Integer.bitCount()    
  [참고](https://www.tutorialspoint.com/java/lang/integer_bitcount.htm)   
  
* <b> while, bit 연산자를 이용해 구하기 </b>        
  
  ```java
  int countSetBits(int n) {
      int cnt = 0;
      while (n > 0) {
            count += (n & 1);
            n >>= 1;
      }
      return count;
  }
  ```      
  
    
  
  

