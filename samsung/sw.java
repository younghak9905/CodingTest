package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sw {
	public class swea_1206 {
		public static void main(String args[]) throws Exception {
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
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			StringTokenizer st;
			Scanner sc = new Scanner(System.in);
			//int T = Integer.parseInt(br.readLine());
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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
