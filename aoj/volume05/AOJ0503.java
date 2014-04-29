package volume05;

import java.util.Scanner;

//Cup
public class AOJ0503 {

	int[] last;
	int N, M;
	
	int f(int[] c, int from, int to){
		int res = 1;
		boolean con = true;
		while(!(c[0]==(1<<N)-1||c[2]==(1<<N)-1)&&res<=M){
			con = true;
			for(int f=0;f<3&&con;f++)for(int t=0;t<3&&con;t++){
				if(Math.abs(f-t)>1)continue;
				if(from==t&&to==f)continue;
				if(last[c[f]]<=last[c[t]])continue;
				c[t]+=1<<last[c[f]]; c[f]-=1<<last[c[f]];
				from = f; to = t;
				con = false;
			}
			res++;
		}
		return res;
	}
	
	void run(){
		last = new int[1<<15];
		for(int S=0;S<1<<15;S++){
			int k = 14;
			while(k>=0&&((S>>k)&1)==0)k--;
			last[S] = k;
		}
		Scanner sc = new Scanner(System.in);
		for(;;){
			N = sc.nextInt(); M = sc.nextInt();
			if((N|M)==0)break;
			int[] cup = new int[3];
			for(int i=0;i<3;i++){
				int k = sc.nextInt();
				while(k--!=0)cup[i]+=1<<(sc.nextInt()-1);
			}
			if(cup[0]==(1<<N)-1||cup[2]==(1<<N)-1){
				System.out.println(0); continue;
			}
			int res = M+1;
			for(int f=0;f<3;f++)for(int t=0;t<3;t++){
				if(Math.abs(f-t)>1)continue;
				if(last[cup[f]]<=last[cup[t]])continue;
				int[] c = new int[3];
				c[0] = cup[0]; c[1] = cup[1]; c[2] = cup[2];
				c[t]+=1<<last[c[f]]; c[f]-=1<<last[c[f]];
				res = Math.min(res, f(c, f, t));
			}
			System.out.println(M<res?"-1":res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0503().run();
	}
}
