import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_13458 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []A = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long result  = 0;
        for(int i=1;i<=N;i++)
        {
            if(A[i]>0)
                result++;
            A[i]-=B;
            if(A[i]>0)
            {
                result+= Math.ceil((double)A[i]/(double)C);
            }
        }
        System.out.println(result);
    }
}
