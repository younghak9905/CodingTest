package iicpc_2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d_tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N =  Long.parseLong(st.nextToken());

        int []D=new int[11];
        D[1]=9;
        D[2]=9+D[1];
        D[3]=90+D[2];
        D[4]=90+D[3];
        D[5]=900+D[4];
        D[6]=900+D[5];
        D[7]=9000+D[6];
        D[8]=9000+D[7];
        D[9]=90000+D[8];
        D[10]=90000+D[9];


        String temp = String.valueOf(N);
        char[] c =temp.toCharArray();
        int size = temp.length();  //101  -> 3
        long first = N/ (int)Math.pow(10,size-1); //
        long result=0;
        result+=D[size-1]; //90
        if(first>1)
            result+=D[size-1]*(first-1)/9; //20

        if((long)Math.pow(10,size-1)*first+first>=N)  //368782413  -> 9
        {
            if(c[2]>1)
            {
                result+=D[size-3]*(c[2]-1)/9;
            }
            //temp.charAt(2);
        }
        for(long i=(long)Math.pow(10,size-1)*first+1;i<=N;i++)
        {
           // String temp = String.valueOf(i);


            if (temp.charAt(0) == temp.charAt(temp.length() - 1))
            {
                if(isPalindrome(temp))
                {
                    result++;
                }
            }
        }
        System.out.println(result);

    //11 11
        //101*/

    }

    static boolean isPalindrome(String s)
    {   int len  = s.length();
        int halfLen =len / 2;

        // 왼쪽 절반 부분 문자열
        String firstHalf = s.substring(0, halfLen);

        // 오른쪽 절반 부분 문자열
        if (len % 2 == 0) {
            // 짝수 길이의 문자열일 경우
            String secondHalf = s.substring(halfLen, len);
            String reversedSecondHalf = new StringBuilder(secondHalf).reverse().toString();
            if (firstHalf.equals(reversedSecondHalf)) {
               return true;
            } else {
                return false;
            }
        } else {
            // 홀수 길이의 문자열일 경우, 중간 문자를 제외
            String secondHalf = s.substring(halfLen + 1, len);
            String reversedSecondHalf = new StringBuilder(secondHalf).reverse().toString();
            if (firstHalf.equals(reversedSecondHalf)) {
                return true;
            } else {
                return false;
            }
        }
    }


}
