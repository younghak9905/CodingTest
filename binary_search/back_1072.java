package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1072 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = Y*100/X;
        if(X==Y || Z ==99){
            System.out.println(-1);
            return;
        }
        long temp = Z;
        int start =1;
        int end =Integer.MAX_VALUE;
        while (start<=end)
        {
            int mid = start+(end-start)/2;
            if(((Y+mid)*100 /(X+mid))==temp)
                start = mid +1;
            else
                end = mid-1;
        }
        System.out.println(start);
    }
}
