import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_16975 {
	static int N;
	static long[] arr;
	static long[] seg;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr= new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]= Integer.parseInt(st.nextToken());
		}
		seg = new long[N*4];
		build(1,0,N-1);
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if(type==1)
			{
				int ql = Integer.parseInt(st.nextToken())-1;
				int qr = Integer.parseInt(st.nextToken())-1;
				long k = Integer.parseInt(st.nextToken());
				update(1,0,N-1,ql,qr,k);
			}else{
				int x = Integer.parseInt(st.nextToken())-1;
				sb.append(	search(1,0,N-1,x)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void build(int node,int l,int r)
	{
		if(l==r)
		{
			seg[node] = arr[l];
			return;
		}
		int mid = (l+r)/2;
		build(node*2,l,mid);
		build(node*2+1,mid+1,r);

	}
	static void update(int node,int l,int r,int ql,int qr,long k)
	{
		if(qr<l || r<ql)
		{
			return;
		}
		if(ql<=l && r<=qr)
		{
			seg[node]+=k;
			return;
		}
		int mid = (l+r)/2;
		if(l<=mid)   update(node*2,l,mid,ql,qr,k);
		if(r>mid)	update(node*2+1,mid+1,r,ql,qr,k);

	}
	static long search(int node,int l,int r,int idx)
	{
		if(l==r)
			return seg[node];
		int mid  = (l+r)/2;
		if(idx<=mid) return search(node*2,l,mid,idx)+seg[node];
		if(idx>mid)  return search(node*2+1,mid+1,r,idx)+seg[node];
		return 0;
	}

}
