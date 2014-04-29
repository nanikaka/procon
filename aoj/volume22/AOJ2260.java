package volume22;

import java.util.Scanner;

//(iwi)
public class AOJ2260 {

	void run(){
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		int c = 0;
		int n = s.length;
		for(int i=0;i<=(n%2==1?n/2:n/2-1);i++){
			char c1 = s[i];
			char c2 = s[n-i-1];
			if(c1=='i'){
				if(c2!='i')c++;
			}
			else if(c1=='w'){
				if(c2!='w')c++;
			}
			else if(c1=='('){
				if(c2!=')')c++;
			}
			else{
				if(c2!='(')c++;
			}
		}
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		new AOJ2260().run();
	}
}
