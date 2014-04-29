package volume01;

import java.util.Scanner;

//Rotation of a Pattern
public class AOJ0133 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] s = new char[8][8];
		for(int i=0;i<8;i++)s[i]=sc.next().toCharArray();
		for(int r=90;r<=270;r+=90){
			System.out.println(r);
			char[][] t = new char[8][8];
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++)t[i][j]=s[7-j][i];
				System.out.println(new String(t[i]));
			}
			s = t;
		}
	}
}
