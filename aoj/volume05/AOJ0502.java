package volume05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Dice
public class AOJ0502 {

	static class Dice <T>{
		public T[] id;
		enum Face{TOP, BOTTOM, FRONT, BACK, RIGHT, LEFT};

		public T get(Face f){
			return id[f.ordinal()];
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
		boolean isEquivalent(Dice<T> d) {
			for(int i=0; i<6; i++) {
				for(int j=0; j<4; j++) {
					if(this.equals(d)) return true;
					rollZ(false);
				}
				if(i%2==1) rollY(false);
				else rollX(false);
			}
			return false;
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

		@Override
		public String toString() {
			String str = "";
			for(Face f : Face.values()){
				str += id[f.ordinal()] + " ";
			}
			return str;
		}

		@Override
		public int hashCode() {
			int hash = 31;
			for(Face f : Face.values()){
				hash += hash*17+id[f.ordinal()].hashCode();
			}
			return hash;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			Dice<Integer> d = new Dice<Integer>(1,6,2,5,3,4);
			int s = 1;
			while(n--!=0){
				String c = sc.next();
				if(c.equals("North"))d.rollX(false);
				else if(c.equals("South"))d.rollX(true);
				else if(c.equals("East"))d.rollY(false);
				else if(c.equals("West"))d.rollY(true);
				else if(c.equals("Right"))d.rollZ(true);
				else d.rollZ(false);
				s+=(Integer)(d.get(Dice.Face.TOP));
			}
			System.out.println(s);
		}
	}
}
