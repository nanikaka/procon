package volume0;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Affine Cipher
public class AOJ0040 {

	static long gcd(long a, long b){
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0){
			long r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		Set<String> valid = new HashSet<String>();
		for(int a=1;a<=100;a++){
			if(gcd(a,26)>1)continue;
			for(int b=1;b<=100;b++){
				boolean f = true;
				boolean[] c = new boolean[26];
				for(int j=0;j<26;j++){
					int x = (a*j+b)%26;
					if(c[x])f=false;
					c[x] = true;
				}
				if(f)valid.add(a+" "+b);
			}
		}
		while(t--!=0){
			String[] s = sc.nextLine().split(" ");
			for(String vv:valid){
				String[] v = vv.split(" ");
				int a = Integer.parseInt(v[0]);
				int b = Integer.parseInt(v[1]);
				boolean f = false;
				StringBuilder sb = new StringBuilder();
				boolean head = true;
				for(String m : s){
					if(!head)sb.append(' ');
					head = false;
					char[] ch = new char[m.length()];
					for(int i=0;i<ch.length;i++)ch[i]=(char)(((m.charAt(i)-'a')*a+b)%26 + 'a');
					String x = new String(ch);
					if(x.equals("that")||x.equals("this"))f=true;
					sb.append(x);
				}
				if(f){
					System.out.println(sb);
					break;
				}
			}
		}
	}
}
