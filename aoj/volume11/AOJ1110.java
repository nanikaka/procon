package volume11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Patience
public class AOJ1110 {

	void run(){
		int[][] move = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			String start = "";
			for(int i=0;i<5;i++)for(int j=0;j<4;j++)start+=sc.next();
			List<String> l = new ArrayList<String>();
			l.add(start);
			int step = 20;
			while(!l.isEmpty()){
				List<String> next = new ArrayList<String>();
				Set<String> u = new HashSet<String>();
				for(String s:l){
					char[] ch = s.toCharArray();
					for(int i=0;i<5;i++){
						for(int j=0;j<4;j++){
							char x = ch[i*4+j];
							if(x=='0')break;
							for(int k=0;k<8;k++){
								int ni = i+move[k][0];
								int nj = j+move[k][1];
								if(0<=ni&&ni<5&&0<=nj&&nj<4){
									if(x==ch[ni*4+nj]){
										String n = "";
										for(int a=0;a<5;a++){
											for(int b=0;b<4;b++){
												if(a==i&&b==j||a==ni&&b==nj)continue;
												n += ch[a*4+b];
											}
										}
										n += "00";
										if(!u.contains(n)){
											u.add(n); next.add(n);
										}
									}
								}
							}
						}
					}
				}
				if(next.isEmpty()){
					System.out.println(step);
				}
				step-=2;
				l = next;
			}
		}
	}

	public static void main(String[] args) {
		new AOJ1110().run();
	}
}
