package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class hsat_3_cross {
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        result = new int[N];
        Deque<cross>[]q = new LinkedList[4];

        for(int i=0;i<4;i++)
        {
            q[i] = new LinkedList<>();
        }

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int line = (st.nextToken().charAt(0)-'A');
            q[line].add(new cross(t,i));
            result[i] = -1;
        }
        StringBuilder sb = new StringBuilder();
        int currentTime = -1;
       while(true)
       {
           if(q[0].isEmpty() && q[1].isEmpty() && q[2].isEmpty() && q[3].isEmpty()) break;
              int min = Integer.MAX_VALUE;
              int []temp = new int[4];
              for(int i=0;i<4;i++)
              {
                if(!q[i].isEmpty())
                {
                    int t = q[i].peek().time;
                    min = Math.min(min,t);
                    if(t<=currentTime)
                    {
                        temp[i] =1;
                    }
                }
              }
              int count =0;
              for(int value : temp)
                  count+=value;
              if(count==0)
                  currentTime=min;
              else if(count==4)
                  break;
              else
              {
                  for(int i=0;i<4;i++)
                  {
                      if(temp[i]!=0 && temp[(i+3)%4]==0)
                      {
                          result[q[i].poll().index] = currentTime;
                      }
                  }
                  currentTime++;
              }

       }
       for (int i = 0; i < N; ++i)
            sb.append(result[i]).append("\n");


       System.out.println(sb);

    }
    static class cross{
        int time;
        int index;
        public cross(int time,int index) {
            this.time = time;
            this.index = index;
        }
    }
}
