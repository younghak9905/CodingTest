package data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class back_11478 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new java.io.BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		HashMap<String, Integer> map = new HashMap<>();
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (s.substring(i, j).length() > 0) {
					if(map.get(s.substring(i, j)) == null) {
						map.put(s.substring(i, j), 1);
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}
}
