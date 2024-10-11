package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_10610 {//실버4
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        if(!str.contains("0"))
        {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        for(int i=0;i<str.length();i++)
        {
           sum+=str.charAt(i)-'0';
        }
        if(sum%3!=0)
        {
            System.out.println(-1);
            return;
        }
        else {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder(new String(arr));
            System.out.println(sb.reverse());
        }






    }
}
