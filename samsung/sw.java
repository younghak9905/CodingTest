package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sw {
	public class swea_1206 {
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
			//int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

			for (int test_case = 1; test_case <= 10; test_case++) {

				sb.append("#").append(test_case).append(" ");
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int D = Integer.parseInt(st.nextToken());
				int X = Integer.parseInt(st.nextToken());
				int []box = new int[N+1];
				st = new StringTokenizer(br.readLine());
				for(int i=1;i<=N;i++)
				{
					box[i]=Integer.parseInt(st.nextToken());
				}
				if(D<X)
				{
					for(int i=X;i>=D+1;i--)
					{
						box[D]+=box[i];
					}
				}
				else {

				}
				for(int i=X;i>=D+1;i--)
				{

				}



			}
			System.out.println(sb);
		}
	}
}
