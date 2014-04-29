package volume21;

import java.util.Scanner;

//Luck Manipulator
public class AOJ2149 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), X = sc.nextInt();
			if((n|A|B|C|X)==0)break;
			int[] y = new int[n];
			for(int i=0;i<n;i++)y[i]=sc.nextInt();
			int f = 0, k = 0, x = X;
			while(f<=10000){
				if(y[k]==x)k++;
				if(k==n)break;
				x = (A*x+B)%C;
				f++;
			}
			System.out.println(k==n?f:-1);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2149().run();
	}
}
