package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class back_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int T=0;T<N;T++){
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            if(query.equals("push")){
                int q = Integer.parseInt(st.nextToken());
                dq.add(q);
            }else if(query.equals("pop")){
                if(dq.isEmpty()){
                   sb.append("-1\n");
                }else
                    sb.append(dq.poll()+"\n");
            }else if(query.equals("front")){
                if(dq.isEmpty()){
                    sb.append("-1\n");
                }else
                    sb.append(dq.peekFirst()+"\n");
            }else if(query.equals("back")){
                if(dq.isEmpty()){
                    sb.append("-1\n");
                }
                else
                    sb.append(dq.peekLast()+"\n");
            }else if(query.equals("empty")){
                if(dq.isEmpty()){
                    sb.append("1\n");
                }else
                    sb.append("0\n");
            }
            else{
                sb.append(dq.size()+"\n");
            }
        }
        System.out.print(sb);
    }
}
