package volume20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Ruins
public class AOJ2030 {

	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		List<Integer>[] l = new List[10001];
		for(int i=1;i<=10000;i++)l[i] = new ArrayList<Integer>();
		for(int i=1;i<=10000;i++)for(int j=1;j*j<=i;j++){
			if(i%j==0)l[i].add(j);
		}
		for(;;){
			int a = sc.nextInt(), b = sc.nextInt();
			if((a|b)==0)break;
			int min = 1<<29;
			int[] t = new int[4];
			for(int p:l[a])for(int q:l[b]){
				t[0]=p; t[1]=a/p; t[2]=q; t[3]=b/q;
				Arrays.sort(t);
				min = Math.min(min, (t[1]-t[0])*(t[1]-t[0])+(t[2]-t[1])*(t[2]-t[1])+(t[3]-t[2])*(t[3]-t[2]));
			}
			System.out.println(min);
		}
	}

	public static void main(String[] args) {
		new AOJ2030().run();
	}
}
