package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_12891 {
    static int [] A=new int[4];
    static int [] check=new int[4];

    static int secret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        secret=0;
        String input = br.readLine();
        char[] C=input.toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++)
        {
            A[i]=Integer.parseInt(st.nextToken());
            if(A[i]==0)
                secret++;   //들어가지 않아도 되는 부분은 미리 secret을 증가시킴
        }
        int result=0;

            for(int k=0;k<M;k++) //초기 배열 검사
            {
                Add(C[k]);
            }
            if(secret==4)
            {
                result++;
            }
            for(int i=M;i<N;i++) //i: start_index , j: end_index
            {
                int j=i-M;
                Add(C[i]);
                Remove(C[j]);
                if(secret==4)
                    result++;
            }
        System.out.println(result);
    }
    private static void Add(char c)
    {
        switch (c){
            case 'A':
                check[0]++;
                if(check[0]==A[0])
                    secret++;
                break;
            case 'C':
                check[1]++;
                if(check[1]==A[1])
                    secret++;
                break;

            case 'G':
                check[2]++;
                if(check[2]==A[2])
                    secret++;
                break;
            case 'T':
                check[3]++;
                if(check[3]==A[3])
                    secret++;
                break;

        }
    }
    private static void Remove(char c)
    {
        switch (c){
            case 'A':
                if(check[0]==A[0])
                    secret--;
                check[0]--;
                break;
            case 'C':
                if(check[1]==A[1])
                    secret--;
                check[1]--;
                break;

            case 'G':
                if(check[2]==A[2])
                    secret--;
                check[2]--;
                break;
            case 'T':
                if(check[3]==A[3])
                    secret--;
                check[3]--;
                break;

        }
    }
}
