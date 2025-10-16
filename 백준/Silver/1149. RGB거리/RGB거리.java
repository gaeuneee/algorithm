import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] costs = new int[N][3];
		
		costs[0] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		
		for(int i = 1; i < N; i++) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			
			costs[i][0] = r + Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] = g + Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] = b + Math.min(costs[i-1][0], costs[i-1][1]);
		}

		System.out.println(Math.min(costs[N-1][0], Math.min(costs[N-1][1], costs[N-1][2])));
		
		sc.close();
	}
}
