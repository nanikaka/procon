package volume0;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//English Sentences
public class AOJ0029 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> m = new HashMap<String, Integer>();
		int mc = 0;
		String fre = "";
		String max = "";
		while(sc.hasNext()){
			String s = sc.next();
			if(max.length() < s.length())max = s;
			if(m.containsKey(s)){
				int c = m.get(s);
				if(mc < c+1){
					mc = c+1;
					fre = s;
				}
				m.put(s, c+1);
			}
			else{
				if(mc < 1){
					mc = 1;
					fre = s;
				}
				m.put(s, 1);
			}
		}
		System.out.println(fre + " " + max);
	}
}
