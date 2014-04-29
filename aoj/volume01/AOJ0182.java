package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Beaker
public class AOJ0182 {

	int n;
	int[] a;
	boolean[] have, t;
	
	boolean dfs(int k, int rest){
		if(rest==0){
			for(int i=0;i<n;i++)t[i]=have[i];
			return greedy();
		}
		if(rest < a[k])return false;
		have[k] = true;
		if(dfs(k+1, rest-a[k]))return true;
		have[k] = false;
		return dfs(k+1, rest);
	}
	
	boolean choice(int k, int rest){
		if(rest==0)return true;
		if(k<0)return false;
		if(!t[k])return choice(k-1, rest);
		if(a[k]<=rest){
			t[k] = false;
			if(choice(k-1, rest-a[k]))return true;
			t[k] = true;
		}
		return choice(k-1, rest);
	}
	
	boolean greedy(){
		for(int i=0;i<n;i++)if(!t[i]){
			if(!choice(i-1, a[i]))return false;
			t[i] = true;
		}
		return true;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		t = new boolean[100];
		have = new boolean[100];
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			Arrays.fill(have, false);
			have[0] = true;
			System.out.println(dfs(1, a[n-1]-a[0])?"YES":"NO");
		}
	}
	
	public static void main(String[] args) {
		new AOJ0182().run();
	}
}
