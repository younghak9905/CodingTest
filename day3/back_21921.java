package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_21921 {
    static int sum;
    static int result;
    static int MAX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int X =Integer.parseInt(st.nextToken());
        int []A= new int[N];
        st = new StringTokenizer(br.readLine());
        sum=0;
        for(int i=0;i<N;i++)
        {
            A[i]=Integer.parseInt(st.nextToken());
            if(i<X)
                sum+=A[i];
        }
        MAX=sum;
        result=1;
        for(int i=X;i<N;i++) {
            int j = i - X;
            Add(A[j],A[i]);
        }
        if(MAX!=0)
        {
            System.out.println(MAX);
            System.out.print(result);
        }
        else
            System.out.print("SAD");
    }

   public static void Add(int a,int b)
   {
        sum+=b-a;
        if(MAX<sum)
        {    MAX=sum;
             result=1;
        }
        else if(MAX==sum)
            result++;

   }
}
