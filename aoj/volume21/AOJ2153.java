package volume21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Mirror Cave
public class AOJ2153 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[][] m1 = {{-1,0},{0,1},{1,0},{0,-1}}, m2 = {{-1,0},{0,-1},{1,0},{0,1}};
		for(;;){
			int w = sc.nextInt(), h = sc.nextInt();
			if((w|h)==0)break;
			sc.nextLine();
			char[][] a = new char[h][], b = new char[h][];
			for(int i=0;i<h;i++){
				String[] s = sc.nextLine().split(" ");
				a[i] = s[0].toCharArray(); b[i] = s[1].toCharArray();
			}
			int Li = 0, Lj = 0, Ri = 0, Rj = 0, GLi = 0, GLj = 0, GRi = 0, GRj = 0;
			for(int i=0;i<h;i++)for(int j=0;j<w;j++){
				if(a[i][j]=='%'){
					a[i][j] = '.'; GLi = i; GLj = j;
				}
				if(a[i][j]=='L'){
					a[i][j] = '.'; Li = i; Lj = j;
				}
				if(b[i][j]=='%'){
					b[i][j] = '.'; GRi = i; GRj = j;
				}
				if(b[i][j]=='R'){
					b[i][j] = '.'; Ri = i; Rj = j;
				}
			}
			boolean[][][][] u = new boolean[h][w][h][w];
			u[Li][Lj][Ri][Rj] = true;
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[]{Li, Lj, Ri, Rj});
			String res = "No";
			while(!l.isEmpty()){
				List<int[]> next = new ArrayList<int[]>();
				for(int[] v:l){
					int li = v[0], lj = v[1], ri = v[2], rj = v[3];
					if(li==GLi&&lj==GLj||ri==GRi&&rj==GRj){
						if(li==GLi&&lj==GLj&&ri==GRi&&rj==GRj){
							res = "Yes"; next.clear(); break;
						}
						continue;
					}
					for(int k=0;k<4;k++){
						int nli = li+m1[k][0], nlj = lj+m1[k][1], nri = ri+m2[k][0], nrj = rj+m2[k][1];
						if(!(0<=nli&&nli<h&&0<=nlj&&nlj<w&&a[nli][nlj]=='.')){
							nli = li; nlj = lj;
						}
						if(!(0<=nri&&nri<h&&0<=nrj&&nrj<w&&b[nri][nrj]=='.')){
							nri = ri; nrj = rj;
						}
						if(!u[nli][nlj][nri][nrj]){
							u[nli][nlj][nri][nrj] = true; next.add(new int[]{nli, nlj, nri, nrj});
						}
					}
				}
				l = next;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2153().run();
	}
}
