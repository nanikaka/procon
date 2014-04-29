package volume02;

import java.util.Scanner;

//Seven Segments
public class AOJ0228 {

	public static void main(String[] args) {
		String[] seg = {"1111110", "0110000","1101101","1111001","0110011","1011011","1011111","1110010","1111111","1111011"};
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==-1)break;
			String s = "0000000";
			while(n--!=0){
				String t = seg[sc.nextInt()];
				char[] r = new char[7];
				for(int i=0;i<7;i++)r[i]=t.charAt(6-i)==s.charAt(6-i)?'0':'1';
				System.out.println(r);
				s = t;
			}
		}
	}
}
