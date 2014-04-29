package volume05;

import java.util.Scanner;

//Sugoroku
public class AOJ0544 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			int[] a = new int[n+1];
			for(int i=1;i<=n;i++)a[i]=sc.nextInt();
			int[] d = new int[m];
			for(int i=0;i<m;i++)d[i]=sc.nextInt();
			int p = 1;
			for(int i=0;i<m;i++){
				p += d[i];
				if(p>=n){
					System.out.println(++i);break;
				}
				p += a[p];
				if(p<0)p = 0;
				if(p>=n){
					System.out.println(++i);break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ0544().run();
	}
}
