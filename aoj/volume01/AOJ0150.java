package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Twin Prime
public class AOJ0150 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] p = new boolean[10001];
		Arrays.fill(p, true);
		p[0]=p[1]=true;
		for(int i=2;i<10001;i++)if(p[i])for(int j=2*i;j<10001;j+=i)p[j]=false;
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			for(int i=n;i>=5;i--)if(p[i]&&p[i-2]){System.out.println((i-2)+" "+i);break;}
		}
	}
}
