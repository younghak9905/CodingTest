package day5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class back_12919 {
	static int can=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S= br.readLine();
		String T =br.readLine();

		recur(S,T);
		System.out.println(can);
	}

	static void recur(String S,String T) {
		if (S.length() == T.length()) {
			if (S.equals(T))
				can = 1;
			return;
		}

		if (T.endsWith("A")) {
			recur(S, T.substring(0, T.length() - 1));
		}

		if (T.startsWith("B")) {
			recur(S, new StringBuilder(T.substring(1)).reverse().toString());
		}
	}

}
