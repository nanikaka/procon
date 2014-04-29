package volume12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Organize Your Train
public class AOJ1260 {

	boolean[][] adj;
	int x, y;
	Map<String, Integer> ref, ref2;

	int trans(char[] s){
		int res = s[0]-'0';
		if(s[1]=='E')res+=x;
		return res;
	}

	String get(String[] s){
		String res = "";
		for(int i=0;i<x;i++)res+=s[i]+",";
		return res;
	}

	void reg(Map<String, Integer> m, String s, List<String> l, int step){
		if(m.containsKey(s))return;
		m.put(s, step);
		l.add(s);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			x = sc.nextInt(); y = sc.nextInt();
			if((x|y)==0)break;
			adj = new boolean[2*x][2*x];
			while(y--!=0){
				int s = trans(sc.next().toCharArray()), t = trans(sc.next().toCharArray());
				adj[s][t] = adj[t][s] = true;
			}
			String start = "";
			for(int i=0;i<x;i++){
				String s = sc.next();
				start+=s+",";
			}
			String goal = "";
			for(int i=0;i<x;i++){
				String s = sc.next();
				goal+=s+",";
			}
			ref = new HashMap<String, Integer>(); ref2 = new HashMap<String, Integer>();
			List<String> list = new ArrayList<String>();
			ref.put(start, 0);
			list.add(start);
			int step = 1;
			while(!list.isEmpty()&&step<=3){
				List<String> next = new ArrayList<String>();
				for(String v:list){
					String[] s = v.split(",");
					for(int i=0;i<x;i++){
						if("-".equals(s[i]))continue;
						String pre = s[i];
						for(int j=0;j<=s[i].length();j++){
							String former = s[i].substring(0, j);
							String later = s[i].substring(j);
							StringBuffer sb = new StringBuffer(former);
							String frev = sb.reverse().toString();
							sb = new StringBuffer(later);
							String lrev = sb.reverse().toString();
							//move former
							if(former.length()>0){
								for(int k=0;k<2*x;k++){
									if(!adj[i][k])continue;
									s[i] = later.length()>0?later:"-";
									if(k<x){
										String preK = s[k];
										s[k] = "-".equals(s[k])?frev:(frev+s[k]);
										String res = get(s);
										reg(ref, res, next, step);
										s[k] = preK;
									}
									else{
										String preK = s[k-x];
										s[k-x] = "-".equals(s[k-x])?former:(s[k-x]+former);
										String res = get(s);
										reg(ref, res, next, step);
										s[k-x] = preK;
									}
								}
							}
							//move later
							if(later.length()>0){
								for(int k=0;k<2*x;k++){
									if(!adj[i+x][k])continue;
									s[i] = former.length()>0?former:"-";
									if(k<x){
										String preK = s[k];
										s[k] = "-".equals(s[k])?later:(later+s[k]);
										String res = get(s);
										reg(ref, res, next, step);
										s[k] = preK;
									}
									else{
										String preK = s[k-x];
										s[k-x] = "-".equals(s[k-x])?lrev:(s[k-x]+lrev);
										String res = get(s);
										reg(ref, res, next, step);
										s[k-x] = preK;
									}
								}
							}
							s[i] = pre;
						}
					}
				}
				step++;
				list = next;
			}
			step = 1;
			ref2.put(goal, 0);
			list = new ArrayList<String>();
			list.add(goal);
			int min = 6;
			while(!list.isEmpty()&&step<=3){
				List<String> next = new ArrayList<String>();
				for(String v:list){
					if(ref.containsKey(v)){
						min = Math.min(min, ref.get(v)+ref2.get(v));
					}
					String[] s = v.split(",");
					for(int i=0;i<x;i++){
						if("-".equals(s[i]))continue;
						String pre = s[i];
						for(int j=0;j<=s[i].length();j++){
							String former = s[i].substring(0, j);
							String later = s[i].substring(j);
							StringBuffer sb = new StringBuffer(former);
							String frev = sb.reverse().toString();
							sb = new StringBuffer(later);
							String lrev = sb.reverse().toString();
							//move former
							if(former.length()>0){
								for(int k=0;k<2*x;k++){
									if(!adj[i][k])continue;
									s[i] = later.length()>0?later:"-";
									if(k<x){
										String preK = s[k];
										s[k] = "-".equals(s[k])?frev:(frev+s[k]);
										String res = get(s);
										reg(ref2, res, next, step);
										s[k] = preK;
									}
									else{
										String preK = s[k-x];
										s[k-x] = "-".equals(s[k-x])?former:(s[k-x]+former);
										String res = get(s);
										reg(ref2, res, next, step);
										s[k-x] = preK;
									}
								}
							}
							//move later
							if(later.length()>0){
								for(int k=0;k<2*x;k++){
									if(!adj[i+x][k])continue;
									s[i] = former.length()>0?former:"-";
									if(k<x){
										String preK = s[k];
										s[k] = "-".equals(s[k])?later:(later+s[k]);
										String res = get(s);
										reg(ref2, res, next, step);
										s[k] = preK;
									}
									else{
										String preK = s[k-x];
										s[k-x] = "-".equals(s[k-x])?lrev:(s[k-x]+lrev);
										String res = get(s);
										reg(ref2, res, next, step);
										s[k-x] = preK;
									}
								}
							}
							s[i] = pre;
						}
					}
				}
				step++;
				list = next;
			}
			System.out.println(min);
		}
	}

	public static void main(String[] args) {
		new AOJ1260().run();
	}
}
