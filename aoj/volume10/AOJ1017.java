package volume10;

import java.util.LinkedList;
import java.util.Scanner;

//Riffle Shuffle
public class AOJ1017 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int r = sc.nextInt();
			LinkedList<Integer> l = new LinkedList<Integer>();
			for(int i=0;i<n;i++)l.add(i);
			while(r--!=0){
				int k = sc.nextInt();
				LinkedList<Integer> b = new LinkedList<Integer>();
				LinkedList<Integer> c = new LinkedList<Integer>();
				for(int i=0;i<n/2;i++)b.add(l.removeFirst());
				while(!l.isEmpty()||!b.isEmpty()){
					for(int j=0;j<k;j++){
						if(l.isEmpty())break;
						c.add(l.removeFirst());
					}
					for(int j=0;j<k;j++){
						if(b.isEmpty())break;
						c.add(b.removeFirst());
					}
				}
				l = c;
			}
			System.out.println(l.getLast());
		}
	}
	
	public static void main(String[] args) {
		new AOJ1017().run();
	}
}
