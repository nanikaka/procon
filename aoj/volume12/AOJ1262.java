package volume12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Atomic Car Race
public class AOJ1262 {

	double[] dist;
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int[] a = new int[n+1];
			for(int i=1;i<=n;i++)a[i]=sc.nextInt();
			double b = sc.nextDouble();
			int r = sc.nextInt();
			double v = sc.nextDouble(), e = sc.nextDouble(), f = sc.nextDouble();
			double[] s = new double[a[n]+1];
			for(int x=0;x<a[n];x++){
				double c = r<=x?(1/(v-e*(x-r))):(1/(v-f*(r-x)));
				s[x+1] = s[x]+c;
			}
			dist = new double[n+1];
			Arrays.fill(dist, 1<<29);
			dist[0] = 0;
			PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return (int) Math.signum(dist[o1]-dist[o2]);
				}
			});
			q.add(0);
			while(!q.isEmpty()){
				int p = q.poll();
				if(p==n){
					System.out.printf("%.4f\n", dist[n]);break;
				}
				for(int k=p+1;k<=n;k++){
					double w = dist[p]+s[a[k]-a[p]]+(p==0?0:b);
					if(w<dist[k]){
						q.remove(k);
						dist[k] = w;
						q.add(k);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1262().run();
	}
}
