package volume0;

import java.util.Arrays;
import java.util.Scanner;

//Overlaps of Seals
public class AOJ0090 {

	static class P{
		public double x, y;
		public P(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class R implements Comparable<R>{
		public double minx, maxx, miny, maxy;
		public P[] p;
		public int prob;
		boolean[] mark;
		public R(boolean[] u, double minx, double maxx, double miny, double maxy) {
			this.minx = minx;
			this.maxx = maxx;
			this.miny = miny;
			this.maxy = maxy;
			p = new P[4];
			p[0] = new P(minx, miny);
			p[1] = new P(minx, maxy);
			p[2] = new P(maxx, miny);
			p[3] = new P(maxx, maxy);
			mark = new boolean[n];
			prob = 0;
			for(int i=0;i<n;i++){
				if(u[i]){
					if(minx<=seal[i].x&&seal[i].x<=maxx && miny-1<=seal[i].y&&seal[i].y<=maxy+1){
						mark[i]=true;
						prob++;
					}
					else if(minx-1<=seal[i].x&&seal[i].x<=maxx+1 && miny<=seal[i].y&&seal[i].y<=maxy){
						mark[i]=true;
						prob++;
					}
					else {
						boolean f = false;
						for(int j=0;j<4;j++){
							if(Math.hypot(seal[i].x-p[j].x, seal[i].y-p[j].y)<=1){
								f = true;
								break;
							}
						}
						if(f){
							mark[i] = true;
							prob++;
						}
					}
				}
			}

		}
		public void find(){
			if(prob<=max)return;
			if(maxx-minx<0.000001){
				max = Math.max(max, prob);
				return;
			}
			R[] r = new R[4];
			double midx = (minx+maxx)/2;
			double midy = (miny+maxy)/2;
			r[0] = new R(mark, minx, midx, miny, midy);
			r[1] = new R(mark, midx, maxx, miny, midy);
			r[2] = new R(mark, minx, midx, midy, maxy);
			r[3] = new R(mark, midx, maxx, midy, maxy);
			Arrays.sort(r);
			for(int i=0;i<4;i++)r[i].find();
		}
		public int compareTo(R o) {
			return o.prob-prob;
		}
	}
	
	static int n;
	static int max;
	static P[] seal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0)break;
			seal = new P[n];
			for(int i=0;i<n;i++){
				String[] s = sc.next().split(",");
				seal[i] = new P(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
			}
			boolean[] u = new boolean[n];
			Arrays.fill(u, true);
			max = 0;
			R r = new R(u, 0, 10, 0, 10);
			r.find();
			System.out.println(max);
		}
	}
}
