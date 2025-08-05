package bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_3085 {
    static int N;
    static char[][] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candy = new char[N+1][N+1];
        for(int i=1;i<=N;i++) {
            candy[i] = br.readLine().toCharArray();
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<N;j++) {
                if(candy[i][j]==candy[i][j-1]){
                    char tmp = candy[i-1][j];
                    candy[i-1][j] = candy[i][j-1];
                    candy[i][j-1] = tmp;

                }
            }
        }
    }

    static void recur(int cnt,char[][] candy)
    {
        if(cnt==2) {

        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(candy[i][j]!=candy[i-1][j]) {

                    char tmp = candy[i][j];
                    candy[i][j] = candy[i][j-1];
                    candy[i][j-1] = tmp;
                    recur(cnt+1,candy);
                    tmp = candy[i][j-1];
                    candy[i][j] = candy[i][j-1];
                    candy[i][j] = tmp;
                }
            }
        }
    }

    static int circulate() {
        int count1 = 1;
        int count2 = 1;
        int max = candy[0].length;
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<N;j++)
            {
                if(candy[i][j]==candy[i][j-1]){
                   count1++;
                }
                else{
                    count1=1;
                }
            }
            if(count1==max)
                break;
        }

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<N;j++)
            {
                if(candy[j][i]==candy[j][i-1]){
                    count2++;
                }
                else{
                    count2=1;
                }
            }
            if(count2==max)
                break;
        }
        return Math.max(count1,count2);
    }
}
