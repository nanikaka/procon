package volume22;

import java.util.Scanner;

//Era Name
public class AOJ2242 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int q = sc.nextInt();
			if((n|q)==0)break;
			String[] name = new String[n];
			int[] s = new int[n];
			int[] t = new int[n];
			for(int i=0;i<n;i++){
				name[i] = sc.next();
				int b = sc.nextInt();
				int y = sc.nextInt();
				s[i] = y-b;
				t[i] = y;
			}
			while(q--!=0){
				int x = sc.nextInt();
				boolean f = false;
				for(int i=0;i<n;i++){
					if(s[i]<x&&x<=t[i]){
						f = true;
						System.out.println(name[i]+" "+(x-s[i]));
					}
				}
				if(!f)System.out.println("Unknown");
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2242().run();
	}
}
