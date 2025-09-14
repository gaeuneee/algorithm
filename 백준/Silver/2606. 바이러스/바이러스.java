import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int cnt = 0;
	public static List<Integer>[] list;
	public static Queue<Integer> q;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt(); 
		list = new List[N+1];
		for (int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		visited = new boolean[N+1];
		
		for (int i=0 ; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		q = new ArrayDeque<>();
		bfs(1);
		
		System.out.println(cnt);
		
		sc.close();
	}
	
	public static void bfs(int start) {
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();	
			
			for (int i=0; i<list[curr].size(); i++) {
				if (visited[list[curr].get(i)])
					continue;
				
				// 아직 방문전이라면 접근 가능 
				cnt++;
				q.add(list[curr].get(i));
				visited[list[curr].get(i)] = true;
			}
		}
	}
}