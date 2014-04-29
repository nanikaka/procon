package volume10;

import java.util.Scanner;

//Vampirish Night
public class AOJ1019 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int k = sc.nextInt();
			if((n|k)==0)break;
			int[] s = new int[k];
			for(int i=0;i<k;i++)s[i]=sc.nextInt();
			boolean f = true;
			for(int i=0;i<n;i++){
				for(int j=0;j<k;j++){
					int x = sc.nextInt();
					if(s[j]<x)f = false;
					s[j]-=x;
				}
			}
			System.out.println(f?"Yes":"No");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1019().run();
	}
}
