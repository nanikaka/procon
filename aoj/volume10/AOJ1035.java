package volume10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//Sleeping Cats
public class AOJ1035 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int w = sc.nextInt();
			int q = sc.nextInt();
			if(w==0&&q==0)break;
			boolean[] wall = new boolean[w];
			Map<Integer, Integer> cat = new HashMap<Integer, Integer>();
			Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
			while(q--!=0){
				char cmd = sc.next().charAt(0);
				if(cmd=='s'){
					int id = sc.nextInt();
					int need = sc.nextInt();
					int p = 0;
					boolean f = false;
					while(p<w){
						if(wall[p]){
							p++;
							continue;
						}
						int dt = 0;
						int pp = p;
						while(p < w && !wall[p]){
							p++;
							dt++;
							if(dt==need){
								cat.put(id, need);
								pos.put(id, pp);
								System.out.println(pp);
								for(int i=pp;i<pp+need;i++)wall[i]=true;
								f = true;
								break;
							}
						}
						if(f)break;
					}
					if(!f)System.out.println("impossible");
				}
				else{
					int id = sc.nextInt();
					int p = pos.get(id);
					int need = cat.get(id);
					for(int i=p;i<p+need;i++)wall[i] = false;
				}
			}
			System.out.println("END");
		}
	}
}
