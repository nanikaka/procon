package volume20;

import java.util.Scanner;

//Moduic Squares
public class AOJ2058 {

	int[][] a;
	int M, res;
	boolean[] u;
	
	void f(int k, int m){
		if(k==3){
			dfs(1, 0, m); return;
		}
		if(a[0][k]>0)f(k+1, (m+a[0][k])%M);
		else for(int j=1;j<=10;j++){
			if(!u[j]){
				u[j] = true;
				a[0][k] = j;
				f(k+1, (m+j)%M);
				u[j] = false;
				a[0][k] = 0;
			}
		}
	}
	
	void dfs(int i, int j, int m){
		if(i==3){
			res++; return;
		}
		if(a[i][j]>0){
			boolean f = true;
			if(j==2){
				if((a[i][0]+a[i][1]+a[i][2])%M!=m)f = false;
			}
			if(i==2){
				if((a[0][j]+a[1][j]+a[2][j])%M!=m)f = false;
			}
			if(i==2&&j==0){
				if((a[2][0]+a[1][1]+a[0][2])%M!=m)f = false;
			}
			if(i==2&&j==2){
				if((a[0][0]+a[1][1]+a[2][2])%M!=m)f = false;
			}
			if(f)dfs(i+(j+1)/3, (j+1)%3, m);
		}
		else{
			for(int k=1;k<=10;k++){
				if(!u[k]){
					u[k] = true;
					a[i][j] = k;
					boolean f = true;
					if(j==2){
						if((a[i][0]+a[i][1]+a[i][2])%M!=m)f = false;
					}
					if(i==2){
						if((a[0][j]+a[1][j]+a[2][j])%M!=m)f = false;
					}
					if(i==2&&j==0){
						if((a[2][0]+a[1][1]+a[0][2])%M!=m)f = false;
					}
					if(i==2&&j==2){
						if((a[0][0]+a[1][1]+a[2][2])%M!=m)f = false;
					}
					if(f)dfs(i+(j+1)/3, (j+1)%3, m);
					u[k] = false;
					a[i][j] = 0;
				}
			}
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			a = new int[3][3];
			for(int i=0;i<3;i++)for(int j=0;j<3;j++)a[i][j]=sc.nextInt();
			M = sc.nextInt();
			if(M<0)break;
			res = 0;
			u = new boolean[11];
			for(int i=0;i<3;i++)for(int j=0;j<3;j++)u[a[i][j]] = true;
			u[M] = true;
			if(M>0)f(0, 0);
			else for(int k=1;k<=10;k++){
				if(!u[k]){
					u[k] = true; M = k; f(0, 0); u[k] = false;
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2058().run();
	}
}
