package volume0;

import java.util.Scanner;
import java.util.Stack;

//Strange Mathematical Expression
public class AOJ0087 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String[] s = sc.nextLine().split(" ");
			Stack<Double> u = new Stack<Double>();
			for(String v:s){
				if(v.equals("+")){
					double b = u.pop();
					double a = u.pop();
					u.push(a+b);
				}
				else if(v.equals("-")){
					double b = u.pop();
					double a = u.pop();
					u.push(a-b);
				}
				else if(v.equals("*")){
					double b = u.pop();
					double a = u.pop();
					u.push(a*b);
				}
				else if(v.equals("/")){
					double b = u.pop();
					double a = u.pop();
					u.push(a/b);
				}
				else u.push(Double.parseDouble(v));
			}
			System.out.println(u.pop());
		}
	}
}
