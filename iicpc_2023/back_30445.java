package iicpc_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class back_30445 {
    static char[] sad = {'S', 'A', 'D'};
    static char[] happy = {'H', 'A', 'P', 'Y'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int arr[] = new int[26];


             String str = br.readLine();
            String[] s= str.split(" ");
            for(int i=0;i<s.length;i++)
            {

                for(int j=0;j<s[i].length();j++)
                {
                    arr[s[i].charAt(j)-'A']++;
                }
            }

           double sad=0;
            sad+=arr['S'-'A'];
            sad+=arr['A'-'A'];
            sad+=arr['D'-'A'];

            double happy=0;
            happy+=arr['H'-'A'];
            happy+=arr['A'-'A'];
            happy+=arr['P'-'A'];
            happy+=arr['Y'-'A'];

            if(sad==0 && happy==0)
            {
                System.out.println(50.00);
                return;
            }

        double result = Math.round((happy*100 / (sad + happy)) * 100.00) / 100.0;
        System.out.printf(""+result);

    }
}
