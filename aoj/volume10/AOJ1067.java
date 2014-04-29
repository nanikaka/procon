package volume10;

import java.util.Scanner;

//Cutting a Chocolate
public class AOJ1067 {

	public static boolean isLeft(double x1, double y1, double x2, double y2, double x3, double y3){
		x2 -= x1;
		y2 -= y1;
		x3 -= x1;
		y3 -= y1;
		return x2*y3-x3*y2 > 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			int s = sc.nextInt();
			if(n==0&&m==0&&w==0&&h==0&&s==0)break;
			int[] left = new int[m+2];
			int[] right = new int[m+2];
			left[0] = right[0] = 0;
			left[m+1] = right[m+1] = h;
			for(int i=0;i<m;i++){
				left[i+1] = sc.nextInt();
				right[i+1] = sc.nextInt();
			}
			double[] area = new double[m+1];
			for(int i=0;i<m+1;i++){
				area[i] = (left[i+1]-left[i]+right[i+1]-right[i])*w/2.0;
			}
			int minArmond = n;
			double[] sum = new double[m+1];
			sum[0] = area[0];
			int aa = -1;
			if(sum[0]>=s)aa=0;
			for(int i=1;i<m+1;i++){
				sum[i] = sum[i-1]+area[i];
				if(aa==-1&&sum[i]>=s)aa=i;
			}
			int[] armond = new int[m+1];
			while(n--!=0){
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				int up = m+1;
				int down = 0;
				int pos = 0;
				while(true){
					if(up-down<=1){
						if(isLeft(0, left[up], w, right[up], x, y)){
							pos = up;
						}
						else pos = down;
						break;
					}
					int mid = (up+down)/2;
					if(isLeft(0, left[mid], w, right[mid], x, y)){
						down = mid;
					}
					else up = mid;
				}
				armond[pos]++;
			}
			int[] armondSum = new int[m+1];
			armondSum[0] = armond[0];
			for(int i=1;i<m+1;i++)armondSum[i]=armondSum[i-1]+armond[i];
			minArmond = Math.min(minArmond, armondSum[aa]);
			double areaSum = 0;
			int everArmond = 0;
			for(int i=m;i>0;i--){
				areaSum += area[i];
				everArmond += armond[i];
				if(s <= areaSum){
					minArmond = Math.min(minArmond, everArmond);
					continue;
				}
				int up = i-1;
				int down = 0;
				int pos = 0;
				while(true){
					if(up-down<=1){
						if(areaSum+sum[down] >= s){
							pos = down;
						}
						else pos = up;
						break;
					}
					int mid = (up+down)/2;
					if(areaSum + sum[mid] >= s){
						up = mid;
					}
					else down = mid;
				}
				minArmond = Math.min(minArmond, everArmond+armondSum[pos]);
			}
			System.out.println(minArmond);
		}
	}
}
