package volume23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//My friends are small
public class AOJ2333 {

	int n, W, MOD = 1000000007;
	int[] w;
	Map<Integer, Integer>[][] mem;
	
	int get(int k, int rest, int min){
		if(rest<0)return 0;
		if(k<0)return rest<min?1:0;
		if(mem[k][rest].containsKey(min))return mem[k][rest].get(min);
		int res = (get(k-1, rest, w[k])+get(k-1, rest-w[k], min))%MOD;
		mem[k][rest].put(min, res);
		return res;
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); W = sc.nextInt();
		w = new int[n];
		for(int i=0;i<n;i++)w[i]=sc.nextInt();
		Arrays.sort(w);
		mem = new Map[n][W+1];
		for(int i=0;i<n;i++)for(int j=0;j<=W;j++)mem[i][j]=new HashMap<Integer, Integer>();
		System.out.println(get(n-1, W, 1<<29));
	}
	
	public static void main(String[] args) {
		new AOJ2333().run();
	}
}
