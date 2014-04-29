package volume24;

import java.util.Scanner;

//YAML
public class AOJ2438 {

	void run(){
		Scanner sc = new Scanner(System.in);
		String[] ps = sc.nextLine().split("\\.");
		char[][] s = new char[15000][];
		int n = 0;
		while(sc.hasNext()){
			s[n++] = sc.nextLine().toCharArray();
		}
		int now = 0, indent = 0;
		for(int i=1;i<ps.length;i++){
			boolean find = false;
			while(now < n){
				int cnt = 0, idx = 0;
				while(s[now][idx]==' '){
					cnt++; idx++;
				}
				if(cnt < indent){
					System.out.println("no such property"); return;
				}
				else if(cnt==indent){
					String name = "";
					while(s[now][idx]!=':'){
						name+=s[now][idx++];
					}
					if(ps[i].equals(name)){
						if(i==ps.length-1){
							if(idx==s[now].length-1){
								System.out.println("object"); return;
							}
							idx+=2;
							String res = "";
							while(idx < s[now].length)res+=s[now][idx++];
							System.out.println("string \"" + res +"\"");
							return;
						}
						if(now==n-1){
							System.out.println("no such property"); return;
						}
						indent = 0;
						while(s[now+1][indent]==' ')indent++;
						find = true;
						now++; break;
					}
					else now++;
				}
				else now++;
			}
			if(!find){
				System.out.println("no such property"); return;
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2438().run();
	}
}
