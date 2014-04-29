package volume0;

import java.util.Scanner;

//Caesar Chipher
public class AOJ0017 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String[] s = sc.nextLine().split(" ");
			for(int i=0;i<26;i++){
				boolean f = false;
				for(int j=0;j<s.length;j++){
					char[] a = s[j].toCharArray();
					for(int k=0;k<a.length;k++){
						if(Character.isLowerCase(a[k]))
							a[k] = (char)((a[k]-'a'+1)%26+'a');
					}
					s[j] = new String(a);
					if(s[j].equals("the")||s[j].equals("this")||s[j].equals("that"))f=true;
				}
				if(f)break;
			}
			boolean f = true;
			for(String r:s){
				if(!f)System.out.print(" ");
				f=false;
				System.out.print(r);
			}
			System.out.println();
		}
	}
}
