# https://www.acmicpc.net/problem/5597

list = []

for _ in range(0,28):
    list.append(int(input()))

for i in range(1,31):
    if i not in list:
        print(i)
