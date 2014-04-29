package volume11;

import java.util.Arrays;
import java.util.Scanner;

//Recurring Decimals
public class AOJ1180 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int[] a = new int[21];
			a[0] = sc.nextInt();
			int L = sc.nextInt();
			if((a[0]|L)==0)break;
			for(int i=1;i<=20;i++){
				String s = a[i-1]+"";
				while(s.length()<L)s+="0";
				char[] c = s.toCharArray();
				Arrays.sort(c);
				int min = 0, max = 0;
				for(int j=0;j<L;j++)min=min*10+(c[j]-'0');
				for(int j=L-1;j>=0;j--)max=max*10+(c[j]-'0');
				a[i] = max-min;
				boolean f = false;
				for(int j=i-1;j>=0;j--)if(a[i]==a[j]){
					f = true;
					System.out.println(j+" "+a[i]+" "+(i-j));
					break;
				}
				if(f)break;
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1180().run();
	}
}
