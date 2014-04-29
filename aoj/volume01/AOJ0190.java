package volume01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//Eleven Puzzle
public class AOJ0190 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] adj = {
				{2},
				{2,5},
				{0,1,3,6},
				{2,7},
				{5},
				{1,4,6,9},
				{2,5,7,10},
				{3,6,8,11},
				{7},
				{5,10},
				{6,9,11,12},
				{7,10},
				{10}
		};
		final String g = "0ABCDEFGHIJK0";
		Map<String, Integer> m = new HashMap<String, Integer>();
		List<String> l = new ArrayList<String>();
		int step = 1;
		l.add(g);
		m.put(g, 0);
		while(!l.isEmpty()&&step<=10){
			List<String> next = new ArrayList<String>();
			for(String s:l){
				char[] c = s.toCharArray();
				for(int i=0;i<13;i++){
					if(c[i]=='0'){
						for(int j=0;j<adj[i].length;j++){
							char u = c[adj[i][j]];
							c[adj[i][j]] = '0';
							c[i] = u;
							String n = new String(c);
							if(!m.containsKey(n)){
								m.put(n, step);
								next.add(n);
							}
							c[adj[i][j]] = u;
							c[i] = '0';
						}
					}
				}
			}
			step++;
			l = next;
		}
		while(true){
			int p = sc.nextInt();
			if(p==-1)break;
			char[] cc = new char[13];
			cc[0] = p==0?'0':(char)(p-1+'A');
			for(int i=1;i<13;i++){
				p = sc.nextInt();
				cc[i] = p==0?'0':(char)(p-1+'A');
			}
			String st = new String(cc);
			l = new ArrayList<String>();
			step = 0;
			l.add(st);
			String ans = "NA";
			Set<String> set = new HashSet<String>();
			while(!l.isEmpty()&&step<=10){
				List<String> next = new ArrayList<String>();
				for(String s:l){
					if(m.containsKey(s)){
						ans = (step+m.get(s))+"";
						next.clear();
						break;
					}
					char[] c = s.toCharArray();
					for(int i=0;i<13;i++){
						if(c[i]=='0'){
							for(int j=0;j<adj[i].length;j++){
								char u = c[adj[i][j]];
								c[adj[i][j]] = '0';
								c[i] = u;
								String n = new String(c);
								if(!set.contains(n)){
									set.add(n);
									next.add(n);
								}
								c[adj[i][j]] = u;
								c[i] = '0';
							}
						}
					}
				}
				step++;
				l = next;
			}
			System.out.println(ans);
		}
	}
}
