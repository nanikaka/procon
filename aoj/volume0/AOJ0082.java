package volume0;

import java.util.Scanner;

//Flying Jenny
public class AOJ0082 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] c = {4,1,4,1,2,1,2,1};
		while(sc.hasNext()){
			int[] a = new int[8];
			for(int i=0;i<8;i++)a[i]=sc.nextInt();
			int min = Integer.MAX_VALUE;
			String v = "";
			for(int top=0;top<8;top++){
				int r = 0;
				String m = "";
				for(int j=0;j<8;j++){
					r += Math.max(0, a[j]-c[(top+j)%8]);
					m += c[(top+j)%8];
				}
				if(r<min){
					min = r;
					v = m;
				}
				else if(r==min&&m.compareTo(v)<0)v = m;
			}
			System.out.print(v.charAt(0));
			for(int i=1;i<8;i++)System.out.print(" "+v.charAt(i));
			System.out.println();
		}
	}
}
