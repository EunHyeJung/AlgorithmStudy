import sys

@source https://www.acmicpc.net/source/10942457
n = int(input())
for i in range(n):
    inputs = list(map(int, input().split()))
    inputs.sort(reverse = True)
    print(inputs[2]);
