package volume0;

import java.util.Scanner;

//Roman Figure
public class AOJ0039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] s = sc.next().toCharArray();
			int sum = 0;
			int i;
			for(i=0;i<s.length-1;i++){
				if(f(s[i])>=f(s[i+1]))sum+=f(s[i]);
				else{
					sum += f(s[i+1])-f(s[i]);
					i++;
				}
			}
			if(i<s.length)sum += f(s[i]);
			System.out.println(sum);
		}
	}
	
	public static int f(char c){
		return c=='I'?1:
			c=='V'?5:
			c=='X'?10:
			c=='L'?50:
			c=='C'?100:
			c=='D'?500:1000;
	}
}
