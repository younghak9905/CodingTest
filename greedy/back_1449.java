package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_1449 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count=0;
        int result=0;
        int start= 0;
        int end = A[0]+L-1; //2
        for(int i=0;i<N;)
        {
            int j=i;
            while(j<N)
            {
                start=A[i];  //100
                end = A[i]+L-1;  //101
                if(A[j]>=start && A[j]<=end) //0,1
                {
                    j++;
                }
                else{
                    break;
                }
            }//2
            result++;
          //  System.out.println("start: "+start+" end: "+end);
            i=j;//2


        }

        System.out.println(result);


        }

        //1 2 4 6

}
