# https://www.acmicpc.net/problem/4344

n = int(input())

for _ in range(0,n):
    info = [int(i) for i in input().split()]
    avg = sum(info[1:])/info[0]
    cnt = 0
    safe = [ score for score in info[1:] if score > avg ]
    res = len(safe) * 100 / info[0]
    
    print("%.3f%%" %res)
