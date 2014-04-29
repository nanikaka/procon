package volume12;

import java.util.Scanner;

//Leaky Cryptography
public class AOJ1250 {

	int[][] a;
	int[] cs, t;
	char[] key;
	
	boolean dfs(int k, int c){
		if(k==-1)return true;
		key[k] = '0';
		int x = c;
		for(int i=0;i<8;i++)x+=a[i][k];
		if(x%2==cs[k]){
			if(dfs(k-1, x/2))return true;
		}
		key[k] = '1';
		x = c;
		for(int i=0;i<8;i++)x+=(a[i][k]+1)%2;
		if(x%2==(cs[k]+1)%2){
			if(dfs(k-1, x/2))return true;
		}
		return false;
	}
	
	int[] make(String s){
		int[] r = new int[32];
		long x = Long.parseLong(s, 16);
		int i = 31;
		while(x>0){
			r[i--] = (int) (x%2);
			x>>=1;
		}
		return r;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			a = new int[8][32];
			for(int i=0;i<8;i++)a[i] = make(sc.next());
			cs = make(sc.next());
			key = new char[32];
			dfs(31, 0);
			long l = Long.parseLong(new String(key), 2);
			System.out.println(String.format("%h", l));
		}
	}
	
	public static void main(String[] args) {
		new AOJ1250().run();
	}
}
