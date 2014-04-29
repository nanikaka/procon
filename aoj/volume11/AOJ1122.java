package volume11;

import java.util.Scanner;

//What is the Number in my Mind ?
public class AOJ1122 {

	char[][] t;
	int[] hit, blow;
	boolean[][] appear;
	int n, m;

	int[] temph, tempb;
	char[] s;
	
	boolean[] u;
	String ans;
	int c;
	
	void dfs(int k){
		if(c>1)return;
		if(k==n){
			boolean ok = true;
			for(int j=0;j<m;j++){
				if(temph[j]!=hit[j]||tempb[j]!=blow[j])ok = false;
			}
			if(!ok)return;
			c++;
			ans = new String(s);
			return;
		}
		for(int i=0;i<10;i++){
			if(u[i])continue;
			boolean ok = true;
			//各ヒントに対してhit数, blow数更新
			for(int j=0;j<m;j++){
				if(appear[j][i]){
					if(t[j][k]-'0'==i)temph[j]++;
					else tempb[j]++;
					if(hit[j]<temph[j]||blow[j]<tempb[j])ok = false;
				}
			}
			if(ok){
				u[i] = true;
				s[k] = (char)(i+'0');
				dfs(k+1);
				u[i] = false;
			}
			//hit, blowを更新前に戻す
			for(int j=0;j<m;j++){
				if(appear[j][i]){
					if(t[j][k]-'0'==i)temph[j]--;
					else tempb[j]--;
				}
			}
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			m = sc.nextInt();
			if((n|m)==0)break;
			t = new char[m][n];
			hit = new int[m];
			blow = new int[m];
			appear = new boolean[m][10];
			for(int i=0;i<m;i++){
				t[i] = sc.next().toCharArray();
				for(char ch:t[i]){
					appear[i][ch-'0'] = true;
				}
				hit[i] = sc.nextInt();
				blow[i] = sc.nextInt();
			}
			temph = new int[m];
			tempb = new int[m];
			ans = "NO";
			c = 0;
			u = new boolean[10];
			s = new char[n];
			dfs(0);
			System.out.println(c>1?"NO":ans);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1122().run();
	}
}
