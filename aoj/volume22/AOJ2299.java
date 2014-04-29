package volume22;

import java.util.Scanner;

//Tiles are Colorful
public class AOJ2299 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		char[][] map = new char[h][w];
		for(int i=0;i<h;i++)map[i] = sc.next().toCharArray();
		boolean[] exist = new boolean[26];
		int[] num = new int[26];
		int[][][] pos = new int[26][2][2];
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				if(map[i][j]=='.')continue;
				int id = map[i][j]-'A';
				exist[id] = true;
				pos[id][num[id]][0] = i;
				pos[id][num[id]][1] = j;
				num[id]++;
			}
		}
		long[][] cond = new long[26][2];
		for(int i=0;i<26;i++){
			if(!exist[i])continue;
			if(pos[i][0][0]==pos[i][1][0]){
				cond[i][1] = -1;
				if(Math.abs(pos[i][0][1]-pos[i][1][1])==1)cond[i][0] = -1;
				else{
					long s = 0;
					for(int j=pos[i][0][1]+1;j<pos[i][1][1];j++){
						char ch = map[pos[i][0][0]][j];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					cond[i][0] = s;
				}
			}
			else if(pos[i][0][1]==pos[i][1][1]){
				cond[i][1] = -1;
				if(pos[i][0][0]+1==pos[i][1][0]){
					cond[i][0] = -1;
					continue;
				}
				long s = 0;
				for(int j=pos[i][0][0]+1;j<pos[i][1][0];j++){
					char ch = map[j][pos[i][0][1]];
					if(ch=='.')continue;
					s |= 1<<((int)(ch-'A'));
				}
				cond[i][0] = s;
			}
			else{
				if(pos[i][0][1]<pos[i][1][1]){
					int ri = pos[i][0][0];
					int rj = pos[i][1][1];
					int li = pos[i][1][0];
					int lj = pos[i][0][1];
					long s = 0;
					for(int j=lj+1;j<=rj;j++){
						char ch = map[ri][j];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					for(int j=ri;j<li;j++){
						char ch = map[j][rj];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					cond[i][0] = s;
					s = 0;
					for(int j=ri+1;j<=li;j++){
						char ch = map[j][lj];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					for(int j=lj+1;j<rj;j++){
						char ch = map[li][j];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					cond[i][1] = s;
				}
				else{
					int li = pos[i][1][0];
					int lj = pos[i][1][1];
					int ri = pos[i][0][0];
					int rj = pos[i][0][1];
					long s = 0;
					for(int j=lj;j<rj;j++){
						char ch = map[ri][j];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					for(int j=ri;j<li;j++){
						char ch = map[j][lj];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					cond[i][0] = s;
					s = 0;
					for(int j=ri+1;j<=li;j++){
						char ch = map[j][rj];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					for(int j=lj+1;j<=rj;j++){
						char ch = map[li][j];
						if(ch=='.')continue;
						s |= 1<<((int)(ch-'A'));
					}
					cond[i][1] = s;
				}
			}
		}
		int c = 0;
		boolean update = true;
		long s = 0;
		while(update){
			update = false;
			for(int i=0;i<26;i++){
				if(!exist[i])continue;
				if(cond[i][0]!=-1&&((s&cond[i][0])==cond[i][0]) || cond[i][1]!=-1&&((s&cond[i][1])==cond[i][1])){
					exist[i] = false;
					c++;
					s|=1<<i;
					update = true;
				}
			}
		}
		System.out.println(c*2);
	}

	public static void main(String[] args) {
		new AOJ2299().run();
	}
}
