package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int size = 45*46/2;
        int []C = new int[size+1];
        int []D = new int[size+1];

        D[0] = 0;
        int count=1;
        for(int i=1;i<=45;i++)
        {
            for(int j=1;j<=i;j++)
            {
                C[count++]=i;
            }
        }
        for(int i=1;i<=B;i++)
        {
            D[i]+=D[i-1]+C[i];
        }
        System.out.println(D[B]-D[A-1]);
    }
}

