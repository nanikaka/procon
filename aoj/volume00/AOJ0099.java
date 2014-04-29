package volume0;

import java.util.Arrays;
import java.util.Scanner;

//Surf Smelt Fishing Contest II
public class AOJ0099 {

	int[] num, id;
	
	void update(int i){
		if(i <= 0)return;
		int L = 2*i, R = 2*i+1;
		if(num[L]==num[R]){
			num[i] = num[L]; id[i] = Math.min(id[L], id[R]);
		}
		else if(num[L] < num[R]){
			num[i] = num[R]; id[i] = id[R];
		}
		else{
			num[i] = num[L]; id[i] = id[L];
		}
		update(i>>1);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), Q = sc.nextInt();
		int N = 1;
		while(N < n)N*=2;
		num = new int[2*N+1];
		id = new int[2*N+1];
		Arrays.fill(num, -1);
		for(int i=0;i<n;i++){
			id[N+i] = i+1;
			num[N+i] = 0;
			update((N+i)>>1);
		}
		while(Q--!=0){
			int a = sc.nextInt()-1, v = sc.nextInt();
			num[N+a]+=v;
			update((N+a)>>1);
			System.out.println(id[1]+" "+num[1]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0099().run();
	}
	
}
