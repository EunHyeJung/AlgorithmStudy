import sys


aCards = list(map(int, input().split()))
bCards = list(map(int, input().split()))

n = len(aCards);


aCnt = 0
bCnt = 0
for i in range(0, n):
    if(aCards[i] > bCards[i]) :
        aCnt += 1
    elif(aCards[i] < bCards[i]) :
        bCnt += 1

        
if(aCnt > bCnt):
    print("A");
elif(aCnt < bCnt):
    print("B");
else:
    print("D");
