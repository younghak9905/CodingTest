package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class swea_22574 {

        public static void main(String args[]) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            //  Scanner sc = new Scanner(System.in);
            int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
            StringTokenizer st;
            HashMap<Integer, Integer> map = new HashMap<>();


            for (int test_case = 1; test_case <= T; test_case++) {
                st = new StringTokenizer(br.readLine());
                int N  = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                int max = 0;
                for(int i=1;i<=N;i++)
                {

                    if(P==1 && i==1)  continue;
                    max+=i;
                    if(max==P)
                        max-=1;
                }
                sb.append(max).append("\n");


            }
            System.out.println(sb);
        }

}
//
