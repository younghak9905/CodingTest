import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1365 {
    static int []dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []arr = new int[N+1];
        for(int i=1;i<=N;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1];

        int len = 0;
        int idx =0;
        for(int i=1;i<=N;i++)
        {
            if(arr[i]>dp[len])
            {
                dp[++len] = arr[i];
            }
           else{
               idx = binary(0,len,arr[i]);
               dp[idx] = arr[i];
            }
        }
        System.out.println(N-len);
    }

    static int binary(int start,int end,int target)
    {

        while(start<=end)
        {
            int mid = (start +end)/2;
            if(dp[mid]>target)
            {
                end = mid-1;
            }else{
                start= mid + 1;
            }
        }
        return end;
    }

}
