'''
    date : 2020-03-11
    source : https://www.acmicpc.net/problem/17413
    email : ehye826@gmail.com
'''

input_str = input()

i, n = 0, len(input_str)
word, res = '',''
while i < n:
    if input_str[i] == '<':
        if word != '':
            res += word[::-1]
            word = ''
        while input_str[i] != '>':
            res += input_str[i]
            i += 1
        res += input_str[i]
    else :
        while i < n and (input_str[i].isalpha() == True or input_str[i].isnumeric()) :
            word += input_str[i]
            i += 1
        if word != '':
            res += word[::-1]
            word = ''
            continue
        elif input_str[i] == ' ':
            res += ' '
        i+=1
        
    

if word != '':
    res += word[::-1]

print(res)
