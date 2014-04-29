package volume05;

import java.util.Scanner;

//Who Are The Student Yet To Submit
public class AOJ0511 {

	void run(){
		Scanner sc = new Scanner(System.in);
		boolean[] s = new boolean[31];
		for(int i=0;i<28;i++)s[sc.nextInt()]=true;
		for(int i=1;i<31;i++)if(!s[i])System.out.println(i);
	}

	public static void main(String[] args) {
		new AOJ0511().run();
	}
}
