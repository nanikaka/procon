package volume22;

import java.util.Arrays;
import java.util.Scanner;

//Ennichi
public class AOJ2232 {

	int h, w, N;
	
	boolean f(char[][] a){
		boolean con = true;
		boolean[][] del = new boolean[h][w];
		while(con){
			con = false;
			for(int j=0;j<w;j++)for(int i=h-1;i>0;i--)if(a[i][j]=='.'){
				for(int k=i-1;k>=0;k--)if(a[k][j]!='.'){
					a[i][j] = a[k][j]; a[k][j] = '.'; break;
				}
			}
			for(int j=0;j<w;j++)if(a[h-1][j]!='.')con = true;
			if(!con)return true;
			con = false;
			for(boolean[]v:del)Arrays.fill(v, false);
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				if(a[i][j]=='.')continue;
				int L = 0;
				while(j+L<w&&a[i][j+L]==a[i][j])L++;
				if(N<=L)for(int k=j;k<j+L;k++)del[i][k] = true;
				L = 0;
				while(i+L<h&&a[i+L][j]==a[i][j])L++;
				if(N<=L)for(int k=i;k<i+L;k++)del[k][j] = true;
			}
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)if(del[i][j]){
				a[i][j] = '.'; con = true;
			}
		}
		return false;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt(); w = sc.nextInt(); N = sc.nextInt();
		char[][] m = new char[h][], t = new char[h][w];
		for(int i=0;i<h;i++)m[i]=sc.next().toCharArray();
		boolean ok = false;
		for(int i=0;i<h&&!ok;i++)for(int j=0;j<w-1&&!ok;j++){
			if(m[i][j]!=m[i][j+1]){
				for(int y=0;y<h;y++)for(int x=0;x<w;x++)t[y][x]=m[y][x];
				char x = t[i][j];
				t[i][j] = t[i][j+1]; t[i][j+1] = x;
				ok = f(t);
			}
		}
		System.out.println(ok?"YES":"NO");
	}
	
	public static void main(String[] args) {
		new AOJ2232().run();
	}
}
