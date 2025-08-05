package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_18111 {
    static int [][]map;
    static int Max=0;
    static int Min=256;
    static int result = Integer.MAX_VALUE;
    static int N,M,B,height=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j]>Max){
                    Max=map[i][j];
                }

                if(map[i][j]<Min){
                    Min=map[i][j];
                }

            }
        }
        for(int i=Max ; i>=Min ; i--){
            mine(i);
        }
        System.out.println(result+" "+height);


    }
    static void mine(int h)
    {
            int time =0;
            int b = B;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(time>result)
                        return;
                    if(map[i][j]>h){
                        int temp = map[i][j]-h;
                        time += 2*temp;
                        b+=temp;
                    }else if(map[i][j]<h){
                        int temp = h-map[i][j];
                        time += temp;
                        b-=temp;
                    }
                }
            }
            if(b>=0 && result>time){
                result=time;
                height=h;

            }
        }
}
