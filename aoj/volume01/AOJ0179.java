package volume01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Mysterious Worm
public class AOJ0179 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String s = sc.next();
			if(s.equals("0"))break;
			int n = s.length();
			Set<String> set = new HashSet<String>();
			set.add(s);
			int step = 0;
			boolean ans = false;
			List<String> l = new ArrayList<String>();
			l.add(s);
			while(!l.isEmpty()){
				List<String> next = new ArrayList<String>();
				for(String u:l){
					char[] c = u.toCharArray();
					char ch = c[0];
					boolean f = true;
					for(int i=1;i<n;i++){
						if(c[i]!=ch){
							f = false;break;
						}
					}
					if(f){
						ans = true;
						next.clear();
						break;
					}
					for(int i=0;i<n-1;i++){
						if(c[i]!=c[i+1]){
							char a = c[i];
							char b = c[i+1];
							char v = a!='r'&&b!='r'?'r':a!='g'&&b!='g'?'g':'b';
							c[i] = c[i+1] = v;
							String st = new String(c);
							if(!set.contains(st)){
								set.add(st);
								next.add(st);
							}
							c[i] = a;
							c[i+1] = b;
						}
					}
				}
				step++;
				l = next;
			}
			System.out.println(ans?--step:"NA");
		}
	}
}
