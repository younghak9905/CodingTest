package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11055 {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N+1];
        int []D = new int[N+1];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            D[i]= arr[i];

        }
        int max = 0;
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=i;j++)
            {
                if(arr[j]<arr[i])
                {
                    D[i]= Math.max(D[i],D[j]+arr[i]);
                }
            }
            max = Math.max(D[i],max);
        }
        System.out.println(max);
    }
}
