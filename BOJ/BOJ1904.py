'''
    @date : 2020-04-11
    @source : https://www.acmicpc.net/problem/1904
    @email : ehye826@gmail.com
'''

n = int(input())

if n == 1 or n == 2:
    print(n)
else:
    d = [0, 1, 2]
    
    for i in range(3, n+1):
        d.append((d[i - 2] + d[i - 1]) % 15746);
    print(d[n])
    
