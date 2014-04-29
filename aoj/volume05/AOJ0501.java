package volume05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Data Conversion
public class AOJ0501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			Map<String, String> map = new HashMap<String, String>();
			while(n--!=0){
				map.put(sc.next(), sc.next());
			}
			int m = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			while(m--!=0){
				String s = sc.next();
				if(map.containsKey(s))sb.append(map.get(s));
				else sb.append(s);
			}
			System.out.println(sb.toString());
		}
	}
}
