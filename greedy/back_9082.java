package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_9082 {
    static int[][] A;
    static int result=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++)
        {
            int N = Integer.parseInt(br.readLine());
            A = new int[2][N];
            result=0;
            String num = br.readLine();
            String blind = br.readLine();
            for(int j=0;j<N;j++)
            {
                A[0][j] = num.charAt(j)-'0';
                if(A[0][j]==3)
                {
                    A[1][j-1] = 7;
                    A[1][j] = 7;
                    A[1][j+1] = 7;
                }else if(A[0][j]==0) {
                   if(j==0)
                   {
                       A[1][j] = -1;
                       A[1][j + 1] = -1;
                   }
                   else if(j==N-1)
                   {
                       A[1][j] = -1;
                       A[1][j - 1] = -1;
                   }
                   else{
                       A[1][j] = -1;
                       A[1][j + 1] = -1;
                       A[1][j - 1] = -1;
                   }
                }
                else if(A[1][j]==0){
                    A[1][j] = blind.charAt(j)-'#';
                }
            }
            //init
            if(A[0][0]==2)
            {
                A[1][0]=7;
                A[1][1]=7;
            }
            if(A[0][N-1]==2)
            {
                A[1][N-1]=7;
                A[1][N-2]=7;
            }

            for(int j=1;j<N-1;j++)
            {
               if(A[0][j]==2)
                {
                    check2(j);
                }
                else if(A[0][j]==1)
                {
                    check1(j);
                }
            }
            if(A[0][0]==1)
            {
                if(A[1][0]!=7)
                {
                    if(A[1][1]==7)
                    {
                        A[1][0]=-1;
                    }
                    else {
                        A[1][0]=7;
                    }
                }else if(A[1][0]==7){
                   A[1][1]=-1;
                }

            }
            if(A[0][N-1]==1)
            {
                if(A[1][N-1]!=7)
                {
                    if(A[1][N-2]==7)
                    {
                        A[1][N-1]=-1;
                    }
                    else {
                        A[1][N-1]=7;
                    }
                }else if(A[1][N-1]==7){
                    A[1][N-2]=-1;
                }
            }
            for(int j=0;j<N;j++)
            {
                if(A[1][j]!=-1)
                {
                    result++;
                }
            }
            System.out.println(result);



          /*  for (int j = 0; j < N; j++) {
                System.out.print(A[0][j]);
            }
            System.out.println();
            for (int j = 0; j < N; j++) {
                System.out.print(A[1][j]);
            }

            for (int j = 0; j < N; j++) {

            }*/





        }

    }
    static void check2(int j)
    {
        int count=2;
        for(int i=j-1;i<=j+1;i++)
        {
            if(A[1][i]==7)
            {
                count--;
            }
        }
        if(count==0)
        {
            for(int i=j-1;i<=j+1;i++)
            {
                if(A[1][i]==0)
                {
                    A[1][i]=-1;
                }
            }
        }
    }

    static void check1(int j)
    {
        int count=1;
        int a,b,c;
        a = A[1][j-1];
        b = A[1][j];
        c = A[1][j+1];
        if(a==7)
        {
            A[1][j]=-1;
            A[1][j+1]=-1;
        }
        else if(b==7)
        {
            A[1][j-1]=-1;
            A[1][j+1]=-1;
        }
        else if(c==7)
        {
            A[1][j-1]=-1;
            A[1][j]=-1;
        }

    }


}
