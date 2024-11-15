package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_5215 {
    static int N,L,max=0;
    static ArrayList<int[]> list;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //  Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0;i<N;i++)
            {   st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int  l = Integer.parseInt(st.nextToken());
                list.add(new int[]{n,l});
            }
            max=0;


            recur(0,0,0);
            sb.append(max).append("\n");
            }
            System.out.println(sb);

        }
        static void recur(int cnt,int taste,int kcal)
        {
            if(kcal>L)
                return;
            if(cnt==N)
            {
                max = Math.max(max,taste);
                return;
            }
            recur(cnt+1,taste + list.get(cnt)[0],kcal+list.get(cnt)[1]);
            recur(cnt+1,taste,kcal);
        }
    }
