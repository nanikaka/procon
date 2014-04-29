package volume01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Fukushimaken
public class AOJ0147 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] c = new int[17];
		int[] p = new int[100];
		int[] w = new int[100];
		int[] sit = new int[100];
		for(int i=0;i<100;i++){
			p[i] = i%5==1?5:2;
			w[i] = 17*(i%2)+3*(i%3)+19;
		}
		int i = 0;
		int t = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean end = false;
		while(!end){
			if(t==i*5&&i<100){
				q.add(i++);
			}
			for(int k=0;k<17;k++)c[k]=Math.max(0, c[k]-1);
			boolean con = true;
			while(!q.isEmpty()&&con){
				con = false;
				int id = q.peek();
				for(int j=0;j+p[id]-1<17;j++){
					boolean e = true;
					for(int k=0;k<p[id];k++){
						if(c[j+k]!=0){
							e = false;break;
						}
					}
					if(e){
						q.poll();
						for(int k=j;k<j+p[id];k++)c[k]=w[id];
						sit[id] = t;
						if(id==99)end = true;
						con = true;
						break;
					}
				}
			}
			t++;
		}
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(sit[n]-5*n);
		}
	}
}
