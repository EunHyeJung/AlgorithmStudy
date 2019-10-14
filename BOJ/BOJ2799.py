'''
https://www.acmicpc.net/problem/2799
ehye82@gmail.com
2019.10.14
'''

n, m = map(int, input().split())

res = [0,0,0,0,0]
inputs = []

for i in range(0, n* 5 + 1):
    inputs.append(input())

for i in range(0, n):
    for j in range(0, m):
        st_i = i * 5 + 1
        st_j = j * 5 + 1        
        cnt = 0
        
        for k in range(0,4):
            if inputs[st_i + k][st_j] != '*':
               break
            cnt += 1
                
        res[cnt] += 1    
           

print(" ".join(str(x) for x in res))
                    
      
