package volume0;

import java.util.Scanner;

//Tic Tac Toe
public class AOJ0066 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] m = sc.next().toCharArray();
			char[][] s = new char[3][3];
			for(int i=0;i<3;i++)for(int j=0;j<3;j++)s[i][j]=m[i*3+j];
			char win = 'd';
			int[] c = new int[2];
			for(int i=0;i<3;i++){
				c[0]=c[1]=0;
				for(int j=0;j<3;j++){
					if(s[i][j]=='o')c[0]++;
					else if(s[i][j]=='x')c[1]++;
				}
				if(c[0]==3)win='o';
				else if(c[1]==3)win='x';
				c[0]=c[1]=0;
				for(int j=0;j<3;j++){
					if(s[j][i]=='o')c[0]++;
					else if(s[j][i]=='x')c[1]++;
				}
				if(c[0]==3)win='o';
				else if(c[1]==3)win='x';
				c[0]=c[1]=0;
			}
			for(int i=0;i<3;i++){
				if(s[i][i]=='o')c[0]++;
				else if(s[i][i]=='x')c[1]++;
			}
			if(c[0]==3)win='o';
			else if(c[1]==3)win='x';
			c[0]=c[1]=0;
			for(int i=0;i<3;i++){
				if(s[i][2-i]=='o')c[0]++;
				else if(s[i][2-i]=='x')c[1]++;
			}
			if(c[0]==3)win='o';
			else if(c[1]==3)win='x';
			System.out.println(win);
		}
	}
}
