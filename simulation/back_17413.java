package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_17413 {
    static Stack<Character> stack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String tag = "close";
        StringBuilder sb = new StringBuilder();


        if(!s.contains("<"))
        {
            String[]temp = s.split(" ");
            for(String word:temp)
            {
                for(int i=word.length()-1;i>=0;i--)
                {
                   sb.append(word.charAt(i));
                }
                sb.append(" ");
            }
        }
        else{
            stack = new Stack<>();
            for(int i=0;i<s.length();i++)
            {
                if(tag.equals("close"))
                {
                    if(s.charAt(i)=='<') {
                        tag = "open";
                        if(!stack.isEmpty())
                        {
                            sb.append(reverse());
                        }
                        sb.append('<');
                    }
                    else if(s.charAt(i)==' ')
                    {
                        if(!stack.isEmpty())
                        {
                            sb.append(reverse()).append(" ");
                        }
                    }
                    else {
                        stack.push(s.charAt(i));
                    }
                }
                else if(tag.equals("open"))
                {
                    if((s.charAt(i)=='>'))
                    {
                        tag="close";
                        sb.append('>');
                    }
                    else{
                        sb.append(s.charAt(i));
                    }
                }
            }
            if(!stack.isEmpty())
            {
                 sb.append(reverse());

            }
        }
        System.out.println(sb);

    }

    static String reverse()
    {   StringBuilder sb = new StringBuilder();
        int length = stack.size();
        for(int i=0;i<length;i++)
        {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
