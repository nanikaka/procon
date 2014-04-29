package volume10;

import java.util.Scanner;

//CamelCase
public class AOJ1044 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			String s = sc.next();
			char ch = sc.next().charAt(0);
			if(ch=='X')break;
			char f = Character.isUpperCase(s.charAt(0))?'U':s.contains("_")?'D':'L';
			StringBuilder sb = new StringBuilder();
			char[] t = s.toCharArray();
			if(f==ch)sb.append(s);
			else if(f=='U'){
				if(ch=='L'){
					t[0] = Character.toLowerCase(t[0]);
					sb.append(t);
				}
				else{
					t[0] = Character.toLowerCase(t[0]);
					for(int i=0;i<t.length;i++){
						if(Character.isUpperCase(t[i]))sb.append('_');
						sb.append(Character.toLowerCase(t[i]));
					}
				}
			}
			else if(f=='L'){
				if(ch=='U'){
					t[0] = Character.toUpperCase(t[0]);
					sb.append(t);
				}
				else{
					for(int i=0;i<t.length;i++){
						if(Character.isUpperCase(t[i]))sb.append('_');
						sb.append(Character.toLowerCase(t[i]));
					}
				}
			}
			else{
				if(ch=='U'){
					sb.append(Character.toUpperCase(t[0]));
					for(int i=1;i<t.length;i++){
						if(t[i]=='_'){
							i++;
							sb.append(Character.toUpperCase(t[i]));
						}
						else sb.append(t[i]);
					}
				}
				else{
					for(int i=0;i<t.length;i++){
						if(t[i]=='_'){
							i++;
							sb.append(Character.toUpperCase(t[i]));
						}
						else sb.append(t[i]);
					}
				}
			}
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1044().run();
	}
}
