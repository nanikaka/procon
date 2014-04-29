package volume24;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Kagisys
public class AOJ2440 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Set<String> s = new HashSet<String>();
		while(n--!=0)s.add(sc.next());
		boolean locked = true;
		int m = sc.nextInt();
		while(m--!=0){
			String t = sc.next();
			if(!s.contains(t)){
				System.out.println("Unknown "+t);
			}
			else if(locked){
				System.out.println("Opened by "+t);
				locked = false;
			}
			else{
				locked = true;
				System.out.println("Closed by "+t);
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2440().run();
	}
}
