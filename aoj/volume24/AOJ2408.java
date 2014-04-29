package volume24;

import java.util.Scanner;

//Social
public class AOJ2408 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int[] b = new int[n+1];
		for(int i=0;i<k;i++){
			int m = sc.nextInt();
			while(m--!=0)b[sc.nextInt()]=i;
		}
		boolean[] bad = new boolean[n+1];
		int r = sc.nextInt();
		while(r--!=0){
			int p = sc.nextInt(), q = sc.nextInt();
			if(b[p]==b[q])bad[p]=bad[q]=true;
		}
		int res = 0;
		for(boolean v:bad)if(v)res++;
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2408().run();
	}
}
