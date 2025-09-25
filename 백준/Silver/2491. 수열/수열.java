import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int maxCnt = 1;
		int higherCnt = 1;
		int lowerCnt = 1;
		for (int i=1; i<N; i++) {
			if (arr[i] >= arr[i-1])
				higherCnt++;
			else
				higherCnt = 1;
			
			if (arr[i] <= arr[i-1])
				lowerCnt++;
			else
				lowerCnt = 1;
			
			maxCnt = Math.max(maxCnt, higherCnt);
			maxCnt = Math.max(maxCnt, lowerCnt);
		}
		
		System.out.println(maxCnt);
		
		sc.close();
	}
}
