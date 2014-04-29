package volume0;

import java.util.Scanner;

//Joseph's Potato
public class AOJ0085 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			int k = n-1;
			int r = n;
			boolean[] f = new boolean[n];
			while(r>1){
				int c = 0;
				while(c<m){
					k=(k+1)%n;
					if(!f[k])c++;
				}
				f[k]=true;
				r--;
			}
			for(int i=0;i<n;i++)if(!f[i])System.out.println(i+1);
		}
	}
}
