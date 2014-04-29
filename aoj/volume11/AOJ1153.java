package volume11;

import java.util.Scanner;

//Equal Total Scores
public class AOJ1153 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			int[] t = new int[n];
			int[] h = new int[m];
			int st = 0;
			int sh = 0;
			for(int i=0;i<n;i++){
				t[i] = sc.nextInt();
				st += t[i];
			}
			for(int i=0;i<m;i++){
				h[i] = sc.nextInt();
				sh += h[i];
			}
			int ct = -1;
			int ch = -1;
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(st-t[i]+h[j] == sh-h[j]+t[i]){
						if(ct==-1){
							ct = t[i];
							ch = h[j];
						}
						else if(t[i]+h[j] < ct + ch){
							ct = t[i];
							ch = h[j];
						}
					}
				}
			}
			System.out.println(ct==-1?ct:ct+" "+ch);
		}
	}
}
