package volume01;

import java.util.Scanner;

//Day Count
public class AOJ0125 {

	static class T implements Comparable<T>{
		static int[] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int y,m,d;
		public T(int y, int m, int d) {
			this.y = y;
			this.m = m;
			this.d = d;
		}
		public int compareTo(T o) {
			return y!=o.y?y-o.y:m!=o.m?m-o.m:d-o.d;
		}
		public T n(){
			if(m==12){
				if(d==day[m])return new T(y+1,1,1);
				else return new T(y,m,d+1);
			}
			if(m!=2){
				if(d==day[m])return new T(y,m+1,1);
				else return new T(y,m,d+1);
			}
			if(y%4==0&&(y%100!=0||y%400==0)){
				if(d==29)return new T(y,m+1,1);
				else return new T(y,m,d+1);
			}
			if(d==day[m])return new T(y,m+1,1);
			else return new T(y,m,d+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			T s = new T(sc.nextInt(),sc.nextInt(),sc.nextInt());
			T t = new T(sc.nextInt(),sc.nextInt(),sc.nextInt());
			if(s.y==-1)break;
			int c = 0;
			while(s.compareTo(t)<0){
				c++;
				s = s.n();
			}
			System.out.println(c);
		}
	}
}
