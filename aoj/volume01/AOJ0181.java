package volume01;

import java.util.Scanner;

//Persistence
public class AOJ0181 {

	static int[] w;
	static int n, m;
	
	static boolean f(int W){
		int need = 1;
		int s = 0;
		for(int i=0;i<n;i++){
			if(w[i]>W)return false;
			if(s+w[i]>W){
				need++;
				s = 0;
			}
			s+=w[i];
		}
		return need <= m;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			m = sc.nextInt();
			n = sc.nextInt();
			if((m|n)==0)break;
			w = new int[n];
			for(int i=0;i<n;i++)w[i]=sc.nextInt();
			int l = 1;
			int r = 1500000;
			while(r-l>1){
				int mid = (l+r)/2;
				if(f(mid))r = mid;
				else l = mid;
			}
			System.out.println(f(l)?l:r);
		}
	}
}
