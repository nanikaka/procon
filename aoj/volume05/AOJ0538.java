package volume05;

import java.util.Scanner;

//IOIOI
public class AOJ0538 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int m = sc.nextInt();
			char[] s = sc.next().toCharArray();
			int[] c = new int[m];
			int a = 0;
			for(int i=2;i<m;i++){
				if(s[i]=='I'&&s[i-1]=='O'&&s[i-2]=='I'){
					c[i] = c[i-2]+1;
					if(n<=c[i])a++;
				}
			}
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0538().run();
	}
}
