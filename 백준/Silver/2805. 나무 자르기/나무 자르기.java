import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i=0 ; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		// 이분탐색
		int start = 0;
		int end = arr[N-1];
		int tempRes = 0;
		
		// 가능할 때까지
		while(start <= end) {
			// 중간값으로 자르기 시도할 예정
			int mid = (start+end)/2;
			
			// 자른 값보다 큰 나무면 res에 누적합
			long res = 0;
			for (int i=0; i<N; i++) {
				if (arr[i] > mid)
					res += (arr[i]-mid);
			}
			
			// res가 최소로 잘라야하는 M보다 크면 일단 tempRes로 자른 위치 mid를 저장
			if (res >= M) {
				tempRes = mid;
				start = (mid + 1); // 더 높은 곳에서 자를 수 있도록 가장 낮은 지점을 +1
			}
			// M보다 작으면 자른 위치 mid를 지금보다 낮춰야 하므로
			else {
				end = (mid - 1); // 가장 높은 값인 end -1
			}
		}
		
		System.out.println(tempRes);
		
		sc.close();
	}
}
