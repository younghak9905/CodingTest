import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;

        for(int i=0;i<N;i++)
        {
            int K = Integer.parseInt(st.nextToken());
            if(isPrime(K))
            {
                res++;
            }
        }
        System.out.println(res);


    }

    static boolean isPrime(int n)
    {
        if(n<2)
            return false;
        for(int i=2;i<=(int)Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
