package volume12;

import java.util.Scanner;

//Cubist Artwork
public class AOJ1295 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), d = sc.nextInt();
			if((n|d)==0)break;
			int[] h = new int[21];
			int res = 0;
			while(n--!=0){
				int x = sc.nextInt();
				res+=x; h[x]++;
			}
			while(d--!=0){
				int x = sc.nextInt();
				if(h[x]>0)h[x]--;
				else res+=x;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1295().run();
	}
}
