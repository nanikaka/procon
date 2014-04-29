package volume02;

import java.util.Scanner;

//Aka-beko and 40 Thieves
public class AOJ0266 {

	int[][] dfa = {
			{0, 0},
			{2, 3},
			{0, 4},
			{2, 0},
			{5, 6},
			{6, 3},
			{3, 2}
	};
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			char[] s = sc.next().toCharArray();
			if(s[0]=='#')break;
			int p = 1;
			for(char t:s){
				p = dfa[p][t-'0'];
			}
			System.out.println(p==6?"Yes":"No");
		}
	}
	
	public static void main(String[] args) {
		new AOJ0266().run();
	}
}
