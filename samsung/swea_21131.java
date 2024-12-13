package samsung;

import java.util.*;
import java.io.*;
public class swea_21131 {
	static int N;
	static boolean [][]visit;
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
				 �� �κп� �������� �˰��� ������ ���ϴ�.
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