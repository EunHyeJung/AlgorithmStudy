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
  
- - -  
   
### 최대공약수 (Greatest Common Divisor)     
  
* 두개의 수 A,B의 최대 공약수 G는 A와 B의 약수 중 가장 큰 정수  
* 최대공약수가 1인 두 수를 서로소(coprime)이라고 함.  
   
<b> 유클리드 호제법(Euclidean Algorithm) </b>   
  
a%b = r일때 `GCD(a,b) = GCD(b,r)` 이 성립      
r이 0일 경우 b가 최대공약수가 됨  
ex) GCD(24, 16) = GCD(16, 8) = GCD(8, 0) = 8  
  
    
### 최소공배수 (Leatest Common Multiple)  
   
* 두수의 공통된 배수 중에 가장 작은 정수  
* 최대 공약수를 이용하여 최소 공배수를 구할 수 있음  
  두 수 a,b의 최대 공약수를 g라고 할 때  
  최소 공배수 `LCM = g * (a/g) * (b/g)`   
     
- - -    
      
  
    

  
    
  
  

