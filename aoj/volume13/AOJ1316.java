package volume13;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//The Sorcerer's Donut
public class AOJ1316 {

	@SuppressWarnings("unchecked")
	void run(){
		int[][] move = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		Scanner sc = new Scanner(System.in);
		for(;;){
			int h = sc.nextInt(), w = sc.nextInt();
			if((h|w)==0)break;
			char[][] m = new char[h][w];
			for(int i=0;i<h;i++)m[i]=sc.next().toCharArray();
			Set<String>[][] set = new HashSet[26][201];
			for(int i=0;i<26;i++)for(int j=0;j<=200;j++)set[i][j] = new HashSet<String>();
			String res = "";
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				for(int k=0;k<8;k++){
					StringBuilder sb = new StringBuilder(m[i][j]+"");
					int pi = (i+move[k][0]+h)%h, pj = (j+move[k][1]+w)%w;
					while(pi!=i||pj!=j){
						sb.append(m[pi][pj]);
						String r = sb.toString();
						if(set[m[i][j]-'A'][r.length()].contains(r)){
							if(res.length()<r.length())res = r;
							else if(res.length()==r.length()&&r.compareTo(res)<0)res = r;
						}
						else set[m[i][j]-'A'][r.length()].add(r);
						pi = (pi+move[k][0]+h)%h; pj = (pj+move[k][1]+w)%w;
					}
				}
			}
			System.out.println("".equals(res)?"0":res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1316().run();
	}
}
