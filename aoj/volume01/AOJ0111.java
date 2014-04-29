package volume01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Doctor's Memorable Codes
public class AOJ0111 {

	public static void main(String[] args) {
		Map<String, Character> t = new HashMap<String, Character>();
		t.put("101", ' ');
		t.put("000000", '\'');
		t.put("000011", ',');
		t.put("10010001", '-');
		t.put("010001", '.');
		t.put("000001", '?');
		t.put("100101", 'A');
		t.put("10011010", 'B');
		t.put("0101", 'C');
		t.put("0001", 'D');
		t.put("110", 'E');
		t.put("01001", 'F');
		t.put("10011011", 'G');
		t.put("010000", 'H');
		t.put("0111", 'I');
		t.put("10011000", 'J');
		t.put("0110", 'K');
		t.put("00100", 'L');
		t.put("10011001", 'M');
		t.put("10011110", 'N');
		t.put("00101", 'O');
		t.put("111", 'P');
		t.put("10011111", 'Q');
		t.put("1000", 'R');
		t.put("00110", 'S');
		t.put("00111", 'T');
		t.put("10011100", 'U');
		t.put("10011101", 'V');
		t.put("000010", 'W');
		t.put("10010010", 'X');
		t.put("10010011", 'Y');
		t.put("10010000", 'Z');
		Map<Character, String> r = new HashMap<Character, String>();
		r.put('A', "00000");
		r.put('B', "00001");
		r.put('C', "00010");
		r.put('D', "00011");
		r.put('E', "00100");
		r.put('F', "00101");
		r.put('G', "00110");
		r.put('H', "00111");
		r.put('I', "01000");
		r.put('J', "01001");
		r.put('K', "01010");
		r.put('L', "01011");
		r.put('M', "01100");
		r.put('N', "01101");
		r.put('O', "01110");
		r.put('P', "01111");
		r.put('Q', "10000");
		r.put('R', "10001");
		r.put('S', "10010");
		r.put('T', "10011");
		r.put('U', "10100");
		r.put('V', "10101");
		r.put('W', "10110");
		r.put('X', "10111");
		r.put('Y', "11000");
		r.put('Z', "11001");
		r.put(' ', "11010");
		r.put('.', "11011");
		r.put(',', "11100");
		r.put('-', "11101");
		r.put('\'', "11110");
		r.put('?', "11111");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			char[] m = sc.nextLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			for(char c:m)sb.append(r.get(c));
			String s = sb.toString();
			sb = new StringBuilder();
			int i=0;
			while(i<s.length()){
				int k;
				for(k=3;i+k<=s.length();k++){
					String sub = s.substring(i,i+k);
					boolean f = false;
					for(String v : t.keySet()){
						if(v.equals(sub)){
							f = true;
							break;
						}
					}
					if(f)break;
				}
				if(i+k>s.length())break;
				sb.append(t.get(s.substring(i,i+k)));
				i+=k;
			}
			System.out.println(sb);
		}
	}
}
