package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t=0;t<N;t++)
        {   int []big = new int[10];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<10;i++)
            {
                big[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(big);
            sb.append(big[big.length-3]+"\n");
        }
        System.out.print(sb);


    }
}
