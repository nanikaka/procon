package volume20;

import java.util.Scanner;

//Dance Dance Revolution
public class AOJ2079 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			char[] s = sc.next().toCharArray();
			boolean f = false;
			for(int i=0;i+1<s.length;i++)f|=s[i]==s[i+1];
			System.out.println(f?"No":"Yes");
		}
	}
	
	public static void main(String[] args) {
		new AOJ2079().run();
	}
}
