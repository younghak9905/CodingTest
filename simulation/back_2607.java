package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_2607 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result=0;
        int [][]similar = new int[N][26];
        int n =1;
        String first = br.readLine();
        int length = first.length();
        for(int j=0;j<length;j++)
        {
            similar[0][first.charAt(j)-'A']++;
        }
        for(int i=1;i<N;i++)
        {
            String word = br.readLine();
            if(length>word.length()+1 || length+1<word.length()) continue;

            for(int j=0;j<word.length();j++)
            {
                similar[n][word.charAt(j)-'A']++;
            }
            int k=0;
            for(int j=0;j<26;j++)
            {
               if(similar[0][j]==similar[i][j] && similar[0][j]!=0)
               {
                  k++;
               }else if(similar[0][j]>0 && similar[i][j]>0)
               {
                   k++;
               }
            }
            if(Math.abs(word.length()-k)<=1 && Math.abs(length-k)<=1)
            {
                System.out.println(word);
                result++;
            }

            n++;
        }
        System.out.println(result);


    }
}
