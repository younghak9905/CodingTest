package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class back_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int T=0;T<N;T++){
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if(query==1){
                int q = Integer.parseInt(st.nextToken());
                dq.addFirst(q);
            }
            else if(query==2){
                int q = Integer.parseInt(st.nextToken());
                dq.addLast(q);
            }else if(query==3){
                if(dq.isEmpty()){
                    sb.append("-1\n");
                }else
                    sb.append(dq.pollFirst()+"\n");
            }else if(query==4){
                if(dq.isEmpty()){
                    sb.append("-1\n");
                }
                else
                    sb.append(dq.pollLast()+"\n");
            }else if (query==5){
                sb.append(dq.size()+"\n");
            }else if(query==6){
                if(dq.isEmpty()){
                    sb.append("1\n");
                }else
                    sb.append("0\n");
            }else if(query==7){
                if(dq.isEmpty()){
                    sb.append("-1\n");
                }else
                    sb.append(dq.peekFirst()+"\n");
            }else if(query==8){
                if(dq.isEmpty()){
                    sb.append("-1\n");
                }
                else
                    sb.append(dq.peekLast()+"\n");
            }

        }
        System.out.print(sb);
    }

}
