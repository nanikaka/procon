package volume01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Packet Transportation
public class AOJ0144 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] f = new boolean[n+1][n+1];
		for(int i=0;i<n;i++){
			int b = sc.nextInt();
			int k = sc.nextInt();
			for(int j=0;j<k;j++){
				f[b][sc.nextInt()] = true;
			}
		}
		int p = sc.nextInt();
		while(p--!=0){
			int s = sc.nextInt();
			int t = sc.nextInt();
			int ttl = sc.nextInt();
			boolean[] u = new boolean[n+1];
			u[s] = true;
			int step = 1;
			List<Integer> l = new ArrayList<Integer>();
			l.add(s);
			String ans = "NA";
			while(!l.isEmpty()&&step<=ttl){
				List<Integer> next = new ArrayList<Integer>();
				for(int a:l){
					if(a==t){
						ans = step+"";
						next.clear();
						break;
					}
					for(int i=1;i<=n;i++){
						if(f[a][i]&&!u[i]){
							u[i] = true;
							next.add(i);
						}
					}
				}
				l = next;
				step++;
			}
			System.out.println(ans);
		}
	}
}
