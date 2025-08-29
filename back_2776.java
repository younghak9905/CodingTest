import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class back_2776 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		while(T-->0){
			int N = Integer.parseInt(br.readLine());
			HashSet<Integer> set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				set.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<M;i++)
			{
				if(set.contains(Integer.parseInt(st.nextToken()))) {
					sb.append("1\n");
				}else{
					sb.append("0\n");
				}
			}
			System.out.print(sb);
		}
	}
}
