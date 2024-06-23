package day4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int []A = new int[N];

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++)
        {
            A[i]=Integer.parseInt(st.nextToken());
            if(stack.empty())
            {
                stack.push(i);//A[0] = 3
            }
            else if(A[stack.peek()]<A[i])
            {
                while(!stack.empty())
                {
                    if(A[stack.peek()]<A[i])
                        A[stack.pop()]=A[i];
                    else
                        break;
                }
                stack.push(i);
            }
            else{
                stack.push(i);
            }
        }
        while(!stack.empty())
        {
            int n=stack.pop();
            A[n]=-1;
        }
        for(int i=0;i<N;i++)
        {
           sb.append(A[i]+" ");
        }
        System.out.print(sb.toString());
    }
}
