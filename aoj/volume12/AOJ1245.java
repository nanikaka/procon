package volume12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Gap
public class AOJ1245 {

	String trans(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++)for(int j=0;j<8;j++){
			sb.append(a[i][j]==0?"00":a[i][j]);
		}
		return sb.toString();
	}
	
	int min, INF = 1<<29;
	int[][] a;
	int[] pos;
	String g = "1112131415161700212223242526270031323334353637004142434445464700";
	Map<String, Integer> ref;
	
	void dfs(int d){
		String r = trans();
		if(min<=d||ref.containsKey(r)&&ref.get(r)<=d)return;
		if(r.equals(g)){
			min = d;return;
		}
		ref.put(r, d);
		for(int i=0;i<4;i++)for(int j=1;j<8;j++){
			if(a[i][j]!=0||a[i][j-1]==0||a[i][j-1]%10==7)continue;
			int x = a[i][j-1]+1;
			int p = pos[x];
			a[p/8][p%8] = 0; a[i][j] = x;
			pos[x] = i*8+j;
			dfs(d+1);
			a[p/8][p%8] = x; a[i][j] = 0;
			pos[x] = p;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			min = INF;
			a = new int[4][8];
			for(int i=0;i<4;i++)for(int j=1;j<8;j++){
				a[i][j]=sc.nextInt();
			}
			for(int i=0;i<4;i++)for(int j=1;j<8;j++){
				if(a[i][j]%10==1){
					int t = a[i][j]/10-1;
					a[t][0] = a[i][j];
					a[i][j] = 0;
				}
			}
			pos = new int[48];
			for(int i=0;i<4;i++)for(int j=0;j<8;j++){
				if(a[i][j]==0)continue;
				pos[a[i][j]] = i*8+j;
			}
			ref = new HashMap<String, Integer>();
			dfs(0);
			System.out.println(min==INF?-1:min);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1245().run();
	}
}
