import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static int N;
	public static boolean[][] arr;
	public static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cnt = 0;

			// 첫번째 행 모든 열에 첫번째 말을 다 놓아보면서 시작
			for (int j = 0; j < N; j++) {
				// 모든 곳에 첫번째 말 놓으면서 경우의 수 시작
				dfs(0, j, new boolean[N][N]);
			}

			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}

	public static void dfs(int idx, int c, boolean[][] tempArr) {
		// N번말까지 놓았으면 !
		if (idx == N-1) {
			cnt++;
			return;
		}

		// 현재 가능한 곳 배열에서 표시
		// 같은 행, 열 안됨
		for (int i = 0; i < N; i++) {
			tempArr[idx][i] = true;
		}
		for (int i = 0; i < N; i++) {
			tempArr[i][c] = true;
		}
		// 대각선 안됨
		// 상우
		checkDia(idx, c, -1, 1, tempArr);
		// 하우
		checkDia(idx, c, 1, 1, tempArr);
		// 하좌
		checkDia(idx, c, 1, -1, tempArr);
		// 상좌
		checkDia(idx, c, -1, -1, tempArr);

//		System.out.println(Arrays.deepToString(tempArr));
		
		// 다음 행 중 갈 수 있는 곳에 다음 말 놓아보기
		for (int j = 0; j < N; j++) {
			if (!tempArr[idx+1][j]) {
				// dfs 진행
				boolean[][] newArr = copyArray(tempArr);
				dfs(idx+1, j, newArr);
			}
		}
	}

	public static void checkDia(int currR, int currC, int dr, int dc, boolean[][] tempArr) {
		int nr = currR + dr;
		int nc = currC + dc;

		// 배열 범위 벗어나면
		if (nr < 0 || nr >= N || nc < 0 || nc >= N)
			return;

		tempArr[nr][nc] = true;
		checkDia(nr, nc, dr, dc, tempArr);
	}

	public static boolean[][] copyArray(boolean[][] original) {
		boolean[][] copy = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = original[i][j];
			}
		}
		return copy;
	}
}