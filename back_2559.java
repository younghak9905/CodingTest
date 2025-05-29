import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int []A = new int[N+1];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(i<K)
            {
                sum += A[i];
            }else if(i==K){
                sum += A[i];
                if(max < sum)
                    max = sum;
            }
            else{
                sum -= A[i-K];
                sum += A[i];
                if(max < sum)
                    max = sum;
            }
        }
        System.out.println(max);
    }
}
