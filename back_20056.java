import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_20056 {
	static int []dx= {0,1,1,1,0,-1,-1,-1};
	static int []dy= {-1,-1,0,1,1,1,0,-1};
	static int N;
	public static void main(String[]args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Fire> queue = new java.util.LinkedList<>();
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); //위치
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); //질량
			int s = Integer.parseInt(st.nextToken()); //속력
			int d = Integer.parseInt(st.nextToken()); //방향
			queue.add(new Fire(r,c,m,s,d,1));
		}
		Fire [][]map = new Fire[N+1][N+1];

		while(K-->0)
		{
			while (!queue.isEmpty()) {

				Fire now = queue.poll();

				int nr = link(now.r + (dy[now.d] * now.s));
				int nc = link(now.c + (dx[now.d] * now.s));
				if(map[nr][nc]==null)
				{
					map[nr][nc]=new Fire(nr,nc,now.m,now.s,now.d,1);
				}else{
					Fire exist = map[nr][nc];
					exist.m+=now.m;
					exist.s+=now.s;
					exist.n+=1;
					exist.allEven&=(now.d%2==0);
					exist.allOdd&=(now.d%2==1);
					exist.d= (exist.d==now.d || exist.d==8 || now.d==8)? exist.d:8;
					map[nr][nc]=exist;
				}
			}

			for(int i=1;i<=N;i++)
			{
				for(int j=1;j<=N;j++)
				{
					if(map[i][j]!=null)
					{
						Fire f = map[i][j];
						if(f.n>=2)
						{
							int nm = f.m/5;
							int ns = f.s/f.n;
							int []drs = (f.allEven || f.allOdd)? new int[]{0,2,4,6} : new int[]{1,3,5,7};
							for(int d:drs)
							{
								if(nm>0)
								{
									queue.add(new Fire(i,j,nm,ns,d,1));
								}
							}
						}
						else
						{
							queue.add(new Fire(i,j,f.m,f.s,f.d,1));
						}
						map[i][j]=null;
					}

				}
			}
		}
		int result =0;
		while(!queue.isEmpty())
		{
			result+=queue.poll().m;
		}
		System.out.println(result);
	}

	static class Fire{
		int r,c;
		int m,s,d;
		int n;
		boolean allEven=true;
		boolean allOdd=true;
		Fire(int r,int c,int m,int s,int d,int n)
		{
			this.r=r;
			this.c=c;
			this.m=m;
			this.s=s;
			this.d=d;
			this.n=n;
			this.allEven=(d%2==0);
			this.allOdd=(d%2==1);
		}
	}
	static int link(int d)
	{
		d %= N;        // 0 ~ N-1 로
		if (d <= 0) d += N; // 1 ~ N 으로 맞추기
		return d;
	}
}
