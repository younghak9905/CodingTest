package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class swea_1984 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      //  Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringTokenizer st;
        HashMap<Integer,Integer> map = new HashMap<>();


        for (int test_case = 1; test_case <= T; test_case++) {
            int max =0;
            int min  = 10001;
            st = new StringTokenizer(br.readLine());
            sb.append("#").append(test_case).append(" ");
            for(int i=0;i<10;i++)
            {
                int input = Integer.parseInt(st.nextToken());
                map.put(input,map.getOrDefault(input,1)+1);
                if(max<input) max = input;
                if(min>input) min = input;
            }
            int result=0;
            int count=0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                if(entry.getKey()==max || entry.getKey()==min) continue;
                result+=entry.getKey() * entry.getValue();
                count +=entry.getValue();
            }
            //소수 첫쨰자리에서 반올림
            result = (int)Math.round((double)result/count);

            sb.append(result).append("\n");
            map.clear();
        }
        System.out.println(sb);
    }
}
//3
//3 17 1 39 8 41 2 32 99 2
//22 8 5 123 7 2 63 7 3 46
//6 63 2 3 58 76 21 33 8 1
//