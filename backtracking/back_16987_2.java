package backtracking;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_16987_2 {
	static int MAX = 0;
	static int N;
	static int[][]arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];

		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]= Integer.parseInt(st.nextToken());
		}
		recur(0,0);
		System.out.println(MAX);
	}

	static void recur(int cnt, int now)
	{
		if(cnt==N-1 || now ==N)
		{
			MAX = Math.max(MAX,cnt);
			return;
		}

		if(arr[now][0]<=0)
		{
			recur(cnt,now+1);
		}else {
			for(int i=0;i<N;i++)
			{
				if(i==now) continue;
				if(arr[i][0]>0)
				{
					arr[i][0]-=arr[now][1];
					arr[now][0]-=arr[i][1];
					recur(cnt +(arr[i][0]<=0 ?1 : 0)+ (arr[now][0]<=0 ? 1 : 0),now+1);
					arr[i][0]+=arr[now][1];
					arr[now][0]+=arr[i][1];
				}
			}
		}
	}
}
