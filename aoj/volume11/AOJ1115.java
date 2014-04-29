package volume11;

import java.util.Scanner;

//Multi-column List
public class AOJ1115 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int line = sc.nextInt();
			if(line==0)break;
			int col = sc.nextInt();
			int w = sc.nextInt();
			int space = sc.nextInt();
			String sp = "";
			while(sp.length()<space)sp+=".";
			sc.nextLine();
			boolean con = true;
			String s = "";
			while(con){
				if("".equals(s)){
					s = sc.nextLine();
					if("?".equals(s))break;
				}
				String[][] res = new String[col][line];
				for(int c=0;c<col;c++){
					for(int l=0;l<line;l++){
						res[c][l] = "";
						if(!con){
							while(res[c][l].length()<w)res[c][l]=res[c][l]+".";
							continue;
						}
						if("".equals(s)){
							s = sc.nextLine();
							if("?".equals(s)){
								con = false;
								s = "";
							}
						}
						int t = Math.min(s.length(), w);
						res[c][l] = s.substring(0, t);
						while(res[c][l].length()<w)res[c][l]=res[c][l]+".";
						s = s.substring(t, s.length());
					}
				}
				for(int l=0;l<line;l++){
					for(int c=0;c<col;c++){
						System.out.print(res[c][l]+(c==col-1?"\n":sp));
					}
				}
				System.out.println("#");
			}			
			System.out.println("?");
		}
	}
	
	public static void main(String[] args) {
		new AOJ1115().run();
	}
}
