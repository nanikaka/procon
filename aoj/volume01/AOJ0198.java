package volume01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Trouble in Artist Shinagawa's Artifact
public class AOJ0198 {

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
		public int hashCode() {
			int hash = 31;
			for(Face f : Face.values()){
				hash += hash*17+id[f.ordinal()].hashCode();
			}
			return hash;
		}
}


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			Dice<String>[] d = new Dice[n];
			for(int i=0;i<n;i++){
				String[] s = new String[6];
				for(int j=0;j<6;j++)s[j]=sc.next();
				d[i] = new Dice<String>(s[0],s[5],s[1],s[4],s[2],s[3]);
			}
			int c = 0;
			boolean[] u = new boolean[n];
			Arrays.fill(u, true);
			for(int i=0;i<n;i++){
				if(u[i]){
					c++;
					for(int j=i+1;j<n;j++){
						boolean f = true;
						for(Dice<String> t:d[j].getAllState())if(d[i].equals(t)){f = false;break;}
						if(!f)u[j]=false;
					}
				}
			}
			System.out.println(n-c);
		}
	}
}
