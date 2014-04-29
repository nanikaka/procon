package volume0;

import java.util.Scanner;

//Poker Hand
public class AOJ0038 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String[] ss = sc.next().split(",");
			int[] c = new int[14];
			int max = 0;
			for(String s:ss){
				max = Math.max(max, ++c[Integer.parseInt(s)]);
			}
			if(max==4){
				System.out.println("four card");
			}
			else if(max==3){
				boolean f = false;
				for(int i=1;i<=13;i++){
					if(c[i]==2){
						f = true;
						break;
					}
				}
				System.out.println(f?"full house":"three card");
			}
			else if(max==2){
				int k = 0;
				for(int i=1;i<=13;i++){
					if(c[i]==2)k++;
				}
				System.out.println(k==2?"two pair":"one pair");
			}
			else{
				boolean f = false;
				for(int i=1;i<=10;i++){
					if(c[i]==1){
						boolean ff = true;
						for(int j=i+1;j<=i+4;j++){
							if(c[(j-1)%13+1]!=1){
								ff = false;
								break;
							}
						}
						f |= ff;
					}
				}
				System.out.println(f?"straight":"null");
			}
		}
	}
}
