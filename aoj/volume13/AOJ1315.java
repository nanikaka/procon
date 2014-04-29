package volume13;

import java.util.Scanner;

//Gift from the Goddess of Programming
public class AOJ1315 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int[] s = new int[1000], in = new int[1000];
			boolean[] f = new boolean[1000];
			while(n--!=0){
				sc.next();
				String[] t = sc.next().split(":");
				int time = Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
				boolean I = "I".equals(sc.next());
				int id = sc.nextInt();
				if(I){
					f[id] = true; in[id] = time;
				}
				else{
					f[id] = false;
					if(id==0){
						for(int i=1;i<1000;i++)if(f[i])s[i]+=time-Math.max(in[0], in[i]);
					}
					else if(f[0])s[id]+=time-Math.max(in[0], in[id]);
				}
			}
			int res = 0;
			for(int i=1;i<1000;i++)res=Math.max(res, s[i]);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1315().run();
	}
}
