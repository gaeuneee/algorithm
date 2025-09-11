import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static List<int []> conditions;
	public static int[] resArr;
	public static int max;
	public static int N, X;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			int M = sc.nextInt();
			
			conditions = new ArrayList<>();
			for (int j=0; j<M; j++) {
				int i = sc.nextInt();
				int r = sc.nextInt();
				int s = sc.nextInt();
				
				conditions.add(new int[] {i, r, s});
			}
			
			int[] tempArr = new int[N+1];
			resArr = new int[N+1];
			max = -1;
			dfs(1, tempArr);
			System.out.print("#" + tc);
			
			if (max == -1)
				System.out.print(" " + max);
			else {
				for (int k=1; k<resArr.length; k++) {
					System.out.print(" " + resArr[k]);
				}
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	public static void dfs(int start, int[] arr) {
		// 종료 조건
		if (start > N) {
			// 조건에 다 부합하는지 검사 !!
			for (int[] condition : conditions) {
				int tempSum =0;
				for (int i=condition[0]; i<=condition[1]; i++) {
					tempSum += arr[i];
				}
				if (tempSum != condition[2]) {
					return;
				}
			}
			
//			System.out.println(Arrays.toString(arr));
			// 최대값이면 저장 
			int total = 0;
			for (int i : arr) {
				total += i;
			}
			
			if (total > max) {
				max = total;
				for (int i = 1; i <= N; i++) {
                    resArr[i] = arr[i];
                }
			}

			return;
		}
		
		// 반복 조건
		loop:
		for (int i=0; i<=X; i++) {
			arr[start] = i;
			
			for (int k=0; k<conditions.size(); k++) {
				// 끝 범위에 지금 추가한 곳이 포함되어 있을 때 
				if (conditions.get(k)[1] == start) { 
					// 합 조건이 맞지 않으면 이 i 는 후보에서 탈락 
					int tempSum =0;
					for (int q=conditions.get(k)[0]; q<=conditions.get(k)[1]; q++) {
						tempSum += arr[q];	
					}
					if (tempSum != conditions.get(k)[2])
						continue loop;
				}
				
				// 시작 범위에 지금 추가한 곳이 포함되어 있을 때도.. 
				if (conditions.get(k)[0] == start) {
					// 이미 합 조건을 시작에서부터 넘어버리면 i가 후보에서 탈락
					if (i > conditions.get(k)[2])
						continue loop;
				}
			}
			
			//모든 조건을 통과했으면 다음 숫자도 정해보기 
			dfs(start+1, arr);
		}
	}
}