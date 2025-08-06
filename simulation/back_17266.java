package simulation;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class back_17266 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        int end = N;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(A, mid, N)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

    static boolean check(int[] A, int mid, int N) {
        int index =0;


        for(int i=0;i<=N;i++)
        {
            if((A[index]-mid)<= i && i <= (A[index]+mid)) {

                i=A[index]+mid;
                if(index < A.length-1 && (A[index+1]-mid) <= i) {
                    index++;
                }

            }else{
                return false;
            }

        }


        return true;
    }

}
