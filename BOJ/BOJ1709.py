```
 @source : https://www.acmicpc.net/problem/17609
 @email : ehye826@gmail.com
 @date : 2019-10-15
```

if __name__ == "__main__":
    
    num_of_cases = int(input())
    
    for i in range(0, num_of_cases):
        word = input()
        l, s, r, e = 0, 0, len(word)-1, len(word)-1
        cnt1, cnt2 = 0,0
        
        while True:
            if l < r:
                if word[l] == word[r]:
                    l += 1
                    r -= 1
                else:  
                    if l + 1 <= r and word[l+1] == word[r] and cnt1 == 0:
                        cnt1 += 1
                        l += 2
                        r -= 1
                    elif r - 1 >= l and word[l] == word[r-1] and cnt1 == 0:
                        cnt1 += 1
                        l += 1
                        r -= 2
                    else:
                        cnt1 = 2
                        l = r
        
            if s < e:
                if word[s] == word[e]:
                    s += 1
                    e -= 1
                else:
                    if e - 1 >= s and word[s] == word[e-1] and cnt2 == 0:
                        cnt2 += 1
                        s += 1
                        e -= 2
                    elif s + 1 <= e and word[s+1] == word[e] and cnt2 == 0:
                        cnt2 += 1
                        s += 2
                        e -= 1
                    else:
                        cnt2 = 2
                        s = e
                        
            if s >= e and l >= r:
                break
        
        print(min(cnt1, cnt2))
