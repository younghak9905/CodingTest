import java.io.BufferedReader;
import java.util.StringTokenizer;

public class back_14427 {


	static int N, M;
	static long[] arr;
	static Node[] seg;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i] = Long.parseLong(st.nextToken());
		}

		seg = new Node[4 * N];
		build(1, 0, N - 1);

		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			if(query==1)
			{
				int idx = Integer.parseInt(st.nextToken())-1;
				long val = Long.parseLong(st.nextToken());
				update(1, 0, N - 1, idx, val);
			}else{
				System.out.println(seg[1].idx+1);
			}
		}
	}
	static class Node {
		long val;  // 구간의 최소값
		int idx;   // 그 최소값의 "가장 작은" 인덱스
		Node(long v, int i) { val = v; idx = i; }
	}

	static Node better(Node a, Node b) {
		if (a == null) return b;
		if (b == null) return a;
		if (a.val != b.val) return (a.val < b.val) ? a : b;
		return (a.idx < b.idx) ? a : b;
	}

	static void build(int node, int l, int r) {
		if (l == r) {
			seg[node] = new Node(arr[l], l);
			return;
		}
		int mid = (l + r)/2;
		build(node*2, l, mid);//left
		build(node*2+1, mid + 1, r);//right
		seg[node] = better(seg[node*2], seg[node*2+1]);
	}

	// 점 갱신: arr[idx] = newVal
	static void update(int node, int l, int r, int idx, long newVal) {
		if (idx < l || idx > r) return;
		if (l == r) {
			seg[node] = new Node(newVal, l);
			return;
		}
		int mid = (l + r) >>> 1;
		if (idx <= mid) update(node << 1, l, mid, idx, newVal);
		else            update(node << 1 | 1, mid + 1, r, idx, newVal);
		seg[node] = better(seg[node << 1], seg[node << 1 | 1]);
	}

	// (필요 시) 구간 질의: [ql, qr]의 (최솟값, 인덱스)
	static Node query(int node, int l, int r, int ql, int qr) {
		if (qr < l || r < ql) return null;
		if (ql <= l && r <= qr) return seg[node];
		int mid = (l + r) >>> 1;
		Node L = query(node*2, l, mid, ql, qr);
		Node R = query(node*2+1, mid + 1, r, ql, qr);
		return better(L, R);
	}
}
