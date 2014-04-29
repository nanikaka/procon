package volume10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Huge Family
public class AOJ1055 {

	int n, MOD = 10007;
	int[][] e, f;
	boolean[] v;
	
	int bfs(int s){
		v[s] = true;
		int max = -1, c = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty()){
			int p = q.poll();
			for(int i=0;i<2;i++){
				if(max<f[p][i]){
					max = f[p][i]; c = 1;
				}
				else if(max==f[p][i])c++;
				if(!v[e[p][i]]){
					v[e[p][i]] = true; q.add(e[p][i]);
				}
			}
		}
		return (c/2)%MOD;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			e = new int[n][2]; f = new int[n][2];
			for(int i=0;i<n;i++)for(int j=0;j<2;j++){
				e[i][j] = sc.nextInt(); f[i][j] = sc.nextInt();
			}
			v = new boolean[n];
			int res = 1;
			for(int i=0;i<n;i++)if(!v[i])res=(res*bfs(i))%MOD;
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1055().run();
	}
}
