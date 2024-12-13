package segtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2357 {
    static long []arr;
    static long []maxTree;
    static long []minTree;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        arr= new long[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int treeSize = calculateSegmentTreeSize(N);
        minTree = new long[treeSize];
        maxTree = new long[treeSize];

        buildMinTree(1, 1, N);
        buildMaxTree(1, 1, N);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long minVal = queryMin(1, 1, N, a, b);
            long maxVal = queryMax(1, 1, N, a, b);
            sb.append(minVal).append(" ").append(maxVal).append("\n");
        }
        System.out.print(sb);
    }

    static long buildMinTree(int node, int start, int end) {
        if (start == end) {
            return minTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        long leftMin = buildMinTree(node * 2, start, mid);
        long rightMin = buildMinTree(node * 2 + 1, mid + 1, end);
        return minTree[node] = Math.min(leftMin, rightMin);
    }

    static long buildMaxTree(int node, int start, int end) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        long leftMax = buildMaxTree(node * 2, start, mid);
        long rightMax = buildMaxTree(node * 2 + 1, mid + 1, end);
        return maxTree[node] = Math.max(leftMax, rightMax);
    }



    static int calculateSegmentTreeSize(int n) {
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        return (1 << (height + 1)) - 1;
    }


    // 구간 최솟값 질의
    static long queryMin(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return minTree[node];
        }
        int mid = (start + end) / 2;
        long leftMin = queryMin(node * 2, start, mid, left, right);
        long rightMin = queryMin(node * 2 + 1, mid + 1, end, left, right);
        return Math.min(leftMin, rightMin);
    }

    // 구간 최댓값 질의
    static long queryMax(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }
        int mid = (start + end) / 2;
        long leftMax = queryMax(node * 2, start, mid, left, right);
        long rightMax = queryMax(node * 2 + 1, mid + 1, end, left, right);
        return Math.max(leftMax, rightMax);
    }
}
