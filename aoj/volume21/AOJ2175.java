package volume21;

import java.util.Scanner;

//Whist
public class AOJ2175 {

	int f(char s){
		return s=='A'?14:s=='K'?13:s=='Q'?12:s=='J'?11:s=='T'?10:s-'0';
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			char t = sc.next().charAt(0);
			if(t=='#')break;
			String[][] c = new String[4][13];
			for(int i=0;i<4;i++)for(int j=0;j<13;j++)c[i][j]=sc.next();
			int[] p = new int[2];
			int w = 0;
			for(int j=0;j<13;j++){
				String r = c[w][j];
				int m = w;
				for(int i=0;i<4;i++){
					if(i==w)continue;
					String v = c[i][j];
					if(r.charAt(1)==t){
						if(v.charAt(1)!=t)continue;
						if(f(r.charAt(0))<f(v.charAt(0))){
							m = i; r = v; continue;
						}
					}
					else if(v.charAt(1)==t){
						m = i; r = v;
					}
					else if(v.charAt(1)==r.charAt(1)&&f(r.charAt(0))<f(v.charAt(0))){
						m = i; r = v;
					}
				}
				p[m%2]++; w = m;
			}
			if(p[0]<p[1])System.out.println("EW "+(p[1]-6));
			else System.out.println("NS "+(p[0]-6));
		}
	}
	
	public static void main(String[] args) {
		new AOJ2175().run();
	}
}
