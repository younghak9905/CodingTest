import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2531 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
        int[]dishes = new int[N];
        int[]D = new int[d+1];
        int count =0;
        int start = 0;
        int end = 0;
        for(int i=0;i<N;i++)
        {
            dishes[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<k;i++)
        {
            if(D[dishes[start]]==0)
                count++;
            D[dishes[start]]++;
            start = (start+1)%N;
        }
        if(N==k)
        {
            if(D[c]==0)
                count++;
            System.out.println(count);
            return;
        }

        start--;
        int point = start;
        int max = 0;
        while(true)
        {
            if(max<count)
            {
                max = count;
            }
            if(max == count && max<k || count==k)
            {
                if(D[c]==0)
                {
                    max++;
                }
            }
            if(max==(k+1))
                break;

            start = (start+1)%N;
            if(point==start) break;
            if(D[dishes[start]]==0)
                count++;
            D[dishes[start]]++;
            if(dishes[end]!=dishes[(end+1)%N] && (D[dishes[end]]==1))
                count--;
            D[dishes[end]]--;

            end = (end+1)%N;

        }
        System.out.println(max);
    }
}
