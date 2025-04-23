package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String  N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        long sum = 0;
        long tmp = 1;
        for(int i=N.length()-1;i>=0;i--)
        {
            char c = N.charAt(i);
            if('0'<=c&&c<='9')
                sum+=(c-'0')*tmp;
            else
                sum+=(c-'A'+10)*tmp;
            tmp*=B;
        }
        System.out.println(sum);
    }

    //10111
}
