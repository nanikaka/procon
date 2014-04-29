package volume05;

//Walk
public class AOJ0541 {

	int h, w, n;

	class Scanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-') return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}
	}

	void run(){
		Scanner sc = new Scanner();
		while(true){
			h = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();
			if((h|w|n)==0)break;
			int[][] m = new int[h][w];
			for(int i=0;i<h;i++)for(int j=0;j<w;j++)m[i][j]=sc.nextInt();
			int[][] dp = new int[h][w];
			dp[0][0] = n-1;
			for(int j=1;j<w;j++)dp[0][j]=(dp[0][j-1]+m[0][j-1])/2;
			for(int i=1;i<h;i++)dp[i][0]=(dp[i-1][0]+(m[i-1][0]+1)%2)/2;
			for(int i=1;i<h;i++){
				for(int j=1;j<w;j++){
					dp[i][j] = (dp[i-1][j]+(m[i-1][j]+1)%2)/2 + (dp[i][j-1]+m[i][j-1])/2;
				}
			}
			int x = 0;
			int y = 0;
			while(!(x==w||y==h)){
				if((dp[y][x]+m[y][x])%2==0)y++;
				else x++;
			}
			System.out.println(++y+" "+ ++x);
		}
	}

	public static void main(String[] args) {
		new AOJ0541().run();
	}
}
