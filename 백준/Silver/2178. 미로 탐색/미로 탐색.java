import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int cnt = 0;
	public static int[][] arr;
	public static Queue<Point> q;
	//좌표 저장용 클래스 
    static class Point {
        int r, c;
        int dist = 0;
 
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String line = sc.next();
			for (int j=0; j<M; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
		q = new ArrayDeque<>();
		Point start = new Point(0,0);
		start.dist = 1;
		bfs(start);
		
		System.out.println(cnt);
		
		sc.close();
	}
	
	public static void bfs(Point start) {
		q.add(start);
		arr[start.r][start.r] = 0;
		
		// 상 하 좌 우 
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		while (!q.isEmpty()) {
			Point curr = q.poll();
			
			// 도착하면 끝
			if (curr.r == arr.length-1 && curr.c == arr[curr.r].length-1) {
				cnt = curr.dist;
				break;
			}
			
			for (int i=0; i<4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr<0 || nr>=arr.length || nc<0 || nc>=arr[nr].length)
					continue;
				
				if (arr[nr][nc] == 0)
					continue;
				
				Point next = new Point(nr, nc);
				next.dist += (curr.dist + 1);
				q.add(next);
				arr[nr][nc] = 0;	
				
//				System.out.println(Arrays.deepToString(arr));
			}
		}
	}
}
