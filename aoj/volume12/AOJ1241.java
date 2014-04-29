package volume12;

import java.util.Scanner;

//Lagrange's Four-Square Theorem
public class AOJ1241 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int c = 0;
			for(int i=0;i<=n;i++){
				if(n<i*i)break;
				for(int j=i;j<=n;j++){
					if(n<i*i+j*j)break;
					for(int k=j;k<=n;k++){
						if(n<i*i+j*j+k*k)break;
						for(int l=k;l<=n;l++){
							if(n<i*i+j*j+k*k+l*l)break;
							c+=i*i+j*j+k*k+l*l==n?1:0;
						}
					}
				}
			}
			System.out.println(c);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1241().run();
	}
}
