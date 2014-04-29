package volume11;

import java.util.Scanner;

//Kanglish:Analysis on Artificial Language
public class AOJ1121 {

	void run(){
		String[] kang = {"a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z",
				"ld", "mb", "mp", "nc", "nd", "ng", "nt", "nw", "ps", "qu", "cw", "ts"
		};
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); sc.nextLine();
		int[][] c = new int[38][38];
		while(N--!=0){
			for(String s:sc.nextLine().split(" ")){
				int p = -1;
				while(!"".equals(s)){
					for(int k=37;k>=0;k--){
						if(s.startsWith(kang[k])){
							if(p!=-1)c[p][k]++;
							p = k;
							s = s.substring(kang[k].length(), s.length());
							break;
						}
					}
				}
			}
		}
		for(int i=0;i<38;i++){
			int k = 0;
			for(int j=1;j<38;j++){
				if(c[i][k]<c[i][j])k=j;
			}
			System.out.println(kang[i]+" "+kang[k]+" "+c[i][k]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1121().run();
	}
}
