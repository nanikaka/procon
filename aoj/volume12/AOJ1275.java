package volume12;

import java.util.LinkedList;
import java.util.Scanner;

//And Then There Was One
public class AOJ1275 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), k = sc.nextInt(), m = sc.nextInt();
			if((n|k|m)==0)break;
			LinkedList<Integer> l = new LinkedList<Integer>();
			for(int i=0;i<n;i++)l.add(i);
			int p = m-1;
			l.remove(p);
			while(l.size()>1){
				p = (p+k-1)%l.size();
				l.remove(p);
			}
			System.out.println(l.get(0)+1);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1275().run();
	}
}
