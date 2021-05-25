import java.util.Scanner;

public class Main{
	public static void main(String[] args){

               

		Scanner scan = new Scanner(System.in);
		int th = scan.nextInt();
		int vm = scan.nextInt();
		
	


		System.out.printf("%.3f\n", ( th * vm )/12.0);
	}
}
