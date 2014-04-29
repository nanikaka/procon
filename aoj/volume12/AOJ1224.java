package volume12;

import java.util.Scanner;

//Starship Hakodate-maru
public class AOJ1224 {

	void run(){
		int[] f1 = new int[54];
		for(int i=0;i<54;i++)f1[i]=i*i*i;
		int[] f2 = new int[96];
		for(int i=0;i<96;i++)f2[i]=i*(i+1)*(i+2)/6;
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int max = 0;
			for(int i=0;i<54;i++)for(int j=0;j<96;j++)if(f1[i]+f2[j]<=n)max=Math.max(max, f1[i]+f2[j]);
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1224().run();
	}
}
