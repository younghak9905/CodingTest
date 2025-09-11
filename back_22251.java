import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_22251 {
    static int N,K,P,X;
    static long count =0;
    static int[][]number = {{1,1,0,1,1,1,1},{0,1,0,0,1,0,0},{1,1,1,0,0,1,1},{1,1,1,0,1,1,0},{0,1,1,1,1,0,0},{1,0,1,1,1,1,0},{1,0,1,1,1,1,1},{1,1,0,0,1,0,0},{1,1,1,1,1,1,1},{1,1,1,1,1,1,0}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int []digit = num_to_digit(X);
        check(digit);
        System.out.println(count);


    }
    static void check(int[] digit)
    {
        for(int i=1;i<=N;i++)
        {
            if(i==X) continue;
            if(check_reverse(i,digit))count++;
        }
    }
    static boolean check_reverse(int n,int []digit)
    {

        int result =0;
        int []target = num_to_digit(n);

        for(int i=0;i<K;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(number[digit[i]][j]!=number[target[i]][j]) {
                    result++;
                    if (result > P)
                        return false;

                }
            }
        }
        return true;

    }
    static int[] num_to_digit(int x){
        int []digit = new int[K];
        for(int i=K-1;i>=0;i--)
        {
            digit[i] = x%10;
            x/=10;
        }
        return digit;
    }

}
