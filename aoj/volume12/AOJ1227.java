package volume12;

import java.util.Scanner;

//77377
public class AOJ1227 {

	int[] ref = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
	int n;
	String[] w, rep;
	String s;
	
	void dfs(int i, String r){
		if(i==s.length()){
			System.out.println(r.substring(1)+"."); return;
		}
		String sub = s.substring(i);
		for(int j=0;j<n;j++){
			if(!sub.startsWith(rep[j]))continue;
			dfs(i+rep[j].length(), r+" "+w[j]);
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			w = new String[n]; rep = new String[n];
			for(int i=0;i<n;i++){
				w[i] = sc.next();
				String res = "";
				for(int j=0;j<w[i].length();j++)res+=ref[w[i].charAt(j)-'a'];
				rep[i] = res;
			}
			s = sc.next();
			dfs(0, "");
			System.out.println("--");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1227().run();
	}
}
