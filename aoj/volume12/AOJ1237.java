package volume12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Shredding Company
public class AOJ1237 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int t = sc.nextInt();
			String s = sc.next();
			if(t==0&&"0".equals(s))break;
			int max = -1;
			List<String> piece = new ArrayList<String>();
			boolean col = false;
			int n = s.length()-1;
			for(int i=0;i<1<<n;i++){
				int p = 0;
				int sum = 0;
				List<String> sub = new ArrayList<String>();
				for(int j=0;j<n;j++){
					if((i>>j&1)==0)continue;
					String u = s.substring(p, j+1);
					sub.add(u);
					sum += Integer.parseInt(u);
					p = j+1;
				}
				sub.add(s.substring(p));
				sum += Integer.parseInt(s.substring(p));
				if(sum<=t&&max<sum){
					max = sum; col = false; piece = sub;
				}
				else if(sum==max){
					col = true;
				}
			}
			if(max==-1)System.out.println("error");
			else if(col)System.out.println("rejected");
			else{
				System.out.print(max+" ");
				for(int i=0;i<piece.size();i++)System.out.print(piece.get(i)+(i==piece.size()-1?"\n":" "));
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1237().run();
	}
}
