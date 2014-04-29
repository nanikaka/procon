package volume0;

import java.util.Scanner;

//Puzzle
public class AOJ0043 {

	static boolean enable(int[] c){
		for(int i=1;i<=9;i++){
			if(c[i]>=2){
				c[i]-=2;
				if(solve(c, 1))return true;
				c[i]+=2;
			}
		}
		return false;
	}
	
	static boolean solve(int[] c, int k){
		if(k==10)return true;
		if(c[k]==0)return solve(c, k+1);
		if(c[k]>=3){
			c[k]-=3;
			if(solve(c, k))return true;
			c[k]+=3;
		}
		if(k>=8)return false;
		boolean f = true;
		for(int i=k;i<k+3;i++){
			if(c[i]==0)f = false;
		}
		if(!f)return false;
		for(int i=k;i<k+3;i++){
			c[i]--;
		}
		if(solve(c, k))return true;
		for(int i=k;i<k+3;i++){
			c[i]++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] s = sc.next().toCharArray();
			int[] count = new int[10];
			for(char ch : s)count[ch-'0']++;
			String r = "0";
			for(int i=1;i<=9;i++){
				int[] c = new int[10];
				for(int j=1;j<=9;j++)c[j]=count[j];
				c[i]++;
				if(c[i]==5){
					c[i]--;
					continue;
				}
				if(enable(c)){
					if(r.equals("0"))r = i+"";
					else r += " "+i;
				}
				c[i]--;
			}
			System.out.println(r);
		}
	}
}
