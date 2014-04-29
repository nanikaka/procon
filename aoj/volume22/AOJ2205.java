package volume22;

import java.util.Scanner;

//Lottery Checker
public class AOJ2205 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int m = sc.nextInt();
			char[][] s = new char[n][8];
			int[] p = new int[n];
			for(int i=0;i<n;i++){
				s[i]=sc.next().toCharArray();
				p[i] = sc.nextInt();
			}
			int x = 0;
			while(m--!=0){
				char[] r = sc.next().toCharArray();
				for(int i=0;i<n;i++){
					boolean f = true;
					for(int j=0;j<8;j++){
						if(s[i][j]=='*'||s[i][j]==r[j])continue;
						f = false;
					}
					if(f){
						x+=p[i];break;
					}
				}
			}
			System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2205().run();
	}
}
