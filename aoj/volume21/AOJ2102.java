package volume21;

import java.util.Arrays;
import java.util.Scanner;

//Rummy
public class AOJ2102 {

	int[] a, c;
	int[][] as;
	char[] s;
	
	boolean dfs(int k){
		if(k==9){
			for(int i=0;i<3;i++)if(s[as[i][0]]!=s[as[i][1]]||s[as[i][1]]!=s[as[i][2]])return false;
			for(int i=0;i<3;i++){
				int[] t = new int[3];
				for(int j=0;j<3;j++)t[j]=a[as[i][j]];
				Arrays.sort(t);
				if(!(t[0]==t[1]&&t[1]==t[2]||t[0]+1==t[1]&&t[1]+1==t[2]))return false;
			}
			return true;
		}
		for(int i=0;i<3;i++){
			if(c[i]==3)continue;
			as[i][c[i]] = k;
			c[i]++;
			if(dfs(k+1))return true;
			c[i]--;
		}
		return false;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			a = new int[9]; s = new char[9]; c = new int[3];
			for(int i=0;i<9;i++)a[i]=sc.nextInt();
			for(int i=0;i<9;i++)s[i]=sc.next().charAt(0);
			as = new int[3][3];
			System.out.println(dfs(0)?1:0);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2102().run();
	}
}
