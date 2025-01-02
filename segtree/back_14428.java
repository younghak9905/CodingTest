package segtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14428 {
	static long []arr;
	static int []minTree;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr= new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int treeSize = calculateSegmentTreeSize(N);
		minTree = new int[treeSize];
		buildMinTree(1, 1, N);
		minTree[0] = Integer.MAX_VALUE;
		M = Integer.parseInt(br.readLine());

		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==1)
			{
				arr[b] = c;
				update(1,1,N,b);
			}else {
				System.out.println(queryMin(1,1,N,b,c));
			}
		}
	}
	static int buildMinTree(int node, int start, int end) {
		if (start == end) {
			return minTree[node] = start;
		}
		int mid = (start + end) / 2;
		int leftMin = buildMinTree(node * 2, start, mid);
		int  rightMin = buildMinTree(node * 2 + 1, mid + 1, end);
		return minTree[node] = minIndex(leftMin, rightMin);
	}

	static int calculateSegmentTreeSize(int n) {
		int height = (int) Math.ceil(Math.log(n) / Math.log(2));
		return (1 << (height + 1)) - 1;
	}


	// 구간 최솟값 질의
	static int queryMin(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return minTree[node];
		}
		int mid = (start + end) / 2;
		int leftMin = queryMin(node * 2, start, mid, left, right);
		int rightMin = queryMin(node * 2 + 1, mid + 1, end, left, right);
		return minIndex(leftMin, rightMin);
	}

	static int minIndex(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		return arr[a] < arr[b] ? a : b;
	}

	// 값 업데이트 함수
	static int update(int node, int start, int end, int target) {
		if (target < start || target > end) {
			return minTree[node]; // 범위 밖
		}
		if (start == end) { // 리프 노드 업데이트
			return minTree[node];
		}
		int mid = (start + end) / 2;
		int leftMin = update(node * 2, start, mid, target);
		int rightMin = update(node * 2 + 1, mid + 1, end, target);
		return minTree[node] = minIndex(leftMin, rightMin);
	}


	// 구간 최댓값 질의

}
