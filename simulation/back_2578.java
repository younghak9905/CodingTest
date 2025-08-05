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
				mapIndex.put(map[i][j], new int[]{i, j}); // 숫자와 그 위치를 저장
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
					check[position[0]][position[1]] = true; // 해당 숫자의 위치를 체크
					list.add(new int[]{position[0], position[1]}); // 해당 숫자의 위치를 리스트에 추가
					if(i>=2)
					{
						if(checkBingo(check, position[0], position[1])) // 빙고 체크
						{
							System.out.println(i * 5 + j + 1); // 몇 번째 숫자인지 출력
							return; // 빙고가 완성되면 종료
						}

					}
			}
		}

	}
	static boolean checkBingo(boolean[][] check, int x, int y)
	{

		//대각선

			if(!row[x]) {
				if (check[x][0] && check[x][1] && check[x][2] && check[x][3] && check[x][4]) // 가로 체크
				{
					row[x] = true; // 해당 행 체크 완료
					result++; // 빙고 카운트 증가
				}
			}
			if(!col[y]) {
				if (check[0][y] && check[1][y] && check[2][y] && check[3][y] && check[4][y]) // 세로 체크
				{
					col[y] = true; // 해당 열 체크 완료
					result++; // 빙고 카운트 증가
				}
			}
		 if(!right[0]) {
			if ((x == 4 && y == 0) || x == 3 && y == 1 || x == 2 && y == 2 || x == 3 && y == 1
				|| x == 4 && y == 0) // 오른쪽 대각선 체크

			{
				if (check[0][4] && check[1][3] && check[2][2] && check[3][1] && check[4][0]) {
					right[0] = true; // 오른쪽 대각선 체크 완료
					result++; // 빙고 카운트 증가
				}
			}

		}
		if(!right[1]) {

			if ((x == 0 && y == 0) || (x == 1 && y == 1) || (x == 2 && y == 2) || (x == 3 && y == 3) || (x == 4
				&& y == 4)) // 왼쪽 대각선 체크
			{

				if (check[0][0] && check[1][1] && check[2][2] && check[3][3] && check[4][4]) {
					right[1] = true; // 왼쪽 대각선 체크 완료
					result++; // 빙고 카운트 증가
				}

			}
		}

		if(result >=3) // 3개 이상의 빙고가 완성되면
		{

			return true;
		}
		return false;
	}




}
