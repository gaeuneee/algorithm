import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 사람 수
		int K = sc.nextInt();		// 제거되는 순서
		List<Integer> list = new ArrayList<>();
		boolean[] isPop = new boolean[N+1];
		
		int start = K;
		isPop[start] = true;
		list.add(start);
		// 0 1 (2) (3) 4 5 (6) (7)
		
		while(list.size() < N) {
			int cnt = 0;
			
			while(cnt != K) {
				
				start = ++start % N;
				if(start == 0) start = N;
				if(!isPop[start]) {
					cnt++;
				}
			}
			
			list.add(start);
			isPop[start] = true;
		}
		
		System.out.print("<");
		for(int i = 0; i <list.size(); i++) {
			if(i != list.size()-1)	System.out.print(list.get(i) + ", ");
			else System.out.print(list.get(i) + ">");
		}
	}

}
