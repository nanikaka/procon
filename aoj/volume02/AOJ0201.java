package volume02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Wrought Gold Master
public class AOJ0201 {

	public static int[] price;
	public static int[] opt;
	public static Map<String, Integer> ref;
	public static int[][] list;

	public static int get(int k){
		if(opt[k]!=Integer.MAX_VALUE){
			return opt[k];
		}
		if(list[k].length==0){
			return opt[k] = price[k];
		}
		int p = 0;
		for(int i=0;i<list[k].length;i++){
			p += get(list[k][i]);
		}
		return opt[k] = Math.min(p, price[k]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			price = new int[300];
			opt = new int[300];
			list = new int[300][0];
			Arrays.fill(opt, Integer.MAX_VALUE);
			int id = 0;
			ref = new HashMap<String, Integer>();
			for(int i=0;i<n;i++){
				ref.put(sc.next(), id);
				price[id++] = sc.nextInt();
			}
			int m = sc.nextInt();
			while(m--!=0){
				String s = sc.next();
				if(!ref.containsKey(s)){
					ref.put(s, id++);
				}
				int i = ref.get(s);
				int k = sc.nextInt();
				list[i] = new int[k];
				for(int j=0;j<k;j++){
					s = sc.next();
					if(!ref.containsKey(s)){
						ref.put(s, id++);
					}
					list[i][j] = ref.get(s);
				}
			}
			System.out.println(get(ref.get(sc.next())));
		}
	}
}
