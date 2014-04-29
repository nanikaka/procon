package volume01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Nature of Prime Numbers
public class AOJ0142 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[] c = new int[(n-1)/2+1];
			int[] a = new int[n];
			int id = 0;
			Set<Integer> set = new HashSet<Integer>();
			for(int i=1;i<n;i++){
				int x = i*i%n;
				if(!set.contains(x)){
					set.add(x);
					a[id++] = x;
				}
			}
			for(int i=0;i<id;i++){
				for(int j=0;j<id;j++){
					if(i==j)continue;
					int sub = a[i]-a[j];
					if(sub<0)sub+=n;
					if(sub > (n-1)/2)sub = n-sub;
					c[sub]++;
				}
			}
			for(int i=1;i<=(n-1)/2;i++)System.out.println(c[i]);
		}
	}
}
