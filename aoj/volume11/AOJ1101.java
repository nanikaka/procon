package volume11;

import java.util.Scanner;

//A Simple Offline Text Editor
public class AOJ1101 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();sc.nextLine();
		while(T--!=0){
			String s = sc.nextLine();
			int cur = 0;
			int M = sc.nextInt();
			while(M--!=0){
				String cmd = sc.next();
				if("forward".equals(cmd)){
					cmd = sc.next();sc.nextLine();
					if("char".equals(cmd)){
						cur = Math.min(s.length(), cur+1);
					}
					else{
						if(cur==s.length())continue;
						char ch = s.charAt(cur);
						if(ch==' '){
							while(cur<s.length()&&s.charAt(cur)==' ')cur++;
						}
						while(cur<s.length()&&s.charAt(cur)!=' ')cur++;
					}
				}
				else if("backward".equals(cmd)){
					cmd = sc.next();sc.nextLine();
					if("char".equals(cmd)){
						cur = Math.max(0, cur-1);
					}
					else{
						if(cur==0)continue;
						char ch = s.charAt(cur-1);
						if(ch==' '){
							while(cur>0&&s.charAt(cur-1)==' ')cur--;
						}
						while(cur>0&&s.charAt(cur-1)!=' ')cur--;
					}
				}
				else if("delete".equals(cmd)){
					cmd = sc.next();sc.nextLine();
					if("char".equals(cmd)){
						if(cur==s.length())continue;
						s = s.substring(0, cur) + s.substring(cur+1, s.length());
					}
					else{
						int p = cur;
						while(p<s.length()&&s.charAt(p)==' ')p++;
						if(p==s.length())continue;
						while(p<s.length()&&s.charAt(p)!=' ')p++;
						s = s.substring(0, cur) + s.substring(p, s.length());
					}
				}
				else{
					String t = sc.nextLine();
					int i=0;
					while(t.charAt(i)!='\"')i++;
					int j=t.length()-1;
					while(t.charAt(j)!='\"')j--;
					t = t.substring(i+1, j);
					s = s.substring(0, cur) + t + s.substring(cur, s.length());
					cur += t.length();
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<=s.length();i++){
				if(cur==i)sb.append('^');
				if(i<s.length())sb.append(s.charAt(i));
			}
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1101().run();
	}
}
