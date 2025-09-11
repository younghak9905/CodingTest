import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class back_2668 {
    static ArrayList<Integer> list;
    static boolean []visited;
    static int[]A;

    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];


        for(int i=1;i<=N;i++)
        {
           A[i] = Integer.parseInt(br.readLine());
        }
        list = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++)
        {
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
    static void dfs(int start, int target)
    {
        if(!visited[A[start]])
        {
            visited[A[start]]=true;
            dfs(A[start],target);
            visited[A[start]]=false;
        }
        if(A[start]==target) list.add(target);
    }

}
