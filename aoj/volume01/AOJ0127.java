package volume01;

import java.util.Scanner;

//Pocket Pager Input
public class AOJ0127 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] ch = {
				{'a','f','k','p','u','z'},
				{'b','g','l','q','v','.'},
				{'c','h','m','r','w','?'},
				{'d','i','n','s','x','!'},
				{'e','j','o','t','y',' '}
		};
		while(sc.hasNext()){
			char[] s = sc.next().toCharArray();
			if(s.length%2==1){
				System.out.println("NA");
				continue;
			}
			String ans = "";
			for(int i=0;i<s.length;i+=2){
				int b = s[i]-'0'-1;
				int a = s[i+1]-'0'-1;
				if(0<=a&&a<5&&0<=b&&b<6)ans+=ch[a][b];
				else{
					ans = "NA";
					break;
				}
			}
			System.out.println(ans);
		}
	}
}
