import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1205 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long score = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        long [][]scores = new long[N+1][2];

        int max =0;
        if(N==0)
        {
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++)
        {
            scores[i][0] = Long.parseLong(st.nextToken());
            scores[i][1] = scores[i-1][0]==scores[i][0]?scores[i-1][1]:i;
            if(max<=(int)scores[i][1])
            max = Math.max((int)scores[i][1],max);
        }
        int start = 1;
        int end = N;
        while(start<=end)
        {
            int mid = start +(end-start)/2;
            if(scores[mid][0]>score)
            {
                start = mid+1;
            }else if(scores[mid][0]<score)
            {
                end = mid - 1;
            }else{
                end = mid;
                break;
            }
        }


        if(scores[end][0]==score)
        {
            if(max==scores[end][1] && P==N)
                System.out.println(-1);
            else
                System.out.println(scores[end][1]);
        }else if(scores[end][0]>score)
        {
            if(scores[max][0]>score)
            {
                if(P==N)
                    System.out.println(-1);
                else
                    System.out.println(scores.length);
            }else{
                System.out.println(scores[end+1][1]);
            }
        }else if(scores[end][0]<score)
            System.out.println(1);

    }
}
