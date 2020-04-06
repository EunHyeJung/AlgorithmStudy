'''
    @date : 2020-04-06
    @source : https://www.acmicpc.net/problem/16194
    @email : ehye826@gmail.com
'''

n = int(input())
p, d = [int(i) for i in input().split(' ')], [99999 for i in range(n + 1)]


d[0], d[1] = 0, p[0]

for i in range(2, n + 1):
    for k in range(0, i):
        d[i] = min(d[i-(k + 1)] + p[k], d[i]) 
        
print(d[n])
        
