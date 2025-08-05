package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_9660 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		if(N%7==0 || N%7==2) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}

	}

}
