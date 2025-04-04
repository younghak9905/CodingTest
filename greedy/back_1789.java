package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long i=0;
        long count=0;
        while (S>=count)
        {

            count+=++i;

        }
        System.out.println(i-1);




    }
}
