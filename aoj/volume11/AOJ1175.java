package volume11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//And Then. How Many Are There?
public class AOJ1175 {

	int n;
	int[][] c;
	int[] col;

	boolean f(int i, int j, int x){
		if(col[i]!=col[j])return false;
		for(int k=0;k<i;k++){
			if((x&(1<<k))==0)continue;
			if(Math.hypot(c[i][0]-c[k][0], c[i][1]-c[k][1]) < c[i][2]+c[k][2])return false;
		}
		for(int k=0;k<j;k++){
			if((x&(1<<k))==0)continue;
			if(Math.hypot(c[j][0]-c[k][0], c[j][1]-c[k][1]) < c[j][2]+c[k][2])return false;
		}
		return true;
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0)break;
			c = new int[n][3];
			col = new int[n];
			for(int i=0;i<n;i++){
				for(int j=0;j<3;j++){
					c[i][j]=sc.nextInt();
				}
				col[i] = sc.nextInt();
			}
			List<Integer> l = new ArrayList<Integer>();
			l.add((1<<n)-1);
			boolean[] u = new boolean[1<<n];
			u[(1<<n)-1] = true;
			int step = 0;
			while(!l.isEmpty()){
				List<Integer> next = new ArrayList<Integer>();
				for(int s:l){
					int i = 0;
					while(i<n){
						if((s&(1<<i))>0){
							int j = i+1;
							while(j<n){
								if((s&(1<<j))>0){
									int x = s - (1<<i) - (1<<j);
									if(!u[x] && f(i, j, s)){
										next.add(x);
										u[x] = true;
									}
								}
								j++;
							}
						}
						i++;
					}
				}
				l = next;
				step++;
			}
			System.out.println((step-1)*2);
		}
	}

	public static void main(String[] args) {
		new AOJ1175().run();
	}
}
