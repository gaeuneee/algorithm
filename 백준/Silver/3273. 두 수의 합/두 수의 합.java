import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		
		Set<Integer> set = new HashSet<>();
		int cnt = 0;
		// 한개씩 보면서.. 
		for (int i=0; i<n; i++) {
			
			// 있으면 카운트 업 !! 
			if (set.contains(x-arr[i]))
				cnt++;
			
			// 한번 본 것들은 차곡차곡 담기
			set.add(arr[i]);
		}
		
		// 이러면 숫자 쌍 중 먼저 본 거 하나 + 나중에 나타난 거 하나 로 겹치지 않게 셀 수 있다 
		
		System.out.println(cnt);
		
		sc.close();
	}
}
