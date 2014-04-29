package volume11;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//Monday-Saturday Prime Factors
public class AOJ1154 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] msf = new int[85713];
		int id = 0;
		msf[id++] = 6;
		for(int i=7;i<300000;i+=7){
			if(i+1<300000){
				msf[id++] = i+1;
			}
			if(i+6<300000){
				msf[id++] = i+6;
			}
		}
		boolean[] mspf = new boolean[300000];
		Arrays.fill(mspf, true);
		for(int i=0;i<85713;i++){
			int x = msf[i];
			if(mspf[x]){
				for(int j=2*x;j<300000;j+=x){
					mspf[j] = false;
				}
			}
		}
		while(true){
			int x = sc.nextInt();
			if(x==1)break;
			System.out.print(x + ":");
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for(int i=0;i<85713;i++){
				if(x < msf[i])break;
				if(mspf[msf[i]] && x%msf[i]==0){
					if(!q.contains(msf[i]))q.add(msf[i]);
				}
			}
			while(!q.isEmpty())System.out.print(" " + q.poll());
			System.out.println();
		}
	}
}
