package volume01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Seven Puzzle
public class AOJ0121 {

	static int[] pow = {1,10,100,1000,10000,100000,1000000,10000000};

	static int swap(int x, int k){
		int pos = 0;
		while((x/pow[pos])%10>0){
			pos++;
		}
		int tp = 0;
		if(k==0){
			if(pos+4>7)return 0;
			tp = pos+4;
		}
		else if(k==1){
			if((pos+1)%4==0)return 0;
			tp = pos+1;
		}
		else if(k==2){
			if(pos-4<0)return 0;
			tp = pos-4;
		}
		else if(k==3){
			if(pos%4==0)return 0;
			tp = pos-1;
		}
		int d = x/pow[tp]%10;
		return x - d*pow[tp] + d*pow[pos];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		List<Integer> l = new ArrayList<Integer>();
		l.add(1234567);
		m.put(1234567, 0);
		int step = 1;
		while(!l.isEmpty()){
			List<Integer> next = new ArrayList<Integer>();
			for(int a:l){
				for(int k=0;k<4;k++){
					int n = swap(a, k);
					if(n!=0 && !m.containsKey(n)){
						m.put(n, step);
						next.add(n);
					}
				}
			}
			step++;
			l = next;
		}
		while(sc.hasNext()){
			int x = 0;
			for(int i=0;i<8;i++){
				x*=10;
				x+=sc.nextInt();
			}
			System.out.println(m.get(x));
		}
	}
}
