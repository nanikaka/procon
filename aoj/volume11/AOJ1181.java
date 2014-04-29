package volume11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Biased Dice
public class AOJ1181 {

	public static class Dice <T>{
		public T[] id;
		enum Face{TOP, BOTTOM, FRONT, BACK, RIGHT, LEFT};
		public T get(Face f){
			return id[f.ordinal()];
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
		//true: X軸方向に手前に転がす
		//false: X軸方向に奥に転がす
		void rollX(boolean isReverse) {
			if(!isReverse) roll(Face.TOP, Face.FRONT, Face.BOTTOM, Face.BACK);
			else roll(Face.TOP, Face.BACK, Face.BOTTOM, Face.FRONT);
		}
		//true: Y軸方向に左へ転がす
		//false: Y軸方向に右へ転がす
		void rollY(boolean isReverse) {
			if(!isReverse) roll(Face.TOP, Face.LEFT, Face.BOTTOM, Face.RIGHT);
			else roll(Face.TOP, Face.RIGHT, Face.BOTTOM, Face.LEFT);
		}
		//true: Z軸方向に右へ回す
		//false: Z軸方向に左へ回す
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

	List<Dice<Integer>> dice;

	int get(int t, int f){
		for(int i=0;i<24;i++){
			Dice<Integer> d = dice.get(i);
			if(d.get(Dice.Face.TOP)==t && d.get(Dice.Face.FRONT)==f)return i;
		}
		return -1;
	}
	
	void run(){
		Dice<Integer> o = new Dice<Integer>(1, 6, 3, 4, 5, 2);
		dice = o.getAllState();
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int[][] h = new int[20][20], state = new int[20][20];
			for(int i=0;i<n;i++){
				int t = sc.nextInt(), f = sc.nextInt();
				Dice<Integer> d = dice.get(get(t, f));
				int pi = 10, pj = 10;
				for(;;){
					boolean con = false;
					for(int num=6;num>=4;num--){
						if(d.get(Dice.Face.FRONT)==num){
							if(h[pi+1][pj] < h[pi][pj]){
								Dice<Integer> copy = d.copy();
								copy.rollX(true);
								pi++;
								d = copy;
								con = true;
								break;
							}
						}
						else if(d.get(Dice.Face.BACK)==num){
							if(h[pi-1][pj] < h[pi][pj]){
								Dice<Integer> copy = d.copy();
								copy.rollX(false);
								pi--;
								d = copy;
								con = true;
								break;
							}
						}
						else if(d.get(Dice.Face.RIGHT)==num){
							if(h[pi][pj+1] < h[pi][pj]){
								Dice<Integer> copy = d.copy();
								copy.rollY(false);
								pj++;
								d = copy;
								con = true;
								break;
							}
						}
						else if(d.get(Dice.Face.LEFT)==num){
							if(h[pi][pj-1] < h[pi][pj]){
								Dice<Integer> copy = d.copy();
								copy.rollY(true);
								pj--;
								d = copy;
								con = true;
								break;
							}
						}
					}
					if(!con){
						h[pi][pj]++; state[pi][pj] = d.get(Dice.Face.TOP);
						break;
					}
				}
			}
			int[] c = new int[7];
			for(int i=0;i<20;i++)for(int j=0;j<20;j++)c[state[i][j]]++;
			for(int i=1;i<7;i++)System.out.print(c[i]+(i==6?"\n":" "));
		}
	}

	public static void main(String[] args) {
		new AOJ1181().run();
	}
}
