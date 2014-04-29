package volume10;

import java.util.LinkedList;
import java.util.Scanner;

//Emacs-like Editor
public class AOJ1021 {

	void run(){
		Scanner sc = new Scanner(System.in);
		LinkedList<String> l = new LinkedList<String>();
		while(true){
			String s = sc.nextLine();
			if(s.equals("END_OF_TEXT"))break;
			l.add(s+"$");
		}
		int i = 0;
		int j = 0;
		String buf = "";
		while(true){
			char ch = sc.next().charAt(0);
			
			if(ch=='-')break;
			if(ch=='a')j=0;
			else if(ch=='e')j=l.get(i).length()-1;
			else if(ch=='p'){
				if(i>0)i--;
				j=0;
			}
			else if(ch=='n'){
				if(i<l.size()-1)i++;
				j=0;
			}
			else if(ch=='f'){
				if(j!=l.get(i).length()-1)j++;
				else if(j==l.get(i).length()-1&&i<l.size()-1){
					i++;j=0;
				}
			}
			else if(ch=='b'){
				if(j>0)j--;
				else if(j==0&&i>0){
					i--;j=l.get(i).length()-1;
				}
			}
			else if(ch=='d'){
				if(l.get(i).charAt(j)!='$'){
					StringBuilder sb = new StringBuilder(l.remove(i));
					l.add(i, sb.substring(0, j)+sb.substring(j+1,sb.length()));
				}
				else if(i<l.size()-1){
					String t = l.remove(i);
					StringBuilder sb = new StringBuilder(t.substring(0, t.length()-1));
					sb.append(l.remove(i));
					l.add(i, sb.toString());
				}
			}
			else if(ch=='k'){
				if(j==l.get(i).length()-1&&i<l.size()-1){
					String t = l.remove(i);
					StringBuilder sb = new StringBuilder(t.substring(0, t.length()-1));
					sb.append(l.remove(i));
					l.add(i, sb.toString());
					buf = "$";
				}
				else if(j<l.get(i).length()-1){
					StringBuilder sb = new StringBuilder(l.remove(i));
					l.add(i, sb.substring(0,j)+"$");
					buf = sb.substring(j,sb.length()-1);
					j = l.get(i).length()-1;
				}
			}
			else if(ch=='y'){
				if(buf.equals(""))continue;
				if(buf.equals("$")){
					StringBuilder sb = new StringBuilder(l.remove(i));
					l.add(i, sb.substring(0,j)+"$");
					l.add(i+1,sb.substring(j,sb.length()));
					i++;j=0;
				}
				else {
					StringBuilder sb = new StringBuilder(l.remove(i));
					char r = sb.charAt(j);
					l.add(i, sb.substring(0, j)+buf+sb.substring(r=='$'?j+1:j,sb.length())+(r=='$'?"$":""));
					j += buf.length();
				}
			}
		}
		for(String s:l)System.out.println(s.substring(0,s.length()-1));
	}
	
	public static void main(String[] args) {
		new AOJ1021().run();
	}
}
