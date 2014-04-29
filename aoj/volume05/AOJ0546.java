package volume05;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Lining up the cards
public class AOJ0546 {

	int n, K;
	int[] a;
	boolean[] u;
	Set<String> s;
	
	void f(int k, String t){
		if(k==K){
			s.add(t);return;
		}
		for(int i=0;i<n;i++){
			if(u[i])continue;
			u[i] = true;
			f(k+1, t+a[i]);
			u[i] = false;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			K = sc.nextInt();
			if((n|K)==0)break;
			a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			u = new boolean[n];
			s = new HashSet<String>();
			f(0,"");
			System.out.println(s.size());
		}
	}
	
	public static void main(String[] args) {
		new AOJ0546().run();
	}
}
