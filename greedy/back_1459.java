package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1459 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

            long X = Long.parseLong(st.nextToken());
            long Y = Long.parseLong(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            long result = 0;
            if (2 * W > S) {
                long cross = Math.abs(X - Y);
                result = (Math.max(X, Y) - cross) * S;
                if(W>S)
                {
                    result+=cross * S;
                }else{
                    result+=cross*W;
                }
            } else {
                result = W * (X + Y);
            }

            System.out.println(result);
        }





    }

