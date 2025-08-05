package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int []A = {25,10,5,1};
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            for(int j = 0; j < 4; j++){
                if(N>=A[j]){
                    int temp = N/A[j];
                    N=N%A[j];
                    System.out.print(temp+" ");
                }
                else System.out.print(0+" ");
            }System.out.println();

        }
    }
}
