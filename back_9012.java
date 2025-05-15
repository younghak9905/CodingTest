/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9012                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: younghak9905 <boj.kr/u/younghak9905>        +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9012                           #+#        #+#      #+#    */
/*   Solved: 2025/05/15 10:24:23 by younghak9905  ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public  class back_9012 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)
        {
            Stack<Integer> stack = new Stack<>();
            String s = br.readLine();
            boolean isValid=true;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='(')
                {
                    stack.push(0);
                }else{
                    if(!stack.isEmpty())
                    {
                        stack.pop();
                    }else{
                        isValid=false;
                    }
                }

                if(!isValid) break;
            }
            if(stack.isEmpty())
            {
                if(isValid) sb.append("YES"+"\n");
                else sb.append("NO"+"\n");
            }
            else sb.append("NO"+"\n");
        }
        System.out.print(sb);
    }
}