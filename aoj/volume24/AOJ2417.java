package volume24;

import java.util.Scanner;

//Flick Input
public class AOJ2417 {

	void run(){
		Scanner sc = new Scanner(System.in);
		String[] s = {"a","i","u","e","o"};
		String[] b = {"w","a","k","s","t","n","h","m","y","r"};
		char[] r = sc.next().toCharArray();
		StringBuilder res = new StringBuilder();
		for(int i=0;i<r.length;i+=2){
			int id = r[i]-'0';
			int x = r[i+1]=='T'?0:r[i+1]=='L'?1:r[i+1]=='U'?2:r[i+1]=='R'?3:4;
			if(id==1)res.append(s[x]);
			else if(id==0){
				if(x==0)res.append("wa");
				else if(x==2)res.append("nn");
				else res.append("wo");
			}
			else res.append(b[id]+s[x]);
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2417().run();
	}
}
