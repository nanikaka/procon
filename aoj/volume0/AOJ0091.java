package volume0;

import java.util.Scanner;

//Blur
public class AOJ0091 {

	int[][] dir = {{0,0},{-1,0}, {0,-1},{0,1},{1,0},{-1,-1},{-1,1},{1,-1},{1,1,},{-2,0},{0,-2},{0,2},{2,0}};
	int[] num = {0, 5, 9, 13};
	int[][] a, res;
	int L, V;

	boolean f(int i, int j, int k, int drop){
		if(V==0)return true;
		if(k==L)return false;
		if(!check(i, j))return false;
		if(drop<1)return f(i, j+1, k, 3);
		if(i==9)return false;
		if(j==9)return f(i+1, 1, k, 3);
		if(a[i][j]==0)return f(i, j+1, k, 3);
		if(e(i, j, drop)){
			for(int K=0;K<num[drop];K++)a[i+dir[K][0]][j+dir[K][1]]--;
			res[k][0] = j;
			res[k][1] = i;
			res[k][2] = drop;
			V-=num[drop];
			if(f(i, j, k+1, drop))return true;
			V+=num[drop];
			for(int K=0;K<num[drop];K++)a[i+dir[K][0]][j+dir[K][1]]++;
		}
		return f(i, j, k, drop-1);
	}
	
	boolean check(int i, int j){
		i-=2;
		if(j<3){
			i--; j=9;
		}
		else j-=3;
		while(0<=i && 0<=j){
			if(a[i][j]>0)return false;
			if(j==0){
				i--; j=9;
			}
			else j--;
		}
		return true;
		
	}
	
	boolean e(int i, int j, int drop){
		for(int k=0;k<num[drop];k++){
			int ni = i+dir[k][0], nj = j+dir[k][1];
			if(ni<0||9<ni||nj<0||9<nj||a[ni][nj]==0)return false;
		}
		return true;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		a = new int[10][10];
		L = sc.nextInt();
		V = 0;
		for(int i=0;i<10;i++)for(int j=0;j<10;j++){
			a[i][j]=sc.nextInt();
			V+=a[i][j];
		}
		res = new int[L][3];
		f(1, 1, 0, 3);
		for(int[]r:res)System.out.printf("%d %d %d\n", r[0], r[1], r[2]);
	}
	
	public static void main(String[] args) {
		new AOJ0091().run();
	}
}
