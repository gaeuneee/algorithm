import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int cnt = 0;
	public static int[][] arr;
	public static Queue<int[]> q;
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
		bfs(new int[] {0, 0, 1});
		
		System.out.println(cnt);
		
		sc.close();
	}
	
	public static void bfs(int[] start) {
		q.add(start);
		
		// 상 하 좌 우 
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			// 도착하면 끝
			if (curr[0] == arr.length-1 && curr[1] == arr[curr[0]].length-1) {
				cnt = curr[2];
				break;
			}
			
			for (int i=0; i<4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
			
				if (nr<0 || nr>=arr.length || nc<0 || nc>=arr[nr].length)
					continue;
				
				if (arr[nr][nc] == 0) 
					continue;
				
				arr[nr][nc] = 0; // 방문 처리 
				q.add(new int[] {nr, nc, curr[2]+1 });	// 거리 정보 저장	
			}
		}
	}
}
