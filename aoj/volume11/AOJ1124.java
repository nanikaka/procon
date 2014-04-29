package volume11;

import java.util.Scanner;

//When Can We Meet?
public class AOJ1124 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			int q = sc.nextInt();
			if((n|q)==0)break;
			int[] c = new int[101];
			while(n--!=0){
				int m = sc.nextInt();
				while(m--!=0)c[sc.nextInt()]++;
			}
			int a = 0;
			for(int i=1;i<=100;i++){
				if(c[i]<q)continue;
				if(c[a]<c[i])a=i;
			}
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1124().run();
	}
}
