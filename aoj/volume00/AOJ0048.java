package volume0;

import java.util.Scanner;

//Class
public class AOJ0048 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double x = sc.nextDouble();
			System.out.println(x<=48?"light fly":
				x<=51?"fly":
				x<=54?"bantam":
				x<=57?"feather":
				x<=60?"light":
				x<=64?"light welter":
				x<=69?"welter":
				x<=75?"light middle":
				x<=81?"middle":
				x<=91?"light heavy":"heavy");
		}
	}
}
