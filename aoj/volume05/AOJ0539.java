package volume05;

import java.util.Arrays;
import java.util.Scanner;

//Pizza
public class AOJ0539 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int d = sc.nextInt();
			if(d==0)break;
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] p = new int[n];
			for(int i=1;i<n;i++)p[i]=sc.nextInt();
			Arrays.sort(p);
			int[] dest = new int[m];
			for(int i=0;i<m;i++)dest[i]=sc.nextInt();
			Arrays.sort(dest);
			int s = 0;
			int pos = 0;
			for(int i=0;i<m;i++){
				int min = Math.abs(p[pos%n]-dest[i]);
				if(min>d/2)min=d-dest[i]+p[pos%n];
				while(true){
					int v = Math.abs(p[(pos+1)%n]-dest[i]);
					if(v>d/2)v=d-dest[i]+p[(pos+1)%n];
					if(min<=v)break;
					min = v;
					pos++;
				}
				s+=min;
			}
			System.out.println(s);
		}
	}
}
