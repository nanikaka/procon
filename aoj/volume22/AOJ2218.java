package volume22;

import java.util.Scanner;

//K Poker
public class AOJ2218 {

	int suit(char c){
		return c=='S'?0:c=='C'?1:c=='H'?2:3;
	}
	
	int num(char c){
		return c=='K'?13:c=='Q'?12:c=='J'?11:c=='T'?10:c=='A'?1:c-'0';
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		boolean top = true;
		while(sc.hasNext()){
			if(!top)System.out.println();
			top = false;
			int n = sc.nextInt();
			int[][] p = new int[4][14];
			for(int i=0;i<4;i++)for(int j=1;j<14;j++)p[i][j] = sc.nextInt();
			//0: no 1: one-pair 2:two-pair 3:three-cards 4:straight 5:flash 6:fullhouse 7:fourcard 8:straight-flash 9:royal
			int[] r = new int[10];
			for(int i=1;i<10;i++)r[i]=sc.nextInt();
			while(n--!=0){
				int b = 0;
				int X = 0;
				int maxS = 0;
				int maxN = 0;
				int[] suitNum = new int[4];
				int[] numNum = new int[14];
				for(int i=0;i<5;i++){
					char[] ch = sc.next().toCharArray();
					int s = suit(ch[1]);
					int x = num(ch[0]);
					b+=p[s][x];
					suitNum[s]++;
					numNum[x]++;
					maxS = Math.max(maxS, suitNum[s]);
					maxN = Math.max(maxN, numNum[x]);
				}
				if(maxN==4){
					X = 7;
				}
				else if(maxN==3){
					boolean f = true;
					for(int i=1;i<=13;i++){
						if(numNum[i]==2){
							f = false;
						}
					}
					if(f)X = 3;
					else X = 6;
				}
				else if(maxN==2){
					int c = 0;
					for(int i=1;i<=13;i++)if(numNum[i]==2)c++;
					if(c==2)X = 2;
					else X = 1;
				}
				else{
					boolean flash = maxS==5;
					boolean straight = false;
					for(int i=1;i+4<=13;i++){
						boolean f = true;
						for(int j=0;j<5;j++){
							if(numNum[i+j]==0)f = false;
						}
						if(f){
							straight = true;break;
						}
					}
					boolean royal = numNum[1]==1&&numNum[10]==1&&numNum[11]==1&&numNum[12]==1&&numNum[13]==1;
					if(royal&&flash)X = 9;
					else if(flash&&(royal||straight))X = 8;
					else if(flash)X = 5;
					else if(straight||royal)X = 4;
				}
				System.out.println(b*r[X]);
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2218().run();
	}
}
