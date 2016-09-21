import java.util.Scanner;

public class CCI_Q2_1 {
	
	
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt();
			n = ~n;
			int cnt = 0;
			while (n != 0) {
				n &= n - 1;
				cnt++;
			}
			System.out.println(cnt);
		}
		s.close();
	}
	

}
