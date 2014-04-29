package volume10;

import java.util.Scanner;

//Extraordinary Grid 2
public class AOJ1003 {

	public static char[][] key = {
		{' '},
		{'\'' , ',' , '.' , '!' , '?'},
		{'a', 'b', 'c', 'A', 'B', 'C'},
		{'d', 'e', 'f', 'D', 'E', 'F'},
		{'g', 'h', 'i', 'G', 'H', 'I'},
		{'j', 'k', 'l', 'J', 'K', 'L'},
		{'m', 'n', 'o', 'M', 'N', 'O'},
		{'p', 'q', 'r', 's', 'P', 'Q', 'R', 'S'},
		{'t', 'u', 'v', 'T', 'U', 'V'},
		{'w', 'x', 'y', 'z', 'W', 'X', 'Y', 'Z'}
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] s = (sc.next()+"0").toCharArray();
			StringBuilder sb = new StringBuilder();
			int i=0;
			while(i<s.length){
				char p = s[i];
				int k = (int)(s[i]-'0');
				int c = 0;
				i++;
				if(k==0){
					sb.append(' ');
					continue;
				}
				while(i<s.length&&p==s[i]){
					i++;
					c++;
				}
				sb.append(key[k][c%key[k].length]);
				if(s[i]=='0')i++;
			}
			System.out.println(sb);
		}
	}
}
