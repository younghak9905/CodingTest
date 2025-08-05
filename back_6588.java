import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_6588 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;

			boolean found = false;
			for (int i = 3; i <=(int)Math.sqrt(n)+3; i += 2) {
				if (isPrime(i) && isPrime(n - i)) {
					System.out.println(n + " = " + i + " + " + (n - i));
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}




	}

	static boolean isPrime(int n)
	{
		if(n<2)
			return false;
		for(int i=2;i<=(int)Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
}
