package volume05;

import java.util.Scanner;

//JOI and IOI
public class AOJ0522 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] s = sc.next().toCharArray();
			int c = 0;
			int d = 0;
			for(int i=2;i<s.length;i++){
				if(s[i]=='I'&&s[i-1]=='O'){
					c+=s[i-2]=='J'?1:0;
					d+=s[i-2]=='I'?1:0;
				}
			}
			System.out.println(c+"\n"+d);
		}
	}

	public static void main(String[] args) {
		new AOJ0522().run();
	}
}
