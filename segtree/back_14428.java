package segtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14428 {
	static long []arr;
	static Node []seg;
	static int N, M;
	static class Node{
		int idx;
		long val;
		public Node(int idx,long val)
		{
			this.idx = idx;
			this.val = val;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		arr= new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		seg= new Node[4*N];
		build(1,0,N-1);
		int M =Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{	st= new StringTokenizer(br.readLine());
			int type  = Integer.parseInt(st.nextToken());
			if(type==1)
			{
				int idx = Integer.parseInt(st.nextToken())-1;
				long val = Long.parseLong(st.nextToken());
				update(1,0,N-1,idx,val);
			}else{
				int ql = Integer.parseInt(st.nextToken())-1;
				int qr = Integer.parseInt(st.nextToken())-1;
				sb.append(query(1,0,N-1,ql,qr).idx+1);
			}
		}
	System.out.println(sb);

	}
	static void build(int node,int l,int r)
	{
		if(l==r)
		{
			seg[node] = new Node(l,arr[l]);
			return;
		}
		int mid =  (l+r)/2;
		build(node*2,l,mid);
		build(node*2+1,mid+1,r);
		seg[node] = better(seg[node*2],seg[node*2+1]);
	}
	static Node better(Node a, Node b)
	{
		if(a==null) return b;
		if(b==null)	return a;
		if(a.val!=b.val) return (a.val<b.val)?a:b;
		return (a.idx<b.idx)?a:b;
	}
	static void update(int node,int l,int r, int idx,long val)
	{
		if(idx<l || idx>r) return;
		if(l==r)
		{
			seg[node] = new Node(idx,val);
			return;
		}
		int mid = (l+r)/2;
		if(idx<=mid) update(node*2,l,mid,idx,val);
		else update(node*2+1,mid+1,r,idx,val);
		seg[node] = better(seg[node*2],seg[node*2+1]);
	}
	static Node query(int node,int l,int r,int ql,int qr)
	{
		if(qr<l || r<ql) return null;
		if(l<=ql && qr<=r) return seg[node];
		int mid = (l+r)/2;
		Node L = query(node*2,l,r,ql,mid);
		Node R = query(node*2+1,l,r,mid+1,qr);
		return better(L,R);
	}


	// 값 업데이트 함수


}
