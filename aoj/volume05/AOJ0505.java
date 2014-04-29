package volume05;

import java.util.Arrays;
import java.util.Scanner;

//Questionnaire
public class AOJ0505 {

	class R implements Comparable<R>{
		int id, s;
		public R(int id) {
			this.id = id;
		}
		public int compareTo(R o) {
			return s==o.s?id-o.id:o.s-s;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			R[] r = new R[m];
			for(int i=0;i<m;i++)r[i]=new R(i);
			for(int i=0;i<n;i++)for(int j=0;j<m;j++)r[j].s+=sc.nextInt();
			Arrays.sort(r);
			for(int i=0;i<m;i++){
				if(i>0)System.out.print(" ");
				System.out.print(r[i].id+1);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new AOJ0505().run();
	}
}
