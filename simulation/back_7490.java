package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_7490 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++)
        {
            N = Integer.parseInt(br.readLine());
            recur(1,1,1,0,"1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void recur(int now,int num,int sign,int sum,String str)
    {
        if(now == N){
            sum=sum+(num*sign);

            if(sum==0)
                sb.append(str).append("\n");
            return;
        }
        recur(now+1,num*10+(num>0?(now+1):1),sign,sum,str+" "+ (now + 1));
        recur(now+1,num+1,1,sum+((now+1)*sign),str+"+"+ (now + 1));
        recur(now+1,num+1,-1,sum+((now+1)*sign),str+"-"+ (now + 1));
    }
}
