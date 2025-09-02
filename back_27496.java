import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_27496 {
    static double mod = 0.001;
    static int count =0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double sum =0;
        double []a= new double[N+1];
        for(int i=0;i<L;i++)
        {
            a[i] = Double.parseDouble(st.nextToken());
            sum+=a[i];
            check(sum);
        }
        for(int i=L;i<N;i++)
        {
            sum-=a[i-L];
            a[i] = Double.parseDouble(st.nextToken());
            sum+=a[i];
            check(sum);
        }
        System.out.println(count);
    }
    static void check(double sum)
    {
        if(0.129<=sum*mod && sum*mod<=0.138)
            count++;
    }
}
