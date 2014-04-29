package volume11;

import java.util.Scanner;

//Get a Rectangular Field
public class AOJ1114 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			int[][] a = new int[5][5];
			for(int i=0;i<5;i++)for(int j=0;j<5;j++)a[i][j]=sc.nextInt();
			int max = 0;
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					for(int h=i;h<5;h++){
						for(int w=j;w<5;w++){
							boolean f = true;
							for(int n=i;n<=h;n++){
								for(int m=j;m<=w;m++){
									if(a[n][m]==0){
										f = false;break;
									}
								}
							}
							if(f)max = Math.max(max, (h-i+1)*(w-j+1));
						}
					}
				}
			}
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1114().run();
	}
}
