'''
    @date : 2020-03-20
    @source : https://www.acmicpc.net/problem/2870
    @email : ehye826@gmail.com
'''

n = int(input())
res = list()
for _ in range(n):
    word, num = input(), str()
    
    for ch in word:
        if ch.isnumeric():
            if num == '':
                num = ch
            else:
                num += ch
        elif num != '':
            while len(num) > 1 and num[0] == '0':
                num = num[1:]
                
            res.append(int(num))
            num = ''
    if num != '':
        while len(num) > 1 and num[0] == '0':
                num = num[1:]
        res.append(int(num))
 
print(*sorted(res), sep = '\n')
