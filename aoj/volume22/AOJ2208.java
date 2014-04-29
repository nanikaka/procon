package volume22;

import java.util.Arrays;
import java.util.Scanner;

//The Melancholy of Thomas Right
public class AOJ2208 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int[] a = new int[n], b = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			for(int i=0;i<n;i++)b[i]=sc.nextInt();
			Arrays.sort(a);
			Arrays.sort(b);
			int t = 0, c = 0;
			while(t<n&&a[t]==0)t++;
			boolean f = true;
			for(int i=n-1;i>=0;i--){
				if(n-t!=b[i]){
					f = false; break;
				}
				c++;
				while(t<n&&a[t]<=c)t++;
			}
			System.out.println(f?"Yes":"No");
		}
	}
	
	public static void main(String[] args) {
		new AOJ2208().run();
	}
}
