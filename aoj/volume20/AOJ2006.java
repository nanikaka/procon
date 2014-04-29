package volume20;

import java.util.Scanner;

//Keitai Message
public class AOJ2006 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] k = {
				{},
				{'.',',','!','?',' '},
				{'a','b','c'},
				{'d','e','f'},
				{'g','h','i'},
				{'j','k','l'},
				{'m','n','o'},
				{'p','q','r','s'},
				{'t','u','v'},
				{'w','x','y','z'}
		};
		int t = sc.nextInt();
		while(t--!=0){
			char[] s = sc.next().toCharArray();
			int i = 0;
			StringBuilder sb = new StringBuilder();
			while(i<s.length){
				if(s[i]=='0')i++;
				else{
					char c = s[i++];
					int j = 0;
					while(s[i]==c){i++;j++;}
					sb.append(k[c-'0'][j%k[c-'0'].length]);
					i++;
				}
			}
			System.out.println(sb);
		}
	}
}
