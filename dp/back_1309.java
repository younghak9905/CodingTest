package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_1309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        long [][]D = new long[N+1][2];

        //D[1] = 1+2
        //D[2] = 1+(2+2)+2
        //D[3] = 1+(2+2+2)+(3+3+2)+2



        D[N][0]=D[N-1][1]+1;
        D[N][1]=D[N-1][0]+1;

    }
}
