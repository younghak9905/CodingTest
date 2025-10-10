import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_12738 {
    static int N;
    static long arr[];
    static long list[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
        StringTokenizer st  = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int i=0;i<N;i++)
        {
            arr[i] =Long.parseLong(st.nextToken());
        }
        int ret = 0;
        list = new long[N];
        list[ret] = arr[0];
        for(int i=1;i<N;i++)
        {
            if(arr[i]>list[ret])
            {
                ret++;
                list[ret]=arr[i];
            }
            int pos = binary(0,ret,arr[i]);
            list[pos] = arr[i];
        }

        System.out.println(ret+1);
    }
    static int binary(int start,int end,long target)
    {
        while(start<end)
        {
            int mid = (start+end)/2;
            if(target>list[mid]) start = mid+1;
            else end = mid;
        }
        return end;
    }
}
