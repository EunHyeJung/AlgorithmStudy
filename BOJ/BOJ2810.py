'''
 @source : https://www.acmicpc.net/problem/2810
 @email : ehye826@gmail.com
 @date : 2019.10.14
'''

n, info = int(input()), input()
i, cnt = 0, 0
isAllSingle = True
while i < n-1:
    if info[i] == 'L':
        if i == n-2:
            break
        i += 2
        isAllSingle = False
    else :
        i += 1
    cnt += 1

print(n if isAllSingle else (cnt+2))

