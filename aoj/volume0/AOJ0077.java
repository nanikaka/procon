package volume0;

import java.util.Scanner;

//Run Length
public class AOJ0077 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] s = sc.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			int i = 0;
			while(i<s.length){
				if(s[i]=='@'){
					int x = s[++i]-'0';
					i++;
					while(x--!=0)sb.append(s[i]);
				}
				else sb.append(s[i]);
				i++;
			}
			System.out.println(sb);
		}
	}
}
