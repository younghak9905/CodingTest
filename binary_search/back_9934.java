package binary_search;
import java.io.*;
import java.util.*;
public class back_9934 {
	static List<ArrayList<Integer>> list;
	static int N;
	static int[]arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[(int)Math.pow(2, N) - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		inOrder(0,arr.length-1,0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				sb.append(list.get(i).get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());

	}


	public static void inOrder(int start,int end,int depth) {
		if(depth==N)
		{
			return;
		}

		int mid = (start + end) / 2;
		list.get(depth).add(arr[mid]);
		inOrder(start, mid - 1, depth + 1);
		inOrder(mid + 1, end, depth + 1);
	}

}
