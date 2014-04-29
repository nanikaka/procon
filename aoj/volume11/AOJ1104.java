package volume11;

import java.util.Scanner;

//Where's Your Robot?
public class AOJ1104 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
		while(true){
			int c = sc.nextInt();
			int r = sc.nextInt();
			if((r|c)==0)break;
			int ri = 1;
			int rj = 1;
			int dir = 0;
			while(true){
				String cmd = sc.next();
				if("STOP".equals(cmd)){
					System.out.println(rj+" "+ri);break;
				}
				if("RIGHT".equals(cmd))dir=(dir+1)%4;
				else if("LEFT".equals(cmd))dir=(dir+3)%4;
				else if("FORWARD".equals(cmd)){
					int k = sc.nextInt();
					while(k--!=0){
						int ni = ri+move[dir][0];
						int nj = rj+move[dir][1];
						if(1<=ni&&ni<=r&&1<=nj&&nj<=c){
							ri = ni;
							rj = nj;
						}
						else break;
					}
				}
				else{
					int k = sc.nextInt();
					while(k--!=0){
						int ni = ri+move[(dir+2)%4][0];
						int nj = rj+move[(dir+2)%4][1];
						if(1<=ni&&ni<=r&&1<=nj&&nj<=c){
							ri = ni;
							rj = nj;
						}
						else break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1104().run();
	}
}
