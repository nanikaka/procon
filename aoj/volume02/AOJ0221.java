package volume02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//FizzBuzz
public class AOJ0221 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int m = sc.nextInt();
			int n = sc.nextInt();
			if((m|n)==0)break;
			List<Integer> p = new ArrayList<Integer>();
			for(int i=1;i<=m;i++)p.add(i);
			int k = 1;
			int pos = 0;
			while(n--!=0){
				String s = sc.next();
				if(p.size()==1)continue;
				String c = k+"";
				if(k%15==0)c="FizzBuzz";
				else if(k%5==0)c="Buzz";
				else if(k%3==0)c="Fizz";
				if(c.equals(s))pos=(pos+1)%p.size();
				else {
					p.remove(pos);
					pos %= p.size();
				}
				k++;
			}
			boolean h = true;
			for(int x:p){
				if(!h)System.out.print(" ");
				h = false;
				System.out.print(x);
			}
			System.out.println();
		}
	}
}
