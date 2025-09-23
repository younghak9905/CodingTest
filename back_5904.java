import java.io.BufferedReader;
import java.io.InputStreamReader;
public class back_5904 {

    static long[] S;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        S = new long[60];
        //S(0) 3						//3
        //S(1) = S(0) + A(1)+S(0)  3+4+3 //10   S(k-1) + k+3 + S(k-1)
        //S(2) = S(1) + A(2) + S(1) 10+5+10  //25
        int k =0;
        S[0] = 3;
        while(S[k]<N)
        {
            k++;
            S[k] = S[k-1] *2 + (k+3);
        }

        char result = solve(k,N);
        System.out.println(result);
    }
    static char solve(int k,long n){
        if(k==0)
        {
            if(n ==1) return 'm';
            else return 'o';
        }
        long left = S[k-1];
        long mid = k+3;
        if(n<=left)
            return solve(k-1,n);
        else if(n<=left+mid)
        {
            if(n==left+1) return 'm';
            else return 'o';
        }else{
            return solve(k-1,n-left-mid);
        }
    }
}

