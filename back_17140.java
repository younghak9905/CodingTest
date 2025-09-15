import java.io.BufferedReader;
import java.util.*;

public class back_17140 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int A[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        A= new int[102][102];

        for(int i=0;i<3;i++)
        {
            list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++)
            {
                list.get(i).add(Integer.parseInt(st.nextToken()));
                A[i+1][j+1]=list.get(i).get(j);
            }
        }
        int time =0;
        int H =3;
        int W =3;
        while(A[r][c]!=k && time!=101)
        {
            time++;
            if(H>=W) {
                W = calR(W, H);

            }
            else if(W>H)
            {
                H=calC(W,H);
            }

        }
        System.out.println(time>100?-1:time);
    }

    static int calR(int w,int h) {
        int max =0;
        for (int i = 0; i < h; i++) {

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < w; j++) {
                if(A[i+1][j+1]==0) continue;
                map.put(A[i+1][j+1],map.getOrDefault(A[i+1][j+1],0)+1);
                A[i+1][j+1]=0;
            }
            List<Map.Entry<Integer, Integer>> temp = new ArrayList<>(map.entrySet());
            temp.sort((a,b)->{
                if(a.getValue()==b.getValue())
                {
                    return a.getKey()-b.getKey();
                }
                return a.getValue() - b.getValue();
            });

            ArrayList<Integer> temp2 = new ArrayList<>();
            for (int j = 0; j < temp.size() && j<100; j++) {
               temp2.add(temp.get(j).getKey());
               temp2.add(temp.get(j).getValue());
            }
            for (int j = 0; j < temp2.size() && j<100; j++) {
                A[i+1][j+1] = temp2.get(j);
            }
            max = Math.max(max, temp2.size()<=100?temp2.size():100);

        }
        return max;
    }

    static int calC(int w,int h) {
        int max =0;

        for (int i = 0; i < w; i++) {
            int[] count = new int[10];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < h; j++) {
                if(A[j+1][i+1]==0) continue;
                map.put(A[j+1][i+1],map.getOrDefault(A[j+1][i+1],0)+1);
                A[j+1][i+1]=0;
            }
            List<Map.Entry<Integer, Integer>> temp = new ArrayList<>(map.entrySet());
            temp.sort((a,b)->{
                if(a.getValue()==b.getValue())
                {
                    return a.getKey()-b.getKey();
                }
                return a.getValue() - b.getValue();
            });

            ArrayList<Integer> temp2 = new ArrayList<>();
            for (int j = 0; j < temp.size() && j<100; j++) {
                temp2.add(temp.get(j).getKey());
                temp2.add(temp.get(j).getValue());
            }
            for (int j = 0; j < temp2.size() && j<100; j++) {
                A[j+1][i+1]  = temp2.get(j);
            }
            max = Math.max(max, temp2.size()<=100?temp2.size():100);

        }
        return max;
    }
}
