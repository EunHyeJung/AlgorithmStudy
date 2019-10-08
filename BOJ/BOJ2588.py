'''
https://www.acmicpc.net/problem/2588
2019.10.08 Tue
ehye826@gmail.com
'''

num1 = int(input())
num2 = int(input())

print(num1 * int(num2 % 10))
print(num1 * int(num2/10%10) )
print(num1 * int(num2/100) )
print(num1 * num2)
