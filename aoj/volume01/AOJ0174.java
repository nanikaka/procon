package volume01;

import java.util.Scanner;

//Badminton
public class AOJ0174 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			char[] s = sc.next().toCharArray();
			if(s[0]=='0')break;
			int a = 0;
			int b = 0;
			for(int i=1;i<s.length;i++){
				if(s[i]=='A')a++;
				else b++;
			}
			if(a>b)a++;
			else b++;
			System.out.println(a+" "+b);
			for(int j=0;j<2;j++){
				s = sc.next().toCharArray();
				a = 0;
				b = 0;
				for(int i=1;i<s.length;i++){
					if(s[i]=='A')a++;
					else b++;
				}
				if(a>b)a++;
				else b++;
				System.out.println(a+" "+b);
			}
		}
	}
}
