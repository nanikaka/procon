package volume11;

import java.util.Scanner;

//Get Many Persimmon Trees
public class AOJ1125 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int w = sc.nextInt();
			int h = sc.nextInt();
			boolean[][] p = new boolean[h][w];
			while(n--!=0){
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				p[y][x] = true;
			}
			int s = sc.nextInt();
			int t = sc.nextInt();
			int max = 0;
			for(int i=0;i+t<=h;i++)for(int j=0;j+s<=w;j++){
				int c = 0;
				for(int a=i;a<i+t;a++)for(int b=j;b<j+s;b++)c+=p[a][b]?1:0;
				max = Math.max(max, c);
			}
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1125().run();
	}
}
