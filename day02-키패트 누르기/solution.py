map = {}
leftHand = [3,0]
rightHand = [3,2]

def calFastestHand(x, y, hand):
    if y == 0:
       return "L"
    elif y == 2:
        return "R"
    else:
        leftValue = abs(leftHand[0] - x) + abs(leftHand[1] - y)
        rightValue = abs(rightHand[0] - x) + abs(rightHand[1] - y)
        
        if rightValue == leftValue:
            return hand
        elif rightValue > leftValue:
            return "L"
        else:
            return "R"
       
def solution(numbers, hand):
    answer = ''
    
    # keypad 위치 초기화
    map[0] = [3,1]
    for i in range(0, 9):
        x = int(i/3)
        y = int(i%3)
        map[i+1] = [x,y]
        
    # 손 초기화
    if hand == "right":
        hand = "R"
    else:
        hand = "L"
    
    # numbers 하나씩 누르기
    for i in numbers:
        x = map[i][0]
        y = map[i][1]
        
        curHand = calFastestHand(x, y, hand)
        
        answer += curHand
        
        if curHand == "R":
            rightHand[0] = x
            rightHand[1] = y
        else :
            leftHand[0] = x
            leftHand[1] = y
      
    return answer