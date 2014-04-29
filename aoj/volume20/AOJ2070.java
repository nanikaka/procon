package volume20;

import java.util.Scanner;

//First Experience
public class AOJ2070 {
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] s = sc.next().toCharArray();
			int r1 = 0, r2 = 0;
			char r3 = ' ';
			boolean f = true;
			for(int i=0;i<s.length;i++){
				if(Character.isDigit(s[i]))r2=r2*10+s[i]-'0';
				else {
					if(r3==' ')r1=r2;
					else if(r3=='+')r1+=r2;
					else if(r3=='-')r1-=r2;
					else r1*=r2;
					r2 = 0;
					r3 = s[i];
				}
				if(r1<0||r2<0||10000<=r1||10000<=r2){
					f = false; break;
				}
			}
			System.out.println(f?r1:"E");
		}
	}
	
	public static void main(String[] args) {
		new AOJ2070().run();
	}
}
