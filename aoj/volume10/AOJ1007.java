package volume10;

import java.util.Scanner;

//JPEG Compression
public class AOJ1007 {

	public static boolean c(int i, int j, int n){
		return 0<=i&&i<n&&0<=j&&j<n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Case = 1;
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[][] a = new int[n][n];
			//mode: m
			//0: a right forward
			//1: down diagonal
			//2: down -> 4
			//3: right
			//4: up diagonal
			//5: right ->1
			//6: down -> 1
			//7: halt
			int m = 0;
			int s = 1;
			int i = 0;
			int j = 0;
			a[i][j] = s++;
			while(m!=7){
				switch(m){
				case 0:
					if(c(i,j+1,n)){
						a[i][j+1]=s++;
						j++;
						m=1;
					}
					else m=7;
					break;
				case 1:
					if(c(i+1,j-1,n)){
						a[++i][--j]=s++;
					}
					else{
						m=2;
					}
					break;
				case 2:
					if(c(i+1,j,n)){
						a[++i][j]=s++;
						m=4;
					}
					else m=3;
					break;
				case 3:
					if(c(i,j+1,n)){
						a[i][++j]=s++;
						m=4;
					}
					else m=7;
					break;
				case 4:
					if(c(i-1,j+1,n)){
						a[--i][++j]=s++;
					}
					else m=5;
					break;
				case 5:
					if(c(i,j+1,n)){
						a[i][++j]=s++;
						m = 1;
					}
					else m = 6;
					break;
				case 6:
					if(c(i+1,j,n)){
						a[++i][j]=s++;
						m=1;
					}
					else m=7;
					break;
				default:break;
				}
			}
			System.out.println("Case " + Case++ + ":");
			for(int y=0;y<n;y++){
				for(int x=0;x<n;x++){
					System.out.printf("%3d", a[y][x]);
				}
				System.out.println();
			}
		}
	}
}
