package volume0;

import java.util.Scanner;

//A Figure on Surface
public class AOJ0036 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[][] map = new char[8][8];
			for(int i=0;i<8;i++)map[i]=sc.next().toCharArray();
			boolean f = false;
			int s = 0;
			int t = 0;
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(map[i][j]=='1'){
						f = true;
						s += t;
					}
					if(f)t++;
				}
			}
			char ch = ' ';
			switch(s){
			case 18:ch='A';break;
			case 48:ch='B';break;
			case 6:ch='C';break;
			case 30:ch='D';break;
			case 20:ch='E';break;
			case 34:ch='F';break;
			case 16:ch='G';break;
			default :ch='?';
			}
			System.out.println(ch);
		}
	}
}
