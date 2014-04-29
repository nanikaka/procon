package volume0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Rank Checker
public class AOJ0061 {

	static class T implements Comparable<T>{
		public int id;
		public int s;
		public T(int id, int s) {
			this.id = id;
			this.s = s;
		}
		public int compareTo(T o) {
			return o.s-s;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<T> l = new ArrayList<T>();
		while(true){
			String[] s = sc.next().split(",");
			int id = Integer.parseInt(s[0]);
			int solve = Integer.parseInt(s[1]);
			if((id|solve)==0)break;
			l.add(new T(id,solve));
		}
		Collections.sort(l);
		while(sc.hasNext()){
			int q = sc.nextInt();
			int r = 0;
			int pre = -1;
			for(int i=0;i<l.size();i++){
				T t = l.get(i);
				if(pre!=t.s)r++;
				pre = t.s;
				if(t.id==q){
					System.out.println(r);
					break;
				}
			}
		}
	}
}
