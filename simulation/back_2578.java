package simulation;
import java.io.*;
import java.util.*;
public class back_2578 {
	static ArrayList<int[]> list;
	static boolean row[] = new boolean[5];
	static boolean col[] = new boolean[5];
	static boolean right[] = new boolean[2];
	static int result=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[5][5];
		boolean[][] check = new boolean[5][5];
		HashMap<Integer, int[]> mapIndex = new HashMap<>();
		int [][] bingo = new int[5][5];
		StringTokenizer st;
		for(int i=0;i<5;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				mapIndex.put(map[i][j], new int[]{i, j}); // ���ڿ� �� ��ġ�� ����
			}
		}
		list = new ArrayList<>();


		for(int i=0;i<5;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++)
			{
				bingo[i][j] = Integer.parseInt(st.nextToken());

					int[] position = mapIndex.get(bingo[i][j]);
					check[position[0]][position[1]] = true; // �ش� ������ ��ġ�� üũ
					list.add(new int[]{position[0], position[1]}); // �ش� ������ ��ġ�� ����Ʈ�� �߰�
					if(i>=2)
					{
						if(checkBingo(check, position[0], position[1])) // ���� üũ
						{
							System.out.println(i * 5 + j + 1); // �� ��° �������� ���
							return; // ���� �ϼ��Ǹ� ����
						}

					}
			}
		}

	}
	static boolean checkBingo(boolean[][] check, int x, int y)
	{

		//�밢��

			if(!row[x]) {
				if (check[x][0] && check[x][1] && check[x][2] && check[x][3] && check[x][4]) // ���� üũ
				{
					row[x] = true; // �ش� �� üũ �Ϸ�
					result++; // ���� ī��Ʈ ����
				}
			}
			if(!col[y]) {
				if (check[0][y] && check[1][y] && check[2][y] && check[3][y] && check[4][y]) // ���� üũ
				{
					col[y] = true; // �ش� �� üũ �Ϸ�
					result++; // ���� ī��Ʈ ����
				}
			}
		 if(!right[0]) {
			if ((x == 4 && y == 0) || x == 3 && y == 1 || x == 2 && y == 2 || x == 3 && y == 1
				|| x == 4 && y == 0) // ������ �밢�� üũ

			{
				if (check[0][4] && check[1][3] && check[2][2] && check[3][1] && check[4][0]) {
					right[0] = true; // ������ �밢�� üũ �Ϸ�
					result++; // ���� ī��Ʈ ����
				}
			}

		}
		if(!right[1]) {

			if ((x == 0 && y == 0) || (x == 1 && y == 1) || (x == 2 && y == 2) || (x == 3 && y == 3) || (x == 4
				&& y == 4)) // ���� �밢�� üũ
			{

				if (check[0][0] && check[1][1] && check[2][2] && check[3][3] && check[4][4]) {
					right[1] = true; // ���� �밢�� üũ �Ϸ�
					result++; // ���� ī��Ʈ ����
				}

			}
		}

		if(result >=3) // 3�� �̻��� ���� �ϼ��Ǹ�
		{

			return true;
		}
		return false;
	}




}
