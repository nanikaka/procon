package volume0;

import java.util.Scanner;

//Ball
public class AOJ0033 {

	public static int[] b;
	public static int[] f;
	public static int[] s;
	public static boolean ok;

	public static boolean check(){
		s[0] = s[1] = 0;
		for(int i=0;i<10;i++){
			if(s[f[i]]>=b[i])return false;
			s[f[i]] = b[i];
		}
		return true;
	}

	public static void dfs(int k){
		if(k==10){
			ok |= check();
		}
		else{
			f[k] = 0;
			dfs(k+1);
			f[k] = 1;
			dfs(k+1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n--!=0){
			b = new int[10];
			for(int i=0;i<10;i++)b[i]=sc.nextInt();
			f = new int[10];
			s = new int[2];
			ok = false;
			dfs(0);
			System.out.println(ok?"YES":"NO");
		}
	}
}
