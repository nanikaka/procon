package volume21;

import java.util.Scanner;

//Angel Stairs
public class AOJ2190 {
	
	String[] f = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	int trans(String s){
		for(int k=0;k<12;k++)if(f[k].equals(s))return k;
		return 0;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			int n = sc.nextInt(), m = sc.nextInt();
			int[] t = new int[n+2];
			t[0] = t[n+1] = -1;
			for(int i=1;i<=n;i++)t[i]=trans(sc.next());
			int[] s = new int[m];
			for(int i=0;i<m;i++)s[i]=trans(sc.next());
			int p = n;
			boolean con = true;
			for(int k=m-1;k>=0&&con;k--){
				con = false;
				if(p==0||p==n+1)break;
				int np = p-2;
				if(0<=np&&s[k]==(t[p]+1)%12){
					con = true; p = np; continue;
				}
				np = p-1;
				if(0<=np&&s[k]==t[p]){
					con = true; p = np; continue;
				}
				np = p+1;
				if(np<=n&&s[k]==(t[p]+11)%12){
					con = true; p = np; continue;
				}
			}
			if(con&&p==0){
				System.out.println("Yes"); continue;
			}
			p = n-1;
			if(0<=p){
				con = true;
				for(int k=m-1;k>=0&&con;k--){
					con = false;
					if(p==0||p==n+1)break;
					int np = p-2;
					if(0<=np&&s[k]==(t[p]+1)%12){
						con = true; p = np; continue;
					}
					np = p-1;
					if(0<=np&&s[k]==t[p]){
						con = true; p = np; continue;
					}
					np = p+1;
					if(np<=n&&s[k]==(t[p]+11)%12){
						con = true; p = np; continue;
					}
				}
				if(con&&p==0){
					System.out.println("Yes"); continue;
				}
			}
			System.out.println("No");
		}
	}
	
	public static void main(String[] args) {
		new AOJ2190().run();
	}
}
