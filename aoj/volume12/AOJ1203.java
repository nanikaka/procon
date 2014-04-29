package volume12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Napoleon's Grumble
public class AOJ1203 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] s = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").toCharArray();
			Set<String> set = new HashSet<String>();
			Set<String> odd = new HashSet<String>();
			Set<String> even = new HashSet<String>();
			int n = s.length;
			for(int i=0;i<n;i++){
				int left = i-1;
				int right = i+1;
				String pre = ""+s[i];
				while(left>=0&&right<n&&s[left]==s[right]){
					set.add(pre);
					pre = s[left--]+pre+s[right++];
				}
				if(pre.length()>2)odd.add(pre);
				if(i+1==n||s[i]!=s[i+1])continue;
				left = i-1;
				right = i+2;
				pre = s[i]+""+s[i+1];
				while(left>=0&&right<n&&s[left]==s[right]){
					set.add(pre);
					pre = s[left--]+pre+s[right++];
				}
				if(pre.length()>2)even.add(pre);
			}
			boolean h = true;
			for(String t:odd){
				if(!set.contains(t)){
					if(!h)System.out.print(" ");
					h = false;
					System.out.print(t);
				}
			}
			for(String t:even){
				if(!set.contains(t)){
					if(!h)System.out.print(" ");
					h = false;
					System.out.print(t);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new AOJ1203().run();
	}
}
