package volume12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Traveling Cube
public class AOJ1290 {

	int[][] move = {{-1,0}, {0,1},{1,0},{0,-1}};
	Dice<Character> d;

	int getID(int s, int k){
		Dice<Character> c = d.list.get(s).copy();
		if(k==0)c.rollX(false);
		else if(k==1)c.rollY(false);
		else if(k==2)c.rollX(true);
		else c.rollY(true);
		return d.getID(c);
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		d = new Dice<Character>('r', 'c', 'm', 'g', 'b', 'y');
		d.list = d.getAllState();
		while(true){
			int w = sc.nextInt();
			int h = sc.nextInt();
			if((w|h)==0)break;
			char[][] map = new char[h][w];
			for(int i=0;i<h;i++)map[i]=sc.next().toCharArray();
			char[] order = sc.next().toCharArray();
			int si, sj;
			si = sj = -1;
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(map[i][j]=='#'){
						map[i][j] = 'w';
						si = i;
						sj = j;
					}
				}
			}
			boolean[][][][] u = new boolean[h][w][24][7];
			u[si][sj][0][0] = true;
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[]{si, sj, 0, 0});
			int step = 0;
			boolean f = false;
			while(!l.isEmpty()){
				List<int[]> next = new ArrayList<int[]>();
				for(int a[]:l){
					int i = a[0];
					int j = a[1];
					int s = a[2];
					int c = a[3];
					if(c==6){
						next.clear();
						f = true;
						break;
					}
					for(int k=0;k<4;k++){
						int ni = i+move[k][0];
						int nj = j+move[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w){
							int ns = getID(s, k);
							char ch = d.list.get(ns).get(Dice.Face.TOP);
							if(map[ni][nj]=='w'&&!u[ni][nj][ns][c]){
								u[ni][nj][ns][c] = true;
								next.add(new int[]{ni, nj, ns, c});
							}
							else if(map[ni][nj]==order[c]&&order[c]==ch&&!u[ni][nj][ns][c+1]){
								u[ni][nj][ns][c+1] = true;
								next.add(new int[]{ni, nj, ns, c+1});
							}
						}
					}
				}
				step++;
				l = next;
			}
			System.out.println(f?--step:"unreachable");
		}
	}

	public static void main(String[] args) {
		new AOJ1290().run();
	}

	static class Dice <T>{
		public T[] id;
		enum Face{TOP, BOTTOM, FRONT, BACK, RIGHT, LEFT};
		List<Dice<T>> list;

		public T get(Face f){
			return id[f.ordinal()];
		}

		public Dice<T> copy(){
			return new Dice<T>(id[0], id[1], id[2], id[3], id[4], id[5]);
		}

		public int getID(Dice<T> d){
			for(int i=0;i<24;i++)if(d.equals(list.get(i)))return i;
			return -1;
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

		@Override
		public boolean equals(Object o) {
			if(!(o instanceof Dice<?>))return false;
			@SuppressWarnings("unchecked")
			Dice<T> d = (Dice<T>)o;
			for(Face f : Face.values()){
				if(!id[f.ordinal()].equals(d.id[f.ordinal()])){
					return false;
				}
			}
			return true;
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
}
