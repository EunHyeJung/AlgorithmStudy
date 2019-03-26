# https://www.acmicpc.net/problem/11328

for _ in range(int(input())):
    a, b = input().split()
    print('Possible' if sorted(a) == sorted(b) else 'Impossible')
