package volume22;

import java.util.Scanner;

//Swap Cipher
public class AOJ2281 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			char[] s = sc.next().toCharArray();
			int[][] swap = new int[n][2];
			for(int i=0;i<n;i++)for(int j=0;j<2;j++)swap[i][j]=sc.nextInt()-1;
			for(int i=n-1;i>=0;i--){
				int a = swap[i][0];
				int b = swap[i][1];
				int d = b-a;
				s[a] = (char)((s[a]-'a'+d)%26+'a');
				s[b] = (char)((s[b]-'a'+d)%26+'a');
				char t = s[a];
				s[a] = s[b];
				s[b] = t;
			}
			System.out.println(new String(s));
		}
	}
	
	public static void main(String[] args) {
		new AOJ2281().run();
	}
}
