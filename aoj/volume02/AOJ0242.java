package volume02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Input Candidates
public class AOJ0242 {

	Map<String, Integer>[] ref;
	int f;
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			sc.nextLine();
			ref = new Map[26];
			for(int i=0;i<26;i++)ref[i]=new HashMap<String, Integer>();
			while(n--!=0){
				for(String s:sc.nextLine().split(" ")){
					int x = s.charAt(0)-'a';
					if(ref[x].containsKey(s)){
						int z = ref[x].get(s)+1;
						ref[x].put(s, z);
					}
					else ref[x].put(s, 1);
				}
			}
			f = sc.next().charAt(0)-'a';
			PriorityQueue<String> q = new PriorityQueue<String>(5, new Comparator<String>() {
				public int compare(String o1, String o2) {
					return ref[f].get(o1)!=ref[f].get(o2)?ref[f].get(o2)-ref[f].get(o1):o1.compareTo(o2);
				}
			});
			for(String s:ref[f].keySet())q.add(s);
			if(q.isEmpty())System.out.println("NA");
			else {
				int t = Math.min(5, q.size());
				for(int i=0;i<t;i++)System.out.print(q.poll()+(i==t-1?"\n":" "));
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ0242().run();
	}
}
