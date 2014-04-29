package volume0;

import java.util.Scanner;

//Secret Number
public class AOJ0064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = 0;
		while(sc.hasNext()){
			char[] m = sc.next().toCharArray();
			for(int i=0;i<m.length;i++){
				if(Character.isDigit(m[i])){
					int x = m[i++]-'0';
					while(i<m.length&&Character.isDigit(m[i])){
						x*=10;
						x+=m[i++]-'0';
					}
					s+=x;
				}
			}
		}
		System.out.println(s);
	}
}
