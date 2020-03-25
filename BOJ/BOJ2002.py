'''
    @date : 2020-03-25
    @source : https://www.acmicpc.net/problem/2002
    @email : ehye826@gmail.com
'''
from sys import stdin

n = int(stdin.readline().strip())
entering_car, cnt = [], 0

for i in range(n):
    entering_car.append(stdin.readline().strip())
 
 
for i in range(n):
    exiting_car = stdin.readline().strip()
    if entering_car[0] == exiting_car.strip() :
        del entering_car[0]
        continue
    cnt += 1

    entering_car.remove(exiting_car)


print(cnt)
    
    
    
