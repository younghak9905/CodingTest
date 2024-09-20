package weak0;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class back_1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<String> list = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		tNode root = new tNode();


			while(N>0) {
				tNode now = root;
				st = new StringTokenizer(br.readLine());
				char[] S = st.nextToken().toCharArray();
				for (int j = 0; j < S.length; j++) {
					if (now.next[S[j] - 'a'] == null) {
						now.next[S[j] - 'a'] = new tNode();
					}
					now = now.next[S[j] - 'a'];
					if (j == S.length - 1) {
						now.isEnd = true;
					}
				}
				N--;
			}
		int count =0;
			while (M>0)
			{
				tNode now = root;
				st = new StringTokenizer(br.readLine());
				char[] S = st.nextToken().toCharArray();
				for (int j = 0; j < S.length; j++) {
					if (now.next[S[j] - 'a'] == null) {
						break;
					}
					now = now.next[S[j] - 'a'];
					if (j == S.length - 1) {
						if (now.isEnd) {
							list.add(new String(S));
							count++;
						}

					}
				}
				M--;
			}
			System.out.println(count);
			if(list.size()>0)
			{
				Collections.sort(list);
				for(String s : list)
				{
					sb.append(s).append("\n");
				}
				System.out.println(sb);
			}



	}

	static class tNode{
		tNode[] next = new tNode[26];
		boolean isEnd;
	}

}
