package volume0;

import java.util.Scanner;

//Treasure Hunt
public class AOJ0016 {

	public static class P{
		public double x;
		public double y;
		public P(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = 0;
		double y = 0;
		int a = 0;
		while(true){
			String[] s = sc.next().split(",");
			int l = Integer.parseInt(s[0]);
			int da = Integer.parseInt(s[1]);
			if(l==0&&da==0)break;
			P p = rotate(l, a);
			x += p.x;
			y += p.y;
			if(da<0)da+=360;
			a+=da;
			a%=360;
		}
		System.out.printf("%d\n%d\n", (int)x, (int)y);
	}
	
	public static P rotate(int l, int a){
		double dx = l*Math.sin(a*Math.PI/180.0);
		double dy = l*Math.cos(a*Math.PI/180.0);
		return new P(dx, dy);
	}
}
