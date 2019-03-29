# https://www.acmicpc.net/problem/2108

import sys

n = int(sys.stdin.readline())

nums = []
numCnt = {}
maxCnt = 0
for _ in range(0,n):
    num = int(sys.stdin.readline())
    nums.append(num)
    numCnt[num] = ((numCnt.get(num) + 1) if num in numCnt else 1)
    maxCnt = max(numCnt.get(num), maxCnt)
    

modeF = sys.maxsize
modeS = sys.maxsize

for num in numCnt.keys():
    if numCnt.get(num) == maxCnt:
        if modeF > num:
            modeS = modeF
            modeF = num
        elif modeS > num:
            modeS = num
        
print("%.0f" %(sum(nums)/n)) #산술평균
nums.sort()
print(nums[int(n/2)]) # 중앙값
print(modeS if modeS != sys.maxsize else modeF) #최빈값
print(nums[n-1]-nums[0]) #범위
