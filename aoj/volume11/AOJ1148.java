package volume11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Analyzing Login/Logout Records
public class AOJ1148 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			boolean[][] log = new boolean[m+1][1261];
			List<int[]> list = new ArrayList<int[]>();
			int r = sc.nextInt();
			while(r--!=0){
				int t = sc.nextInt();
				int N = sc.nextInt();
				int M = sc.nextInt();
				int s = sc.nextInt();
				if(s==1){
					list.add(new int[]{N, M, t});
				}
				else{
					int st = -1;
					for(int i=0;i<list.size();i++){
						int[] a = list.get(i);
						if(a[0]==N&&a[1]==M){
							st = a[2];
							list.remove(i);
							break;
						}
					}
					for(int i=st;i<t;i++)log[M][i]=true;
				}
			}
			int q = sc.nextInt();
			while(q--!=0){
				int s = 0;
				int ts = sc.nextInt();
				int te = sc.nextInt();
				int M = sc.nextInt();
				for(int i=ts;i<te;i++)if(log[M][i])s++;
				System.out.println(s);
			}
		}
	}
}
