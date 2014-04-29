package volume10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Citation Format
public class AOJ1051 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int s = a[0];
			int t = a[0];
			Queue<String> l = new LinkedList<String>();
			for(int i=1;i<n;i++){
				if(t+1==a[i])t++;
				else {
					if(s<t)l.add(s+"-"+t);
					else l.add(s+"");
					s = a[i];
					t = a[i];
				}
			}
			if(s<t)l.add(s+"-"+t);
			else l.add(s+"");
			boolean f = true;
			while(!l.isEmpty()){
				if(!f)System.out.print(" ");
				f = false;
				System.out.print(l.poll());
			}
			System.out.println();
		}
	}
}
