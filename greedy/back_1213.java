package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1213 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int size = str.length();
        char[] arr = str.toCharArray();
        int[] alpha = new int[26];
        for(int i=0;i<arr.length;i++)
        {
            alpha[arr[i]-'A']++;
        }
        int sol=-1;
        if(size%2==0)
        {
            for(int i=0;i<alpha.length;i++)
            {
                if(alpha[i]%2!=0)
                {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }
        for(int i=0;i<alpha.length;i++)
        {
            if(alpha[i]!=0)
            {

                if(alpha[i]%2!=0)
                {
                        if(sol>-1)
                        {
                            System.out.println("I'm Sorry Hansoo");
                            return;
                        }else{
                            sol=i;
                            input(sol,((alpha[i]-1)/2));
                        }
                }
                else {
                    input(i,alpha[i]/2);
                }
            }

        }
        if(sol==-1)
        {
            System.out.println(sb.toString()+sb.reverse().toString());
            return;
        }
       // sb.append(reverse.substring(1,reverse.length()));
        String result = sb.toString() + (char)(sol+'A')+sb.reverse().toString();
        System.out.println(result);

    }
    static void input(int index,int count)
    {
        for(int i=0;i<count;i++)
        {
            sb.append((char)(index+'A'));
        }

    }
}
