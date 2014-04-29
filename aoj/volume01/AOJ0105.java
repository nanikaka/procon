package volume01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Book Index
public class AOJ0105 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, List<Integer>> ref = new HashMap<String, List<Integer>>();
		PriorityQueue<String> q = new PriorityQueue<String>();
		while(sc.hasNext()){
			String s = sc.next();
			if(ref.containsKey(s)){
				ref.get(s).add(sc.nextInt());
			}
			else{
				q.add(s);
				List<Integer> list = new ArrayList<Integer>();
				list.add(sc.nextInt());
				ref.put(s, list);
			}
		}
		while(!q.isEmpty()){
			String s = q.poll();
			List<Integer> list = ref.get(s);
			System.out.println(s);
			Collections.sort(list);
			boolean f = true;
			for(int v:list){
				if(!f)System.out.print(" ");
				f = false;
				System.out.print(v);
			}
			System.out.println();
		}
	}
}
