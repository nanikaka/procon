package volume01;

import java.util.Scanner;

//Blackjack
public class AOJ0169 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String str = sc.nextLine();
			if(str.equals("0"))break;
			String[] s = str.split(" ");
			boolean[] mark = new boolean[22];
			mark[0]=true;
			for(int i=0;i<s.length;i++){
				int x = Integer.parseInt(s[i]);
				if(x>10)x=10;
				boolean[] next = new boolean[22];
				for(int j=0;j<22;j++){
					if(mark[j]){
						if(x!=1){
							if(j+x<22){
								next[j+x]=true;
							}
						}
						else{
							if(j+1<22){
								next[j+1]=true;
							}
							if(j+11<22){
								next[j+11]=true;
							}
						}
					}
				}
				mark = next;
			}
			int max = 0;
			for(int j=21;j>=0;j--)
				if(mark[j]){
					max = j;
					break;
				}
			System.out.println(max);
		}
	}
}
