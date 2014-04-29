package volume02;

import java.util.Scanner;

//Subdivide The Land
public class AOJ0213 {

	static int[] size;
	static int[][] pos;
	static int[][] assign;
	static int w, h, n;
	static int c;
	static int[][] ans;
	
	static boolean col(int k1, int k2){
		if(assign[k2][0]<assign[k1][2]&&assign[k1][0]<assign[k2][2] && assign[k2][1]<assign[k1][3]&&assign[k1][1]<assign[k2][3])
			return true;
		return false;
	}
	
	static void f(int k){
		if(k==n+1){
			c++;
			if(c==2)return;
			for(int x=1;x<=n;x++){
				for(int i=assign[x][0];i<assign[x][2];i++){
					for(int j=assign[x][1];j<assign[x][3];j++){
						ans[i][j] = x;
					}
				}
			}
			return;
		}
		if(c>=2)return;
		int s = size[k];
		for(int x=1;x<=s;x++){
			if(s%x!=0)continue;
			for(int lj=pos[k][1]+1-x;lj<=pos[k][1];lj++){
				if(lj<0||lj>w)continue;
				for(int li=pos[k][0]+1-s/x;li<=pos[k][0];li++){
					if(li<0||li>h)continue;
					int rj = lj+x;
					int ri = li+s/x;
					if(rj>w)continue;
					if(ri>h)continue;
					assign[k][0] = li;
					assign[k][1] = lj;
					assign[k][2] = ri;
					assign[k][3] = rj;
					boolean col = false;
					for(int d=1;d<k;d++){
						if(col(d, k)){
							col = true;
							break;
						}
					}
					if(col)continue;
					f(k+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			w = sc.nextInt();
			h = sc.nextInt();
			n = sc.nextInt();
			if((w|h|n)==0)break;
			size = new int[n+1];
			pos = new int[n+1][2];
			for(int i=0;i<n;i++){
				int b = sc.nextInt();
				int k = sc.nextInt();
				size[b] = k;
			}
			int[][] m = new int[h][w];
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					int x = sc.nextInt();
					m[i][j] = x;
					if(x>0){
						pos[x][0] = i;
						pos[x][1] = j;
					}
				}
			}
			assign = new int[n+1][4];
			c = 0;
			ans = new int[h][w];
			f(1);
			if(c!=1)System.out.println("NA");
			else {
				for(int i=0;i<h;i++){
					for(int j=0;j<w;j++){
						if(j>0)System.out.print(" ");
						System.out.print(ans[i][j]);
					}
					System.out.println();
				}
			}
		}
	}
}
