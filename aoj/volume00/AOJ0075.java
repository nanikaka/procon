package volume0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//BMI
public class AOJ0075 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> l = new ArrayList<Integer>();
		while(sc.hasNext()){
			String[] s = sc.next().split(",");
			double w = Double.parseDouble(s[1]);
			double h = Double.parseDouble(s[2]);
			if(w/(h*h)>=25)l.add(Integer.parseInt(s[0]));
		}
		if(l.isEmpty())System.out.println("該当なし");
		else for(Integer i:l)System.out.println(i);
	}
}
