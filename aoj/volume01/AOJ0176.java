package volume01;

import java.util.Scanner;

//What Color?
public class AOJ0176 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] c = {"black","blue","lime","aqua","red","fuchsia","yellow","white"};
		int[][] a = {
				{0,0,0},
				{0,0,255},
				{0,255,0},
				{0,255,255},
				{255,0,0},
				{255,0,255},
				{255,255,0},
				{255,255,255}
		};
		while(true){
			String s = sc.next();
			if(s.equals("0"))break;
			int r = Integer.parseInt(s.substring(1,3),16);
			int g = Integer.parseInt(s.substring(3,5),16);
			int b = Integer.parseInt(s.substring(5,7),16);
			double min = Integer.MAX_VALUE;
			int k = 0;
			for(int i=0;i<8;i++){
				double d = Math.sqrt(Math.pow(r-a[i][0], 2)+Math.pow(g-a[i][1], 2)+Math.pow(b-a[i][2], 2));
				if(d < min){
					k=i;
					min = d;
				}
			}
			System.out.println(c[k]);
		}
	}
}
