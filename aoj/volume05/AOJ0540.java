package volume05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Amidakuji
public class AOJ0540 {

	class R implements Comparable<R>{
		//棒の高さ、左側の座標、右側の座標、この棒に左から進入したときに得られる値、右から進入したときの値、左側の座標の縦棒におけるID, 右側の座標の縦棒におけるID
		int height, l, r, sl, sr, lid, rid;
		//棒を一切取り除かない場合の、左側に進入してくる番号、右側に進入してくる番号
		int L, R;
		public R(int h, int l, int r) {
			this.height = h;
			this.l = l;
			this.r = r;
		}
		public int compareTo(R o) {
			return height-o.height;
		}
		int find(boolean isLeft, int K){
			if(isLeft){
				L = K;
				if(rid+1<stick[r].size()){
					R next = stick[r].get(rid+1);
					if(next.l == r)sl = next.find(true, K);
					else sl = next.find(false, K);
				}
				else sl = s[r];
				return sl;
			}
			R = K;
			if(lid+1<stick[l].size()){
				R next = stick[l].get(lid+1);
				if(next.l == l)sr = next.find(true, K);
				else sr = next.find(false, K);
			}
			else sr = s[l];
			return sr;
		}
	}
	
	int[] s;
	int n, m, h, k;
	List<R>[] stick;
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt(); m = sc.nextInt(); h = sc.nextInt(); k = sc.nextInt();
			if((n|m|h|k)==0)break;
			s = new int[n+1];
			for(int i=1;i<=n;i++)s[i] = sc.nextInt();
			stick = new List[n+1];
			for(int i=1;i<=n;i++)stick[i] = new ArrayList<R>();
			for(int i=0;i<m;i++){
				int left = sc.nextInt(), height = sc.nextInt();
				R r = new R(height, left, left+1);
				stick[left].add(r); stick[left+1].add(r);
			}
			for(int i=1;i<=n;i++)Collections.sort(stick[i]);
			for(int i=1;i<=n;i++)for(int j=0;j<stick[i].size();j++){
				if(stick[i].get(j).l==i)stick[i].get(j).lid = j;
				else stick[i].get(j).rid = j;
			}
			int sum = 0;
			//棒を取り除かない場合の縦棒kから出発したときの得点
			int[] p = new int[n+1];
			for(int i=1;i<=n;i++){
				if(stick[i].isEmpty()){
					p[i] = s[i];
					if(i<=k)sum+=s[i];
				}
				else {
					R r = stick[i].get(0);
					if(r.l == i)p[i]= r.find(true, i);
					else p[i] = r.find(false, i);
					if(i<=k)sum += p[i];
				}
			}
			int min = sum;
			for(int i=1;i<=n;i++)for(int j=0;j<stick[i].size();j++){
				//棒rを取り除いてみる
				R r = stick[i].get(j);
				int dif = sum;
				if(r.L<=k||r.R<=k){
					if(r.L<=k){
						int ID = r.L;
						dif-=p[ID];
						if(r.lid+1<stick[r.l].size()){
							R next = stick[r.l].get(r.lid+1);
							if(next.l==r.l)dif += next.sl;
							else dif += next.sr;
						}
						else dif += s[r.l];
					}
					if(r.R<=k){
						int ID = r.R;
						dif-=p[ID];
						if(r.rid+1<stick[r.r].size()){
							R next = stick[r.r].get(r.rid+1);
							if(next.l==r.r)dif+=next.sl;
							else dif+=next.sr;
						}
						else dif+=s[r.r];
					}
				}
				min = Math.min(min, dif);
			}
			System.out.println(min);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0540().run();
	}
}
