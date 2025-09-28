"""
1. 아이디어
- 이중 for grid 만들기
- grid에서 G R 합치기
- DFS 4방향으로 움직이면서 자신과 같으면 계속 고, cnt += 1

2. 시간복잡도
- 이중 for 10000

3. 자료구조
grid = str[][]
chk = bool[][]

"""

import sys
sys.setrecursionlimit(10**6) 
input = sys.stdin.readline

def sol():
    n = int(input())
    
    cnt1 = 0
    cnt2 = 0

    grid = []
    chk = [[False] * n for _ in range(n)]
    for i in range(n):
        grid.append(list(input().strip()))

    for i in range(n):
        for j in range(n):
            if not chk[i][j]:
                dfs(n, grid, i, j, chk)
                cnt1 += 1

    grid2 = changeGrid(n, grid)
    chk = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if not chk[i][j]:
                dfs(n, grid2, i, j, chk)
                cnt2 += 1

    print(cnt1, cnt2)

    
    
def changeGrid(n, grid):
    for i in range(n):
        for j in range(n):
            if grid[i][j] == 'G':
                grid[i][j] = 'R'

    return grid


dy = [0,1,0,-1]
dx = [1,0,-1,0]
def dfs(n, grid, y, x, chk):
    chk[y][x] = True

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]

        if 0<=ny<n and 0<=nx<n:
            if grid[y][x] == grid[ny][nx]:
                if not chk[ny][nx]:
                    dfs(n, grid, ny, nx, chk)

    return 0

    

sol()