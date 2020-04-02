'''
    @date : 2020-04-03
    @source : https://www.acmicpc.net/problem/11571
    @email : ehye826@gmail.com
'''

num_of_cases = int(input())

def get_repeated_secetion(a, b):
    chk, i = dict(), 0
    rtn = ''
    while True:
        a *= 10
        if a in chk:
            idx = chk[a]
            rtn = rtn[:idx] + '(' + rtn[idx:] + ')'
            break
        
        chk[a] = i
        i += 1
        rtn += str(a//b)
        a %= b
    return rtn
        
        

for i in range(num_of_cases):
    input_data = input().split(' ')
    numerator = int(input_data[0]) 
    denominator = int(input_data[1]) 
    print('{0}.{1}'.format(int(numerator / denominator),get_repeated_secetion(numerator % denominator, denominator)))
