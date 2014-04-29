package volume02;

import java.util.Scanner;

//Mayan Crucial Prediction
public class AOJ0261 {

	int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int MOD = 13*20*20*18*20;
	int B = 20*20*18*20;
	int KA = 20*18*20;
	int T = 18*20;
	int W = 20;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			String in = sc.next();
			if("#".equals(in))break;
			String[] t = in.split("\\.");
			int n = t.length;
			int[] a = new int[n];
			for(int i=0;i<n;i++)a[i]=Integer.parseInt(t[i]);
			if(n==5)toSeireki(a[0], a[1], a[2], a[3], a[4]);
			else toMayan(a[0], a[1], a[2]);
		}
	}
	
	void toSeireki(int b, int ka, int t, int w, int ki){
		int days = b*B + ka*KA + t*T + w*W + ki;
		int y = 2012, m = 12, d = 21;
		while(0 < days){
			if(m==1 && d==1){
				int yearDay = 365 + leap(y);
				if(yearDay <= days){
					y++;
					days-=yearDay;
					continue;
				}
			}
			if(m==2){
				if(d==day[2]+leap(y)){
					m++; d=1;
				}
				else d++;
			}
			else{
				if(d==day[m]){
					m++; d=1;
					if(m==13){
						y++; m=1;
					}
				}
				else d++;
			}
			days--;
		}
		System.out.printf("%d.%d.%d\n", y, m, d);
	}

	int leap(int y){
		return y%4==0 && (y%100!=0 || y%400==0) ? 1 : 0;
	}
	
	void toMayan(int y, int m, int d){
		int Y = 2012, M = 12, D = 21;
		int days = 0;
		while(Y!=y || M!=m || D!=d){
			if(MOD <= days)days-=MOD;
			if(M==1 && D==1){
				if(Y!=y){
					int year = 365+leap(Y);
					days+=year;
					Y++;
					continue;
				}
			}
			if(M==2){
				if(D==day[2]+leap(Y)){
					M++; D=1;
				}
				else D++;
			}
			else{
				if(D==day[M]){
					M++; D=1;
					if(M==13){
						Y++; M=1;
					}
				}
				else D++;
			}
			days++;
		}
		if(MOD <= days)days-=MOD;
		int b = days/B; days%=B;
		int ka = days/KA; days%=KA;
		int t = days/T; days%=T;
		int w = days/W; days%=W;
		int ki = days;
		System.out.printf("%d.%d.%d.%d.%d\n", b, ka, t, w, ki);
	}

	public static void main(String[] args) {
		new AOJ0261().run();
	}
}
