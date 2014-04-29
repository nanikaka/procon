package volume12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//e-market
public class AOJ1225 {
	
	class D implements Comparable<D>{
		String name;
		int gain, pay;
		public D(String name) {
			this.name = name;
		}
		public int compareTo(D o) {
			return name.compareTo(o.name);
		}
	}
	
	class R{
		char ch;
		int p;
		D dealer;
		public R(char ch, int p, D dealer) {
			super();
			this.ch = ch;
			this.p = p;
			this.dealer = dealer;
		}
	}
	
	Map<String, D> ref;
	
	D get(String name){
		if(ref.containsKey(name))return ref.get(name);
		D d = new D(name);
		ref.put(name, d);
		return d;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			ref = new HashMap<String, D>();
			int[] min = new int[26], max = new int[26], sum = new int[26], num = new int[26];
			Arrays.fill(min, 1<<29);
			List<R> buy = new ArrayList<R>();
			List<R> sell = new ArrayList<R>();
			while(n--!=0){
				String name = sc.next();
				String cmd = sc.next();
				char ch = sc.next().charAt(0);
				int p = sc.nextInt();
				if("BUY".equals(cmd)){
					int k = -1, m = 1<<29;
					for(int i=0;i<sell.size();i++){
						R r = sell.get(i);
						if(!name.equals(r.dealer.name)&&ch==r.ch&&r.p<=p&&r.p<m){
							k = i; m = r.p;
						}
					}
					if(k==-1)buy.add(new R(ch, p, get(name)));
					else {
						R r = sell.remove(k);
						int x = r.ch-'A';
						int z = (p+r.p)/2;
						min[x] = Math.min(min[x], z); max[x] = Math.max(max[x], z); sum[x]+=z; num[x]++;
						get(name).pay+=z;
						r.dealer.gain+=z;
					}
				}
				else{
					int k = -1, m = 0;
					for(int i=0;i<buy.size();i++){
						R r = buy.get(i);
						if(!name.equals(r.dealer.name)&&ch==r.ch&&p<=r.p&&m<r.p){
							k = i; m = r.p;
						}
					}
					if(k==-1)sell.add(new R(ch, p, get(name)));
					else{
						R r = buy.remove(k);
						int x = r.ch-'A';
						int z = (p+r.p)/2;
						min[x] = Math.min(min[x], z); max[x] = Math.max(max[x], z); sum[x]+=z; num[x]++;
						get(name).gain+=z;
						r.dealer.pay+=z;
					}
				}
			}
			for(int i=0;i<26;i++){
				if(num[i]==0)continue;
				System.out.println((char)(i+'A')+" "+min[i]+" "+(sum[i]/num[i])+" "+max[i]);
			}
			System.out.println("--");
			PriorityQueue<D> q = new PriorityQueue<D>();
			for(String name:ref.keySet())q.add(ref.get(name));
			while(!q.isEmpty()){
				D d = q.poll();
				System.out.println(d.name+" "+d.pay+" "+d.gain);
			}
			System.out.println("----------");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1225().run();
	}
}
