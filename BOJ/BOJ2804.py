'''
    @date : 2020-03-15
    @source : https://www.acmicpc.net/problem/2804
    @email : ehye826@gmail.com
'''

input_str = input().split(' ')
word1, word2 = input_str[0], input_str[1]
n, m = len(word1), len(word2)

pos2 = -1
for pos1 in range(0, n):
    pos2 = word2.find(word1[pos1])
    if pos2 != -1:
        break
    
for i in range(0, m):
    for j in range(0, n):
        if i == pos2:
            print(word1)
            break
        elif j == pos1:
            print(word2[i], end ='')
        else:
            print('.', end='')
    if i != pos2:
        print()
