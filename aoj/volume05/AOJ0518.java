package volume05;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//The Oldest Site
public class AOJ0518 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int M = 30000;
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			Set<Integer> set = new HashSet<Integer>();
			int[][] p = new int[n][2];
			for(int i=0;i<n;i++){
				for(int j=0;j<2;j++)p[i][j]=sc.nextInt()+10000;
				set.add(p[i][1]*M+p[i][0]);
			}
			int max = 0;
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					int dx = p[j][0]-p[i][0];
					int dy = p[j][1]-p[i][1];
					if(set.contains((p[i][1]+dx)*M+p[i][0]-dy)&&set.contains((p[j][1]+dx)*M+p[j][0]-dy)||
							set.contains((p[i][1]-dx)*M+p[i][0]+dy)&&set.contains((p[j][1]-dx)*M+p[j][0]+dy)){
						max = Math.max(max, dx*dx+dy*dy);
					}
				}
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new AOJ0518().run();
	}
}
