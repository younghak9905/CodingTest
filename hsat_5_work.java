import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class hsat_5_work {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int leaf = (int)Math.pow(2, H); //리프 노드 개수
        int n  =(int)Math.pow(2, H+1)-1; //전체 노드 개수
        Queue<Integer>[][] q = new Queue[n][2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++)
            {
                q[i][j] = new LinkedList<>();
            }
        }
        for(int i=n-leaf;i<n;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++)
            {
                q[i][0].add(Integer.parseInt(st.nextToken()));
            }
        }
        int answer = 0;
        int day=1;
        while(day<=R)
        {
            if(day%2==1 && !q[0][0].isEmpty())
            {
                answer+=q[0][0].poll();
            }
            else if(day%2==0 && !q[0][1].isEmpty())
            {
                answer+=q[0][1].poll();
            }
            for(int i=1;i<n-leaf;i++)
            {
                int parent = (i-1)/2;
                if(day%2==1 && !q[i][0].isEmpty())
                {
                    int task =  q[i][0].poll();
                    if(i%2==1) q[parent][0].add(task);
                    else q[parent][1].add(task);
                }
                else if(day%2==0 && !q[i][1].isEmpty())
                {
                    int task =  q[i][1].poll();
                    if(i%2==1) q[parent][0].add(task);
                    else q[parent][1].add(task);
                }
            }
            for(int i=n-leaf;i<n;i++)
            {
                int parent = (i-1)/2;
                if(!q[i][0].isEmpty())
                {
                    int task =  q[i][0].poll();
                    if(i%2==1) q[parent][0].add(task);
                    else q[parent][1].add(task);
                }
            }
            day++;
        }
        System.out.println(answer);
    }

}
