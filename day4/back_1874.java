package day4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int []A= new int[N];
        for(int i=0;i<N;i++)
        {
            A[i]=Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int num=1;
        for(int i=0;i<N;i++)
        {
          if(num<=A[i])
          {
              while ((num<=A[i]))
              {
                  stack.push(num++);
                    sb.append("+\n");
              }
              stack.pop();
              sb.append("-\n");
          }
          else{
              int n= stack.pop();
              if(n>A[i])
              {
                  System.out.print("NO");
                  return;
              }else {
                  sb.append("-\n");
              }
          }
        }
        int length = sb.toString().length();
        System.out.print(sb.substring(0,length-1));
    }

}
