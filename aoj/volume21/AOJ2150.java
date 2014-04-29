package volume21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Matsuzaki Number
public class AOJ2150 {

	void run(){
		int N = 150000;
		Scanner sc = new Scanner(System.in);
		boolean[] p = new boolean[N];
		Arrays.fill(p, true);
		List<Integer> l = new ArrayList<Integer>();
		p[0]=p[1]=false;
		for(int i=2;i<N;i++){
			if(p[i]){
				l.add(i);
				for(int j=i+i;j<N;j+=i)p[j]=false;
			}
		}
		for(;;){
			int n = sc.nextInt(), P = sc.nextInt();
			if(n==-1&&P==-1)break;
			List<Integer> res = new ArrayList<Integer>();
			int k=0;
			while(l.get(k)<=n)k++;
			for(int i=k;i<k+P;i++)for(int j=i;j<k+P;j++)res.add(l.get(i)+l.get(j));
			Collections.sort(res);
			System.out.println(res.get(P-1));
		}
	}
	
	public static void main(String[] args) {
		new AOJ2150().run();
	}
}
