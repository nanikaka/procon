package volume10;

import java.util.Scanner;

//Spellcasters
public class AOJ1085 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), S = sc.nextInt();
			if((n|S)==0)break;
			int[] r = new int[101];
			while(n--!=0)r[sc.nextInt()]++;
			int res = 0;
			for(int i=1;i<101;i++)for(int j=i;j<101;j++){
				if(S<i+j){
					if(i==j)res+=r[i]*(r[i]-1)/2;
					else res+=r[i]*r[j];
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1085().run();
	}
}
