package volume24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Janken
public class AOJ2410 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] a = new char[N][N];
		for(int i=0;i<N;i++)a[i]=sc.next().toCharArray();
		int min = N+1, cand = 0;
		boolean[] win = new boolean[N];
		for(int S=1;S<1<<N;S++){
			int c = Integer.bitCount(S);
			if(min<=c)continue;
			Arrays.fill(win, false);
			for(int j=0;j<N;j++)if(((S>>j)&1)>0){
				for(int i=0;i<N;i++)win[i]|=a[j][i]!='x';
			}
			boolean ok = true;
			for(boolean v:win)ok&=v;
			if(ok){
				min = c; cand = S;
			}
		}
		List<Integer> use = new ArrayList<Integer>();
		for(int i=0;i<N;i++)if(((cand>>i)&1)>0)use.add(i);
		Random rand = new Random();
		for(int i=0;i<1000;i++){
			int me = use.get(rand.nextInt(use.size()));
			System.out.println(me+1);
			System.out.flush();
			sc.nextInt();
		}
	}
	
	public static void main(String[] args) {
		new AOJ2410().run();
	}
}
