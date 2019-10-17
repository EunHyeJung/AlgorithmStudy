'''
  @source : https://www.acmicpc.net/problem/4949
  @email : ehye826@gmail.com
  @date : 2019-10-17
'''

while True:
    sentence = input()
    if sentence == '.':
        break
    container = list()
    
    cur = ''
    isBalanced = True
    for ch in sentence:
        if ch == '(' or ch == '[':
            container.append(ch)
        elif ch == ')':
            if len(container) == 0:
                isBalanced = False
                break
            paren = container.pop()
            if paren != '(':
                isBalanced = False
                break
        elif ch == ']':
            if len(container) == 0:
                isBalanced = False
                break
            paren = container.pop()
            if paren != '[':
                isBalanced = False
                break
    
    if len(container) > 0:
        isBalanced = False
            
    print("yes" if isBalanced else "no")   
