package volume01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//Tsuruga Parking
public class AOJ0192 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int m = sc.nextInt();
			int n = sc.nextInt();
			if((m|n)==0)break;
			int[] t = new int[n+1];
			for(int i=1;i<=n;i++)t[i]=sc.nextInt();
			int[][] p = new int[m][2];
			List<Integer> ans = new ArrayList<Integer>();
			Queue<Integer> q = new LinkedList<Integer>();
			int r = 10;
			while(ans.size()<n){
				if(r%10==0&&1<=r/10&&r/10<=n)q.add(r/10);
				for(int i=0;i<m;i++)for(int j=0;j<2;j++)if(p[i][j]>0)t[p[i][j]]--;
				for(int i=0;i<m;i++){
					if(p[i][0]>0&&t[p[i][0]]<=0){
						ans.add(p[i][0]);
						p[i][0] = p[i][1];
						p[i][1] = 0;
						if(p[i][0]>0&&t[p[i][0]]<=0){
							ans.add(p[i][0]);
							p[i][0] = 0;
						}
					}
				}
				boolean f = true;
				while(!q.isEmpty()&&f){
					f = false;
					int dmin = Integer.MAX_VALUE;
					int umin = Integer.MAX_VALUE;
					int d = -1;
					int u = -1;
					for(int i=0;i<m;i++){
						if(p[i][0]==0){
							f = true;
							p[i][0] = q.poll();
							break;
						}
						else if(p[i][1]==0){
							if(t[p[i][0]]>=t[q.peek()]){
								if(t[p[i][0]]-t[q.peek()] < umin){
									umin = t[p[i][0]]-t[q.peek()];
									u = i;
								}
							}
							else{
								if(t[q.peek()]-t[p[i][0]] < dmin){
									dmin = t[q.peek()]-t[p[i][0]];
									d = i;
								}
							}
						}
					}
					if(f)continue;
					if(u>=0){
						p[u][1] = p[u][0];
						p[u][0] = q.poll();
						f = true;
					}
					else if(d>=0){
						p[d][1] = p[d][0];
						p[d][0] = q.poll();
						f = true;
					}
				}
				r++;
			}
			for(int i=0;i<n;i++){
				if(i>0)System.out.print(" ");
				System.out.print(ans.get(i));
			}
			System.out.println();
		}
	}
}
