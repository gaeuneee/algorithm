import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int[][] arr;
	public static boolean[][] visited;
	public static Queue<Point> q;
	// 상 우 하 좌
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc =0; tc<10; tc++) {
			int T = sc.nextInt();
			
			arr = new int[16][16];
			Point start = new Point(0, 0);
			for (int i=0; i<16; i++) {
				String line = sc.next();
				for (int j=0; j<16; j++) {
					arr[i][j] = line.charAt(j) - '0';
					if (arr[i][j] == 2) {
						start.x = i;
						start.y = j;
					}
				}
			}
			q = new LinkedList<>();
			visited = new boolean[16][16];
			q.add(start);
			visited[start.x][start.y] = true;
			
			System.out.println("#" + T + " " + bfs(start));
		}
		
		sc.close();
	}
	
	public static int bfs(Point start) {
		
		while (!q.isEmpty()) {
			int currR = q.peek().x;
			int currC = q.peek().y; 
			q.poll();
			
			for (int i=0; i<4; i++) {
				int nr = currR + dr[i];
				int nc = currC + dc[i];
				// 배열 범위
				if (0>nr || nr>=arr.length || 0>nc || nc>=arr.length)
					continue;
				// 벽
				if (arr[nr][nc] == 1)
					continue;
				// 이미 방문
				if (visited[nr][nc])
					continue;
				
				// 방문지면 종료 !! 
				if (arr[nr][nc] == 3)
					return 1;
				else {
					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		
		return 0;
		
	}
}