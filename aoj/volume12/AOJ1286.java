package volume12;

import java.util.Scanner;

//Expected Allowance
public class AOJ1286 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			if((n|m|k)==0)break;
			int[] v = new int[n*m+1];
			for(int i=1;i<=m;i++)v[i]=1;
			for(int i=2;i<=n;i++){
				int[] nv = new int[n*m+1];
				for(int j=1;j<=n*m;j++){
					if(v[j]==0)continue;
					for(int d=1;d<=m;d++){
						if(j+d<=n*m)nv[j+d]+=v[j];
					}
				}
				v = nv;
			}
			double ex = 0;
			int[] c = new int[n*m+1-k];
			for(int i=1;i<=n*m;i++){
				if(i-k<=0)c[1]+=v[i];
				else c[i-k]+=v[i];
			}
			int div = (int)Math.pow(m, n);
			for(int i=1;i<c.length;i++){
				ex += c[i]*1.0/div*i;
			}
			System.out.printf("%.8f\n", ex);
		}
	}
}
