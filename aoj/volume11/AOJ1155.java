package volume11;

import java.util.Scanner;

//How can I satisfy thee? Let me count the ways...
public class AOJ1155 {

	static char[] s;
	static int index;
	static int[] table;
	
	static char c(){
		return s[index++];
	}
	
	static int formura(){
		int r = term();
		while(index < s.length){
			char c = c();
			if(c=='*'){
				int p = term();
				r = Math.min(r, p);
			}
			else if(c=='+'){
				int p = term();
				r = Math.max(r, p);
			}
			else break;
		}
		return r;
	}
	
	static int term(){
		char c = c();
		if(c=='('){
			int r = formura();
			return r;
		}
		if(c=='-'){
			int r = term();
			return r==0?2:r==1?1:0;
		}
		if(Character.isDigit(c))return c-'0';
		return table[c-'P'];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String str = sc.next();
			if(str.equals("."))break;
			s = (str+"$").toCharArray();
			table = new int[3];
			int ans = 0;
			for(int i=0;i<3;i++){
				table[0]=i;
				for(int j=0;j<3;j++){
					table[1]=j;
					for(int k=0;k<3;k++){
						table[2]=k;
						index = 0;
						ans += formura()==2?1:0;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
