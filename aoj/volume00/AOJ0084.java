package volume0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Search Engine
public class AOJ0084 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> w = new ArrayList<String>();
		String[] s = sc.nextLine().replace(",", " ").replace("."," ").split(" ");
		for(String e:s)if(3<=e.length()&&e.length()<=6)w.add(e);
		boolean f = true;
		for(String e:w){
			if(!f)System.out.print(" ");
			System.out.print(e);
			f = false;
		}
		System.out.println();
	}
}
