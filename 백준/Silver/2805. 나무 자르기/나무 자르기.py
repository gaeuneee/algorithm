"""
1. 아이디어
완전 탐색 해보자. 
-> sort, 
-> for 가장 큰 키-1,2,3.. 마다 : 리스트값이 그것보다 크면: 차를 더하기.
nlogn + m*n .. --> 시간초과!

이분탐색 해보자.
-> sort,
-> 가장 큰키/0 사이에서 자를 값 찾기.
nlogn + logn

2. 시간복잡도
nlogn + logn
"""

import sys
input = sys.stdin.readline

n, m = map(int, input().split())

trees = list(map(int, input().split()))

st, en = 0, max(trees)

def getRes(mid):
    res = 0
    for tree in trees:
        if tree > mid:
            res += (tree-mid)
    
    return res

while st <= en:
    mid = (st + en) // 2
    
    res = getRes(mid)
    
    if res >= m: # "총 잘린 길이가" 타겟보다 클 때 == "벌목 높이가" 작을 때
        current_res = mid
        st = (mid + 1)
    else:
        en = (mid - 1)

print(current_res)

