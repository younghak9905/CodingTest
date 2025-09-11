import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  back_10025{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())*2+1;
        long []map = new long[1000001];
        long max = 0;
        long sum =0;
        for(int i=0;i<N;i++)
        {   st = new StringTokenizer(br.readLine());
            int v= Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[x] = v;

        }
        for(int i=0;i<=1_000_000;i++)
        {
            if(i-K>=0) sum-=map[i-K];
            sum+=map[i];
            max = Math.max(max,sum);
        }
        System.out.println(max);
    }
}
