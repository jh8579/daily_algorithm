from itertools import combinations

def is_prime(n: int) -> bool:
    if n < 2:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def solution(nums):
    answer = 0
    comb = list(combinations(nums, 3));
    
    for tuple_sum in comb:
        if is_prime(sum(tuple_sum)) == True:
            answer = answer + 1

    return answer