package volume11;

import java.util.Scanner;

//Next Mayor
public class AOJ1159 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int p = sc.nextInt();
			if((n|p)==0)break;
			int w = p;
			int[] s = new int[n];
			int k=0;
			int ans = -1;
			while(true){
				if(w > 0){
					s[k]++;
					w--;
				}
				else{
					w += s[k];
					s[k] = 0;
				}
				if(s[k]==p){
					ans = k;
					break;
				}
				k = (k+1)%n;
			}
			System.out.println(ans);
		}
	}
}
