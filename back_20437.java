import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class back_20437 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0) {

            ArrayList<Integer> list[] = new ArrayList[26];
            for(int i=0;i<26;i++)
            {
                list[i] = new ArrayList<>();
            }
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int[] c = new int[26];
            int max = 0;
            for (int i = 0; i < W.length(); i++) {
                list[W.charAt(i)-'a'].add(i);
                c[W.charAt(i) - 'a']++;
                max = Math.max(c[W.charAt(i) - 'a'], max);
            }
            if (max < K) {
                sb.append("-1").append("\n");
                continue;
            }
            max =0;
            int min = W.length();
            for(int i=0;i<26;i++)
            {
                int len =0;
                if(list[i].size()>=K)
                {
                    if(list[i].size()==K)
                    {
                        len = list[i].get(list[i].size()-1) - list[i].get(0)+1;
                        max = Math.max(len,max);
                        min = Math.min(len,min);
                    }
                    else{
                        for(int j=0;j<list[i].size()-K+1;j++)
                        {
                            len = list[i].get(K+j-1) - list[i].get(j)+1;
                            max = Math.max(len,max);
                            min = Math.min(len,min);
                        }
                    }

                }
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

}
