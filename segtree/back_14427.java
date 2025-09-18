package segtree;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class back_14427 {
	static int N;
	static long []arr;
	static Node[]seg;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i] = Long.parseLong(st.nextToken());
		}
		seg = new Node[4*N];
		build(1,0,N-1);
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if(type==1)
			{
				int idx = Integer.parseInt(st.nextToken())-1;
				long val = Long.parseLong(st.nextToken());
				update(1,0,N-1,idx,val);
			}else{
				System.out.println(seg[1].idx+1);
			}
		}
	}
	static void build(int node,int start,int end)
	{
		if(start == end)
		{
			seg[node] = new Node(arr[start],start);
			return;
		}
		int mid = (start+end)/2;
		build(node*2,start,mid);
		build(node*2+1,mid+1,end);
		seg[node] = better(seg[node*2],seg[node*2+1]);

	}
	static Node better(Node a,Node b)
	{
		if(a==null) return b;
		if(b==null) return a;
		if(a.val!=b.val) return (a.val<b.val)?a:b;
		return (a.idx<b.idx)?a:b;
	}
	static void update(int node,int start,int end,int idx,long val)
	{
		if(idx<start || idx>end) return;
		if(start==end)
		{
			seg[node] = new Node(val,start);
			return;
		}
		int mid = (start+end)/2;
		if(idx<=mid) update(node*2,start,mid,idx,val);
		else update(node*2+1,mid+1,end,idx,val);
		seg[node] = better(seg[node*2],seg[node*2+1]);
	}

	static class Node{
		int idx;
		long val;
		Node(long v, int i){val = v; idx = i;}
	}

}
