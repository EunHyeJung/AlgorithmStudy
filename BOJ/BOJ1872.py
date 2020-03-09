'''
    Date : 2020-03-09
    Source : https://www.acmicpc.net/problem/1972
    Email : ehye826@gmail.com
'''
import sys

while True:
    input_str = input()
    
    if input_str == '*':
        break
   
    n = len(input_str)
    if n <= 2:
        print(input_str, 'is surprising.')
        continue

    d, flag = 1, True
    for i in range(0, n-2):
        str_set = set([])
        for j in range(0, n-i-1):
            str_set.add((input_str[j] + input_str[j+d]))
            
        if len(str_set) != n-i-1:
            print(input_str, 'is NOT surprising.')
            flag = False
            break
        d += 1 
        
    if flag == True:
      print(input_str, 'is surprising.') 
