package volume20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Princess's Japanese
public class AOJ2020 {

	final int WORD = 0, SOKUON = 1, HATUON = 2, CHOON = 3;
	String[] nonvoice = {"k", "s", "t", "h", "p", "ky", "sy", "ty", "hy", "py"};
	
	class M{
		int type;
		String shiin;
		char boin;
		boolean del, conA, conO;
		public M(int type, String shiin, char boin) {
			this.type = type;
			this.shiin = shiin;
			this.boin = boin;
		}
		public String toString() {
			String r = shiin;
			if(boin=='?')return r;
			r+=del?("("+boin+")"):boin;
			return r;
		}
	}
	
	boolean isBoin(char ch){
		return ch=='a'||ch=='i'||ch=='u'||ch=='e'||ch=='o';
	}
	boolean isChoonBoin(char ch){
		return ch=='a'||ch=='i'||ch=='u';
	}
	boolean isNonVoiceShiin(String s){
		for(String t:nonvoice)if(t.equals(s))return true;
		return false;
	}
	
	List<M> decomp(char[] s){
		List<M> res = new ArrayList<M>();
		int n = s.length;
		int i = 0;
		while(i<n){
			char ch = s[i];
			//母音の場合
			if(isBoin(ch)){
				//直前が母音かつ自身が a, i, eならこれは長音
				if(isChoonBoin(ch)&&i>0&&isBoin(s[i-1]))
					res.add(new M(CHOON, "", ch));
				//単独の母音
				else
					res.add(new M(WORD, "", ch));
				i++;
			}
			//子音の場合
			else{
				//nの場合だけ特別
				if(ch=='n'){
					//文末なら撥音
					if(i==n-1){
						res.add(new M(HATUON, "n", '?')); i++;
					}
					//直後が ' なら撥音
					else if(s[i+1]=='\''){
						res.add(new M(HATUON, "n'", '?')); i+=2;
					}
					//直後がyでないかつ母音でないなら撥音
					else if(s[i+1]!='y'&&!isBoin(s[i+1])){
						res.add(new M(HATUON, "n", '?')); i++;
					}
					//撥音ではないnと分かった
					else{
						if(isBoin(s[i+1])){
							res.add(new M(WORD, "n", s[i+1])); i+=2;
						}
						else {
							res.add(new M(WORD, ch+""+s[i+1], s[i+2])); i+=3;
						}
					}
				}
				//n以外の子音の場合
				else{
					//同じ文字が続いているなら促音
					if(s[i+1]==ch){
						res.add(new M(SOKUON, ch+"", '?')); i++;
					}
					else if(isBoin(s[i+1])){
						res.add(new M(WORD, ch+"", s[i+1])); i+=2;
					}
					else {
						res.add(new M(WORD, ch+""+s[i+1], s[i+2])); i+=3;
					}
				}
			}
		}
		return res;
	}
	
	M pre(List<M> list, int idx){
		int id = idx-1;
		while(id>=0){
			if(list.get(id).boin=='?')id--;
			else return list.get(id);
		}
		return null;
	}
	
	void findCon(List<M> list){
		int i = 0;
		int n = list.size();
		while(i<n){
			M m = list.get(i);
			if(isNonVoiceShiin(m.shiin)&&(m.boin=='a')){
				int j = i+1;
				while(j<n){
					M r = list.get(j);
					if(isNonVoiceShiin(r.shiin)&&(r.boin=='a')){
						m.conA = true; r.conA = true; j++;
					}
					else break;
				}
			}
			i++;
		}
		i = 0;
		while(i<n){
			M m = list.get(i);
			if(isNonVoiceShiin(m.shiin)&&(m.boin=='o')){
				int j = i+1;
				while(j<n){
					M r = list.get(j);
					if(isNonVoiceShiin(r.shiin)&&(r.boin=='o')){
						m.conO = true; r.conO = true; j++;
					}
					else break;
				}
			}
			i++;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			char[] s = sc.next().toCharArray();
			if(s[0]=='#')break;
			List<M> list = decomp(s);
			findCon(list);
			int n = list.size();
			int i = 0;
			while(i<n){
				M m = list.get(i);
				//母音を持たない拍はスルー
				if(m.boin=='?'||m.boin=='e'){
					i++; continue;
				}
				//直近の母音が無声化されているならスルー
				M p = pre(list, i);
				if(p!=null&&p.del){
					i++; continue;
				}
				//i, uの場合
				if(m.boin=='i'||m.boin=='u'){
					//一番後ろの拍ではない
					if(i<n-1){
						if(isNonVoiceShiin(m.shiin)&&isNonVoiceShiin(list.get(i+1).shiin)){
							m.del = true; i++; continue;
						}
					}
					//一番後ろの拍である
					else {
						if(isNonVoiceShiin(m.shiin)){
							m.del = true; i++; continue;
						}
					}
					i++; continue;
				}
				//aの場合
				else if(m.boin=='a'){
					//連続してないならスルー
					if(!m.conA){
						i++; continue;
					}
					//連続の最後の拍ではない
					if(i<n-1&&list.get(i+1).conA){
						m.del = true; i++; continue;
					}
					i++; continue;
				}
				//oの場合
				else{
					//連続してないならスルー
					if(!m.conO){
						i++; continue;
					}
					//連続の最後の拍ではない
					if(i<n-1&&list.get(i+1).conO){
						m.del = true; i++; continue;
					}
					i++; continue;
				}
			}
			for(M m:list)System.out.print(m);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new AOJ2020().run();
	}
}
