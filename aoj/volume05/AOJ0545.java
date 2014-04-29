package volume05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Party
public class AOJ0545 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0&&m==0)break;
			boolean[][] f = new boolean[n+1][n+1];
			while(m--!=0){
				int a = sc.nextInt();
				int b = sc.nextInt();
				f[a][b] = f[b][a] = true;
			}
			List<Integer> f1 = new ArrayList<Integer>();
			for(int i=2;i<=n;i++)if(f[1][i])f1.add(i);
			f1.add(1);
			boolean[] invite = new boolean[n+1];
			for(int k:f1){
				invite[k] = true;
				for(int i=1;i<=n;i++){
					if(f[k][i])
						invite[i] = true;
				}
			}
			int c = 0;
			for(int i=1;i<=n;i++)c+=invite[i]?1:0;
			System.out.println(--c);
		}
	}
}
