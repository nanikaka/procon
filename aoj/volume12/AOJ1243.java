package volume12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Weather Forecast
public class AOJ1243 {

	int[][] cover = {
			{0,1,4,5},
			{1,2,5,6},
			{2,3,6,7},
			{4,5,8,9},
			{5,6,9,10},
			{6,7,10,11},
			{8,9,12,13},
			{9,10,13,14},
			{10,11,14,15}
	};
	int move[][] = {
			{0,1,2,3,6},
			{0,1,2,4,7},
			{0,1,2,5,8},
			{0,3,4,5,6},
			{1,3,4,5,7},
			{2,3,4,5,8},
			{0,3,6,7,8},
			{1,4,6,7,8},
			{2,5,6,7,8}
	};
	
	long trans(int[] a){
		String s = "";
		for(int x:a)s+=x;
		return Long.parseLong(s);
	}
	
	int n;
	boolean sun[][];
	Set<Long>[][] set;
	
	//x日に雲がposに居てよいか
	boolean ok(int x, int pos){
		for(int i=0;i<4;i++)if(sun[x][cover[pos][i]])return false;
		return true;
	}
	
	boolean get(int x, int pos, int[] a){
		if(x==n)return true;
		if(set[x][pos].contains(trans(a)))return false;
		if(!ok(x, pos)){
			set[x][pos].add(trans(a));return false;
		}
		for(int j=0;j<5;j++){
			int[] t = new int[16];
			for(int i=0;i<16;i++)t[i]=a[i]-1;
			int nx = move[pos][j];
			for(int i=0;i<4;i++)t[cover[nx][i]] = 6;
			boolean f = true;
			for(int i=0;i<16;i++)if(t[i]<0)f = false;
			if(!f)continue;
			if(get(x+1, nx, t))return true;
		}
		set[x][pos].add(trans(a));
		return false;
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			sun = new boolean[n][16];
			for(int i=0;i<n;i++)for(int j=0;j<16;j++)sun[i][j] = sc.nextInt()==1;
			set = new HashSet[n][9];
			for(int i=0;i<n;i++)for(int j=0;j<9;j++)set[i][j] = new HashSet<Long>();
			int[] a = new int[16];
			Arrays.fill(a, 5);
			if(!ok(0, 4)){
				System.out.println(0);continue;
			}
			for(int j=0;j<4;j++)a[cover[4][j]] = 6;
			System.out.println(get(0, 4, a)?1:0);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1243().run();
	}
}
