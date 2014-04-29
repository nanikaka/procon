package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Chairs Where Demanding People Sit
public class AOJ0199 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			char[] c = new char[n];
			Arrays.fill(c, '#');
			while(m--!=0){
				char p = sc.next().charAt(0);
				if(p=='A'){
					for(int i=0;i<n;i++)if(c[i]=='#'){c[i]=p;break;}
				}
				else if(p=='B'){
					boolean f = false;
					for(int i=n-1;i>=0;i--){
						if(c[i]=='#'){
							boolean r = i==n-1 || c[i+1]!='A';
							boolean l = i==0 || c[i-1]!='A';
							if(r&&l){
								f = true;
								c[i] = p;
								break;
							}
						}
					}
					if(f)continue;
					for(int i=0;i<n;i++)if(c[i]=='#'){c[i]=p;break;}
				}
				else if(p=='C'){
					boolean f = false;
					for(int i=0;i<n;i++){
						if(c[i]!='#'){
							if(i+1<n && c[i+1]=='#'){
								f = true;
								c[i+1]=p;
								break;
							}
							if(i>0 && c[i-1]=='#'){
								f = true;
								c[i-1]=p;
								break;
							}
						}
					}
					if(f)continue;
					int x = n%2==0?(n/2):((n+1)/2-1);
					c[x] = p;
				}
				else {
					boolean f = true;
					int[] l = new int[n];
					for(int i=0;i<n;i++){
						if(c[i]=='#'){
							if(i==0)l[i]=100;
							else l[i]=l[i-1]+1;
						}
						else {
							l[i] = 0;
							f = false;
						}
					}
					int[] r = new int[n];
					for(int i=n-1;i>=0;i--){
						if(c[i]=='#'){
							if(i==n-1)r[i]=100;
							else r[i]=r[i+1]+1;
						}
						else{ 
							r[i]=0;
							f = false;
						}
					}
					if(f){
						c[0]=p;
						continue;
					}
					int x = 0;
					int max = Math.min(Math.min(100, r[0]), Math.min(100, l[0]));
					for(int i=0;i<n;i++){
						int d = Math.min(Math.min(100, r[i]), Math.min(100, l[i]));
						if(max < d){
							max = d;
							x = i;
						}
					}
					c[x] = p;
				}
			}
			System.out.println(new String(c));
		}
	}
}
