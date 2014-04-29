package volume01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Bus Line
public class AOJ0140 {

	static class T{
		int p;
		boolean up;
		String s;
		public T(int p, String s, boolean d) {
			this.p = p;
			this.up = d;
			this.s = s;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--!=0){
			int s = sc.nextInt();
			int g = sc.nextInt();
			List<T> l = new ArrayList<T>();
			l.add(new T(s,s+"",true));
			l.add(new T(s,s+"",false));
			boolean[][] u = new boolean[10][2];
			u[s][0] = u[s][1] = true;
			while(!l.isEmpty()){
				List<T> next = new ArrayList<T>();
				for(T w:l){
					if(w.p==g){
						next.clear();
						System.out.println(w.s);
						break;
					}
					if(w.up){
						if(w.p==9){
							if(!u[5][1]){
								u[5][1] = true;
								next.add(new T(5,w.s+" "+5,false));
							}
						}
						else if(!u[w.p+1][0]){
							u[w.p+1][0] = true;
							next.add(new T(w.p+1, w.s+" "+(w.p+1),true));
						}
					}
					else{
						if(w.p==0){
							if(!u[1][0]){
								u[1][0] = true;
								next.add(new T(1,w.s+" 1",true));
							}
						}
						else{
							if(w.p>=6)continue;
							if(!u[w.p-1][1]){
								u[w.p-1][1] = true;
								next.add(new T(w.p-1,w.s+" "+(w.p-1),false));
							}
						}
					}
				}
				l = next;
			}
		}
	}
}
