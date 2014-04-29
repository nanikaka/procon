package volume01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//Doctor's Research Rooms
public class AOJ0172 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			boolean[][] door = new boolean[n][n];
			for(int i=0;i<m;i++){
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				door[a][b]=door[b][a]=true;
			}
			String[] move = new String[n];
			String[] switchon = new String[n];
			String[] switchoff = new String[n];
			for(int i=1;i<=n;i++){
				move[i-1]="Move to room " + i + ".";
				switchon[i-1]="Switch on room " + i + ".";
				switchoff[i-1]="Switch off room " + i + ".";
			}
			int[][][] pre = new int[1<<n][n][2];
			String[][] mes = new String[1<<n][n];
			boolean[][] mark = new boolean[1<<n][n];
			int start = 0;
			for(int i=0;i<n;i++)start|=sc.nextInt()<<i;
			int[][] sw = new int[n][];
			for(int i=0;i<n;i++){
				int k = sc.nextInt();
				sw[i] = new int[k];
				for(int j=0;j<k;j++)sw[i][j]=sc.nextInt()-1;
				Arrays.sort(sw[i]);
			}
			if((start&1)==0){
				System.out.println("Help me!");
				continue;
			}
			mark[start][0] = true;
			pre[start][0][0] = -1;
			pre[start][0][1] = -1;
			int step = 0;
			List<int[]> l = new ArrayList<int[]>();
			l.add(new int[]{start, 0});
			boolean reachGoal = false;
			boolean trueEnding = false;
			while(!l.isEmpty()){
				List<int[]> next = new ArrayList<int[]>();
				for(int[] a:l){
					int s = a[0];
					int pos = a[1];
					if(pos==n-1){
						reachGoal = true;
						if(s==(1<<(n-1))){
							trueEnding = true;
							next.clear();
							break;
						}
					}
					for(int t=0;t<n;t++){
						if((s&(1<<t))>0 && !mark[s][t] && door[pos][t]){
							pre[s][t][0] = s;
							pre[s][t][1] = pos;
							mes[s][t] = move[t];
							mark[s][t] = true;
							next.add(new int[]{s, t});
						}
					}
					for(int k=0;k<sw[pos].length;k++){
						int v = sw[pos][k];
						if((s&(1<<v))>0){
							if(v==pos)continue;
							int ns = s - (1<<v);
							if(!mark[ns][pos]){
								pre[ns][pos][0] = s;
								pre[ns][pos][1] = pos;
								mark[ns][pos] = true;
								mes[ns][pos] = switchoff[v];
								next.add(new int[]{ns, pos});
							}
						}
						else {
							int ns = s + (1<<v);
							if(!mark[ns][pos]){
								pre[ns][pos][0] = s;
								pre[ns][pos][1] = pos;
								mark[ns][pos] = true;
								mes[ns][pos] = switchon[v];
								next.add(new int[]{ns, pos});
							}
						}
					}
				}
				step++;
				l = next;
			}
			if(trueEnding){
				System.out.println("You can go home in " + --step + " steps.");
				int state = 1<<(n-1);
				int p = n-1;
				Stack<String> stack = new Stack<String>();
				while(state!=-1){
					stack.push(mes[state][p]);
					int ns = pre[state][p][0];
					int np = pre[state][p][1];
					state = ns;
					p = np;
				}
				stack.pop();
				while(!stack.isEmpty())System.out.println(stack.pop());
			}
			else 
				System.out.println(reachGoal?"You can not switch off all lights.":"Help me!");
		}
	}
}
