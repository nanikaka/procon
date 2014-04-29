package volume0;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//List of Top 3 Hills
public class AOJ0001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(int i=0;i<10;i++)q.add(sc.nextInt());
		for(int i=0;i<3;i++)System.out.println(q.poll());
	}
}
