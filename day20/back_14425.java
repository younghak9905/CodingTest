package day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tNode root = new tNode();

        while(N>0){
            tNode now =root;
            st = new StringTokenizer(br.readLine());
            char[]S = st.nextToken().toCharArray();
            for(int j=0;j<S.length;j++) {
                if(now.next[S[j]-'a']==null)
                {
                    now.next[S[j]-'a']=new tNode();
                }
                now = now.next[S[j]-'a'];
                if(j==S.length-1)
                {
                    now.isEnd=true;
                }
            }
            N--;
        }
        int count =0;
       while(M>0)
        {
            tNode now = root;
            st = new StringTokenizer(br.readLine());
            char[]S = st.nextToken().toCharArray();
            for(int j=0;j<S.length;j++)
            {
                if(now.next[S[j]-'a']==null)
                {
                    break;
                }
                now = now.next[S[j]-'a'];
                if(j==S.length-1 && now.isEnd)
                {
                    count++;
                }
            }
            M--;
        }
        System.out.println(count);
    }

    static class tNode{
        tNode[] next = new tNode[26];
        boolean isEnd;
    }
}
