package volume05;

import java.util.Scanner;

//String
public class AOJ0506 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			char[] s = sc.next().toCharArray();
			while(n--!=0){
				StringBuilder sb = new StringBuilder();
				int i = 0;
				char a = ' ';
				int c = 0;
				while(i<s.length){
					if(a==' '){
						a = s[i];
						c++;
					}
					else if(a==s[i]){
						c++;
					}
					else{
						sb.append(c+""+a);
						a = s[i];
						c = 1;
					}
					i++;
				}
				sb.append(c+""+a);
				s = sb.toString().toCharArray();
			}
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		new AOJ0506().run();
	}
}
