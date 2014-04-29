package volume11;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Organize Your Train part II
public class AOJ1142 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			String s = sc.next();
			Set<String> set = new HashSet<String>();
			for(int i=1;i<=s.length();i++){
				String s1 = s.substring(0, i);
				String s2 = s.substring(i, s.length());
				String r1 = (new StringBuffer(s1)).reverse().toString();
				String r2 = (new StringBuffer(s2)).reverse().toString();
				set.add(s1+s2);
				set.add(s1+r2);
				set.add(s2+s1);
				set.add(r2+s1);
				set.add(r1+s2);
				set.add(r1+r2);
				set.add(s2+r1);
				set.add(r2+r1);
			}
			System.out.println(set.size());
		}
	}
}
