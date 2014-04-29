package volume11;

import java.util.Scanner;

//Unable Count
public class AOJ1105 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if((n|a|b)==0)break;
			boolean[] p = new boolean[n+1];
			p[0] = true;
			int c = 0;
			for(int i=1;i<=n;i++){
				if(i-a>=0&&p[i-a])p[i]=true;
				if(i-b>=0&&p[i-b])p[i]=true;
				if(!p[i])c++;
			}
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1105().run();
	}
}
