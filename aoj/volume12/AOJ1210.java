package volume12;

import java.util.Scanner;

//Die Game
public class AOJ1210 {

	static class Dice <T>{
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
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		Dice<Integer> dice = new Dice<Integer>(1, 6, 5, 2, 4, 3);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			Dice<Integer> d = dice.copy();
			while(n--!=0){
				String s = sc.next();
				if("north".equals(s))d.rollX(false);
				else if("south".equals(s))d.rollX(true);
				else if("east".equals(s))d.rollY(false);
				else d.rollY(true);
			}
			System.out.println(d.get(Dice.Face.TOP));
		}
	}
	
	public static void main(String[] args) {
		new AOJ1210().run();
	}
}
