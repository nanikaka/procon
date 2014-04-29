package volume0;

import java.util.Scanner;

//Drawing Lots II
public class AOJ0069 {

	static int sim(char[][] s, int n, int d, int start){
		int t = start;
		for(int i=0;i<d;i++){
			if(t>0&&s[i][t-1]=='1')t--;
			else if(t<n-1 && s[i][t]=='1')t++;
		}
		return t;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int m = sc.nextInt()-1;
			int g = sc.nextInt()-1;
			int d = sc.nextInt();
			char[][] s = new char[d][n-1];
			for(int i=0;i<d;i++)s[i]=sc.next().toCharArray();
			if(sim(s,n,d,m)==g){
				System.out.println(0);
				continue;
			}
			boolean ok = false;
			for(int i=0;i<d;i++){
				for(int j=0;j<n-1;j++){
					if(ok || s[i][j]=='1')continue;
					boolean left, right;
					if(j==0||s[i][j-1]=='0')left = true;
					else left = false;
					if(j==n-2||s[i][j+1]=='0')right = true;
					else right = false;
					if(left&&right){
						s[i][j]='1';
						if(sim(s,n,d,m)==g){
							System.out.println((i+1)+" "+(j+1));
							ok = true;
							break;
						}
						s[i][j]='0';
					}
				}
			}
			if(!ok)System.out.println("1");
		}
	}
}
