package samsung;

import java.util.*;
import java.io.*;
public class swea_21131 {
	static int N;
	static boolean [][]visit;
	public static void main(String args[]) throws Exception
	{
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
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			//sb.append("#").append(test_case).append(" ");
			N = Integer.parseInt(br.readLine());
			int [][]map = new int[N+1][N+1];
			for(int i=1;i<=N;i++)
			{   st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++)
				{
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			visit= new boolean[N+1][N+1];
			for(int i=2;i<=N;i++)
			{
				if(i==N)
				{
					if(map[1][N]==N)break;
					else
					{
						swap(map,i);
						count++;
					}
				}
				else if(map[1][i]==i && map[1][i+1]!=(i+1))
				{
					swap(map,i);
					count++;
				}else if(map[1][i]!=i && map[1][i+1]==(i+1))
				{
					swap(map,i);
					count++;
				}

			}
			sb.append(count).append("\n");

			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
		System.out.print(sb);


	}

	static void swap(int [][]map,int x)
	{
		int i=1;
		for(int j=2;j<=x;j++)
		{
			if(!visit[i][j] && ! visit[j][i])
			{
				int temp = map[j][i];
				map[j][i]=map[i][j];
				map[i][j]=temp;
				visit[i][j]=true;
				visit[j][i]=true;
			}


		}


	}
}