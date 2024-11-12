package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14890 {
    static int N,L;
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
       
        for(int i=0;i<N;i++)
        {  
           if(look(map[i],new boolean[N]))
           {
                result++;
           }
        }
       
        for(int j=0;j<N;j++)
        { 
            if(look(getColumn(map, j),new boolean[N]))
            {
                 result++;
            }
        }
        System.out.println(result);
    }
    static boolean look(int[] map,boolean[]visit)
    {   
       
        for(int j=0;j<N-1;j++)
        {   
          if(map[j]==map[j+1]) continue;
          else
          {
              if(Math.abs(map[j]-map[j+1])>1)
                return false;
              else if(map[j]>map[j+1])
              {
                if(j+L>=N)
                {
                    return false;
                } 
                for(int k=1;k<L;k++)
                {
                    if(map[j+1]!=map[j+k+1] || visit[j+k+1]) 
                    {
                        return false;
                    }
                    
                }
                for(int k=j+1;k<=j+L;k++) //2   <  4
                {
                    visit[k]=true;
                }   
                j=j+L-1;
              }
              else
              {
                if(j-L+1<0)
                {
                    return false;
                } 
                for(int k=1;k<L;k++)
                {
                    if(map[j]!=map[j-k] || visit[j-k]) 
                    {
                        return false;
                    }
                }
            }

        }
        }   
        return true;
    }
    public static int[] getColumn(int[][] matrix, int columnIndex) {
        int rows = matrix.length;
        int[] columnArray = new int[rows];
        
        for (int i = 0; i < rows; i++) {
            columnArray[i] = matrix[i][columnIndex];
        }
        
        return columnArray;
    }
    
}
//6 2
