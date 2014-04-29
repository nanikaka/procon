package volume10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Dr. Nakamura's Lab.
public class AOJ1038 {

	int h, w;
	char[][] map;
	int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	
	long trans(int i, int j, int[][] block, int s){
		int c0 = block[0][0], c1 = block[0][1], c2 = block[1][0], c3 = block[1][1], c4 = block[2][0], c5 = block[2][1];
		long res = i*w+j;
		res*=100; res+=c0*w+c1;
		res*=100; res+=c2*w+c3;
		res*=100; res+=c4*w+c5;
		res*=10; res+=s;
		return res;
	}
	int dist(int i, int j, int a, int b){
		return Math.abs(i-a)+Math.abs(j-b);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			h = sc.nextInt(); w = sc.nextInt();
			if((h|w)==0)break;
			map = new char[h][w];
			int panel = 0;
			int si=0, sj=0, gi=0, gj=0;
			int[][] c = new int[3][2];
			int con = 0;
			for(int i=0;i<h;i++){
				map[i] = sc.next().toCharArray();
				for(int j=0;j<w;j++){
					if(map[i][j]=='@'){
						map[i][j] = '.'; si=i; sj=j;
					}
					else if(map[i][j]=='E'){
						map[i][j] = '.'; gi=i; gj=j;
					}
					else if(map[i][j]=='c'){
						map[i][j] = '.';
						c[con][0] = i; c[con][1] = j;
						con++;
					}
					else if(map[i][j]=='w'){
						map[i][j] = (char)(panel+'0');
						panel++;
					}
				}
			}
			Set<Long> u = new HashSet<Long>();
			List<Long> l = new ArrayList<Long>();
			long start = trans(si, sj, c, 0);
			l.add(start);
			u.add(start);
			int ans = -1, step = 0;
			while(!l.isEmpty()){
				List<Long> next = new ArrayList<Long>();
				for(long v:l){
					int state = (int) (v%10); v/=10;
					int con2 = (int) (v%100); v/=100;
					int con1 = (int) (v%100); v/=100;
					int con0 = (int) (v%100); v/=100;
					int pos = (int) v;
					int c0 = con0/w, c1 = con0%w;
					int c2 = con1/w, c3 = con1%w;
					int c4 = con2/w, c5 = con2%w;
					int i = pos/w, j = pos%w;
					if(i==gi&&j==gj){
						ans = step; next.clear(); break;
					}
					//decide the block move
					for(int z=0;z<8;z++){
						int[][] nc = new int[3][2];
						nc[0][0] = c0; nc[0][1] = c1; nc[1][0] = c2; nc[1][1] = c3; nc[2][0] = c4; nc[2][1] = c5;
						int nstate = state;
						boolean f = true;
						for(int b=0;b<3;b++){
							if(((z>>b)&1)==0)continue;
							if(dist(i, j, nc[b][0], nc[b][1])!=1){
								f = false; break;
							}
							int dy = nc[b][0]-i, dx = nc[b][1]-j;
							int y = nc[b][0], x = nc[b][1];
							for(;;){
								int ny = y+dy, nx = x+dx;
								if(map[ny][nx]=='#'){
									nc[b][0] = y; nc[b][1] = x;break;
								}
								boolean col = false;
								for(int k=0;k<3;k++){
									if(b==k)continue;
									if(ny==nc[k][0]&&nx==nc[k][1]){
										nc[b][0] = y; nc[b][1] = x; col = true; break;
									}
								}
								if(col)break;
								if(map[ny][nx]!='.'){
									int id = map[ny][nx]-'0';
									if(((nstate>>id)&1)==0){
										nc[b][0] = nc[b][1] = 0; nstate+=1<<id; break;
									}
								}
								y = ny; x = nx;
							}
						}
						if(!f)continue;
						for(int k=0;k<4;k++){
							int ni = i+move[k][0], nj = j+move[k][1];
							if(map[ni][nj]=='#')continue;
							f = true;
							for(int b=0;b<3;b++){
								if(ni==nc[b][0]&&nj==nc[b][1]){
									f = false;
									break;
								}
							}
							if(!f)continue;
							if(map[ni][nj]!='.'){
								int id = map[ni][nj]-'0';
								if(((nstate>>id)&1)>0){
									long ns = trans(ni, nj, nc, nstate);
									if(!u.contains(ns)){
										u.add(ns); next.add(ns);
									}
								}
							}
							else{
								long ns = trans(ni, nj, nc, nstate);
								if(!u.contains(ns)){
									u.add(ns); next.add(ns);
								}
							}
						}
					}
				}
				l = next; step++;
			}
			System.out.println(ans);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1038().run();
	}
}
