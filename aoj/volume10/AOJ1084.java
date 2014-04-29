package volume10;

import java.util.Scanner;

//K Cards
public class AOJ1084 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), k = Math.min(n, sc.nextInt());
			if((n|k)==0)break;
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int max = 1, CK = 1;
			for(int i=0;i<k;i++)CK*=a[i];
			max = CK;
			for(int i=k;i<n;i++){
				CK/=a[i-k]; CK*=a[i]; max = Math.max(max, CK);
			}
			int m = 1;
			for(int i=0;i<n;i++)for(int j=i+1;j<n;j++){
				if(a[i]==a[j])continue;
				int t = a[i];
				a[i] = a[j]; a[j] = t;
				int ck = 1;
				for(int x=0;x<k;x++)ck*=a[x];
				m = Math.max(m, ck);
				for(int x=k;x<n;x++){
					ck/=a[x-k]; ck*=a[x]; m = Math.max(m, ck);
				}
				a[j] = a[i]; a[i] = t;
			}
			System.out.println((m-max)<0?"NO GAME":(m-max));
		}
	}
	
	public static void main(String[] args) {
		new AOJ1084().run();
	}
}
