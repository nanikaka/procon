package volume20;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

//Everlasting...?
public class AOJ2048 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int N = 1000001;
		boolean[] p = new boolean[N];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		for(int i=2;i<N;i++){
			if(p[i])for(int j=i+i;j<N;j+=i)p[j]=false;

		}
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if((a|b)==0)break;
			SortedSet<Integer> sa = new TreeSet<Integer>();
			SortedSet<Integer> sb = new TreeSet<Integer>();
			int k = 2;
			while(a>1){
				if(p[k]&&a%k==0){
					a/=k;
					sa.add(k);
				}
				else k++;
			}
			k = 2;
			while(b>1){
				if(p[k]&&b%k==0){
					b/=k;
					sb.add(k);
				}
				else k++;
			}
			int pa = sa.last();
			sa.remove(pa);
			int pb = sb.last();
			sb.remove(pb);
			for(int x:sa)pa-=x;
			for(int x:sb)pb-=x;
			System.out.println(pa>pb?"a":"b");
		}
	}

	public static void main(String[] args) {
		new AOJ2048().run();
	}
}
