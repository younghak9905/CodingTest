package IT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11723 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int []A = new int[21];
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch (cmd) {
			case "add":
				A[Integer.parseInt(st.nextToken())] = 1;
				break;
			case "remove":
				A[Integer.parseInt(st.nextToken())] = 0;
				break;
			case "check":
				sb.append(A[Integer.parseInt(st.nextToken())]+"\n");
				break;
			case "toggle":
				int idx = Integer.parseInt(st.nextToken());
				if(A[idx]==1)
				{
					A[idx]=0;
				}
				else
				{
					A[idx]=1;
				}
				break;
			case "all":
				for(int j=1;j<=20;j++)
				{
					A[j]=1;
				}
				break;
			case "empty":
				for(int j=1;j<=20;j++)
				{
					A[j]=0;
				}
				break;
			}

		}
		System.out.println(sb);
	}
}
