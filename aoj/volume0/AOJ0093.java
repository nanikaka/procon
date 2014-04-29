package volume0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Leap Year
public class AOJ0093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean f = true;
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if((a|b)==0)break;
			if(!f)System.out.println();
			f = false;
			List<Integer> l = new ArrayList<Integer>();
			for(int i=a;i<=b;i++){
				if(i%4==0&&(i%100!=0||i%400==0))l.add(i);
			}
			if(l.isEmpty())System.out.println("NA");
			else for(int i:l)System.out.println(i);
		}
	}
}
