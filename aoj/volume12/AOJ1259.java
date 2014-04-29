package volume12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Colored Cubes
public class AOJ1259 {

	public static class Dice <T>{
		public T[] id;
			enum Face{TOP, BOTTOM, FRONT, BACK, RIGHT, LEFT};
			public T get(int k){
				return id[k];
			}
			public Dice<T> copy(){
				return new Dice<T>(id[0], id[1], id[2], id[3], id[4], id[5]);
			}
			public Dice() {
				@SuppressWarnings("unchecked")
				T[] tid = (T[])new Object[6];
				id = tid;
			}
			public Dice(T top, T bottom, T front, T back, T right, T left) {
				@SuppressWarnings("unchecked")
				T[] tid = (T[])new Object[6];
				id = tid;
				id[Face.TOP.ordinal()] = top;
				id[Face.BOTTOM.ordinal()]= bottom;
				id[Face.FRONT.ordinal()] = front;
				id[Face.BACK.ordinal()] = back;
				id[Face.RIGHT.ordinal()] = right;
				id[Face.LEFT.ordinal()] = left;
			}
			void rollX(boolean isReverse) {
				if(!isReverse) roll(Face.TOP, Face.FRONT, Face.BOTTOM, Face.BACK);
				else roll(Face.TOP, Face.BACK, Face.BOTTOM, Face.FRONT);
			}
			void rollY(boolean isReverse) {
				if(!isReverse) roll(Face.TOP, Face.LEFT, Face.BOTTOM, Face.RIGHT);
				else roll(Face.TOP, Face.RIGHT, Face.BOTTOM, Face.LEFT);
			}
			void rollZ(boolean isReverse) {
				if(!isReverse) roll(Face.FRONT, Face.LEFT, Face.BACK, Face.RIGHT);
				else roll(Face.FRONT, Face.RIGHT, Face.BACK, Face.LEFT);
			}
			private void roll(Face w, Face x, Face y, Face z) {
				T tmp = id[w.ordinal()];
				id[w.ordinal()] = id[x.ordinal()];
				id[x.ordinal()] = id[y.ordinal()];
				id[y.ordinal()] = id[z.ordinal()];
				id[z.ordinal()] = tmp;
			}
			List<Dice<T>> getAllState(){
				List<Dice<T>> lst = new ArrayList<Dice<T>>();
				for(int i = 0; i < 6; i++){
					for(int j = 0; j < 4; j++){
						lst.add(new Dice<T>(id[Face.TOP.ordinal()], id[Face.BOTTOM.ordinal()], id[Face.FRONT.ordinal()], id[Face.BACK.ordinal()], id[Face.RIGHT.ordinal()], id[Face.LEFT.ordinal()]));
						rollZ(false);
					}
					if(i%2 == 1) rollY(false);
					else rollX(false);
				}
				return lst;
			}
	}
	
	Map<String, Integer> ref;
	int ID;
	int reg(String s){
		if(ref.containsKey(s))return ref.get(s);
		ref.put(s, ID);
		return ID++;
	}
	
	Dice<Integer>[][] d;
	int[] s;
	int res, n;
	
	void dfs(int k){
		if(k==n){
			int c = 0;
			for(int i=0;i<6;i++){
				int max = 0;
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				for(int j=0;j<n;j++){
					int x = d[j][s[j]].get(i);
					if(map.containsKey(x)){
						max = Math.max(max, map.get(x)+1);
						map.put(x, map.get(x)+1);
					}
					else {
						map.put(x, 1);
						max = Math.max(max, 1);
					}
				}
				c+=n-max;
			}
			res = Math.min(res, c);
			return;
		}
		for(int i=0;i<24;i++){
			s[k] = i;
			dfs(k+1);
		}
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		s = new int[4];
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			ref = new HashMap<String, Integer>();
			ID = 0;
			d = new Dice[n][24];
			for(int i=0;i<n;i++){
				int[] c = new int[6];
				for(int j=0;j<6;j++)c[j]=reg(sc.next());
				Dice<Integer> D = new Dice<Integer>(c[2], c[3], c[0], c[5], c[1], c[4]);
				List<Dice<Integer>> l = D.getAllState();
				for(int j=0;j<24;j++)d[i][j] = l.get(j);
			}
			res = 24;
			dfs(1);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1259().run();
	}
}
