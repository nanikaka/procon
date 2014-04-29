package volume01;

import java.util.PriorityQueue;
import java.util.Scanner;

//Bowling
public class AOJ0152 {

	static class T implements Comparable<T>{
		int id;
		int s;
		public T(int id, int s) {
			this.id = id;
			this.s = s;
		}
		public int compareTo(T o) {
			return s==o.s?id-o.id:o.s-s;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			PriorityQueue<T> q = new PriorityQueue<T>();
			while(n--!=0){
				int[][] p = new int[10][3];
				int x = sc.nextInt();
				boolean[] strike = new boolean[9];
				boolean[] spare = new boolean[9];
				int f = 0;
				while(f<10){
					int pin = sc.nextInt();
					p[f][0] = pin;
					if(pin==10){
						if(f<9){
							strike[f++] = true;
							continue;
						}
					}
					pin = sc.nextInt();
					p[f][1] = pin;
					if(f<9&&p[f][0]+p[f][1]==10){
						spare[f] = true;
					}
					else if(p[f][0]+p[f][1]>=10){
						p[f][2]=sc.nextInt();
					}
					f++;
				}
				int sum = 0;
				for(int i=0;i<9;i++){
					sum += p[i][0] + p[i][1];
					if(strike[i]){
						sum += p[i+1][0];
						int d = p[i+1][0];
						if(i+1<9 && d==10)sum+=p[i+2][0];
						else sum+=p[i+1][1];
					}
					else if(spare[i]){
						sum += p[i+1][0];
					}
				}
				sum += p[9][0]+p[9][1]+p[9][2];
				q.add(new T(x,sum));
			}
			while(!q.isEmpty()){
				T t = q.poll();
				System.out.println(t.id+" "+t.s);
			}
		}
	}
}
