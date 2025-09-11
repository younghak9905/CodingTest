import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_9017 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();
        int T =Integer.parseInt(br.readLine());
        while (T-->0)
        {
            ArrayList<Integer>[] list =new ArrayList[201];
            for(int i=0;i<=200;i++)
            {
            list[i] = new ArrayList<>();
            }
            int N = Integer.parseInt(br.readLine());
            int []race =new int[N+1];
            int []team =new int[201];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++)
            {
                race[i] = Integer.parseInt(st.nextToken());
                team[race[i]]++;
            }
            int score = 1;
            for(int i=1;i<=N;i++)
            {
               if(team[race[i]]==6)
               {
                   list[race[i]].add(score++);
               }
               if(list[race[i]].size()==6)
               {
                   int sum =0;
                   for(int j=0;j<4;j++)
                   {
                       sum+= list[race[i]].get(j);
                   }
                   list[race[i]].add(sum);
               }
            }
            int min =Integer.MAX_VALUE;
            int teamId =0;
            for(int i=1;i<201;i++)
            {
                if(list[i].size()>6)
                {
                    if(min>list[i].get(6))
                    {
                        min = list[i].get(6);
                        teamId =i;
                    }else if(min==list[i].get(6))
                    {
                        if(list[i].get(4)<list[teamId].get(4))
                        {
                            teamId = i;
                        }
                    }
                }
            }
           sb.append(teamId).append("\n");
        }
        System.out.println(sb);
    }
}
