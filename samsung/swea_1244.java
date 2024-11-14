package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_1244 {
	static Stack<Integer> result = new Stack<>();
	static String str;
	static int max;
	public static void main(String args[]) throws Exception {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			str= st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			if(N>=5)
			{
				Character[] digits = new Character[str.length()];
				for (int i = 0; i < str.length(); i++) {
					digits[i] = str.charAt(i);
				}

				// 2. 배열을 내림차순으로 정렬
				Arrays.sort(digits, Collections.reverseOrder());

				// 3. 정렬된 배열을 문자열로 변환
				StringBuilder s = new StringBuilder();
				for (char c : digits) {
					s.append(c);
				}
				str = s.toString();
				N=N-5;
			}
			for(int i=0;i<N;i++)
			{
				max=0;
				recur(0,new boolean[str.length()]);
				str=""+max;
				result.clear();
			}
			sb.append(str).append("\n");

		}
		System.out.println(sb);
	}
	static int circle(int f,int s)
	{
		String temp = str;
		char[] c = temp.toCharArray();
		char tc = c[f];
		c[f]=c[s];
		c[s]=tc;
		temp = new String(c);
		return Integer.parseInt(temp);

	}
	static void recur(int cnt,boolean[] visited)
	{
		if(cnt==2)
		{

			int f = result.get(0);
			int s = result.get(1);
			int temp= Integer.parseInt(str);
			if(str.charAt(f)!=str.charAt(s))
			{
				temp= circle(f,s);
			}
			if(max<temp)
				max = temp;

			return;
		}

		for(int i=0;i<visited.length;i++)
		{
			if(!visited[i])
			{
				visited[i]=true;
				result.push(i);
				recur(cnt+1,visited);
				result.pop();
				visited[i]=false;
			}
		}
	}
}
//3
// 123 1
// 2737 1
// 32888 2
