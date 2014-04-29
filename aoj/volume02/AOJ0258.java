package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Kitchen Garden
public class AOJ0258 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int[] a = new int[n+1];
			for(int i=0;i<=n;i++)a[i]=sc.nextInt();
			for(int i=0;i<=n;i++){
				boolean f = true;
				int d = i==0?a[2]-a[1]:i==1?a[2]-a[0]:a[1]-a[0];
				int pre = i==0?a[1]:a[0];
				for(int j=i==0?2:i==1?2:1;j<=n&&f;j++){
					if(j==i)continue;
					f&=pre+d==a[j];
					pre = a[j];
				}
				if(f){
					System.out.println(a[i]); break;
				}
			}
		}
	}

	void debug(Object...o){
		System.out.println(Arrays.deepToString(o));
	}

	public static void main(String[] args) {
		new AOJ0258().run();
	}
}
