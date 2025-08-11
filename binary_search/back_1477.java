package binary_search;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_1477 {
    public static void main(String[] args) throws Exception {
        // This is a placeholder for the main method.
        // The actual implementation will depend on the specific problem requirements.
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }
        A[0] = 0; // Starting point
        A[N + 1] = L; // Ending point
        Arrays.sort(A);
        int max =0;
        for(int i=1;i<=N-1;i++)
        {
            int length = A[i + 1] - A[i];
            max = Math.max(max, length);
        }
        int start = 1;
        int end = L-1;
        while(start<=end)
        {
            int mid = start + (end - start) / 2;
            int sum=0;

            for(int i=1;i<=N+1;i++)
            {
                int length = A[i] - A[i-1];
                sum += (length - 1) / mid; // Calculate the number of additional rest areas needed

            }
            if(sum>M)
            {
               start =mid +1; // Try to minimize the maximum distance
            } else {
                end = mid -1; // Increase the minimum distance
            }
        }
        System.out.println(start);



    }

}
