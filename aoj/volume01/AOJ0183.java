package volume01;

import java.util.Scanner;

//Black-and-White
public class AOJ0183 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String s = sc.next();
			if(s.equals("0"))break;
			char[][] m = new char[3][3];
			m[0] = s.toCharArray();
			for(int i=1;i<3;i++)m[i]=sc.next().toCharArray();
			int[][] c = new int[4][5];
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					int x = m[i][j]=='b'?1:m[i][j]=='w'?-1:0;
					c[i+1][0]+=x;
					c[0][j+1]+=x;
					if(i==j)c[0][0]+=x;
					if(i==2-j)c[0][4]+=x;
				}
			}
			String ans = "NA";
			for(int i=0;i<4;i++)if(Math.abs(c[i][0])==3)ans=c[i][0]==3?"b":"w";
			for(int j=0;j<5;j++)if(Math.abs(c[0][j])==3)ans=c[0][j]==3?"b":"w";
			System.out.println(ans);
		}
	}
}
