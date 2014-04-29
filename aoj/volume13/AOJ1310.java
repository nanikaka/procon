package volume13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Find the Multiples
public class AOJ1310 {

	Map<Integer, Integer> cnt;
	void inc(int m){
		if(cnt.containsKey(m))cnt.put(m, cnt.get(m)+1);
		else cnt.put(m, 1);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), S = sc.nextInt(), W = sc.nextInt(), Q = sc.nextInt();
			if((n|S|W|Q)==0)break;
			int[] a = new int[n];
			int g = S;
			for(int i=0;i<n;i++){
				a[i] = (g/7) % 10;
				if((g&1) == 0)g>>=1;
				else g = (g>>1) ^ W;
			}
			int res = 0;
			if(Q==2){
				int e = 0;
				for(int i=n-1;i>=0;i--){
					if((a[i]&1)==0)e++;
					if(a[i]!=0)res+=e;
				}
			}
			else if(Q==5){
				int f = 0;
				for(int i=n-1;i>=0;i--){
					if(a[i]==0||a[i]==5)f++;
					if(a[i]!=0)res+=f;
				}
			}
			else{
				cnt = new HashMap<Integer, Integer>();
				inc(0);
				int ten = 1, m = a[n-1]%Q;
				inc(m);
				if(m==0 && a[n-1]!=0)res++;
				for(int i=n-2;i>=0;i--){
					ten = (ten*10)%Q;
					m = (a[i]*ten+m)%Q;
					if(a[i]!=0 && cnt.containsKey(m))res+=cnt.get(m);
					inc(m);
				}
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		new AOJ1310().run();
	}
}
