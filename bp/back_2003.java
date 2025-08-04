package bp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class back_2003 {
	public static void main(String []args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int []sums = new int[N+1];
		sums[0] = 0;
		for(int i=1;i<=N;i++)
		{
			sums[i] =sums[i-1]+Integer.parseInt(st.nextToken());
		}
		int result = 0;
		int left=1;
		int right=1;
		while (left<=N && right<=N)
		{
			int sum =  (right<=N ? sums[right] : sums[N]) - sums[left-1];
			if(sum>M) {
				left++;
			}else if(sum<M) {
				right++;
			}else{
				result++;
				left++;
			}
		}
		System.out.println(result);


	}

}
