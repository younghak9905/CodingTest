package pccp;

import java.util.HashMap;
import java.util.PriorityQueue;

public class pcce_data {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};


        int index=0;
        int eindex=0;
        String[] s= {"code","date","maximum","remain"};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<s.length;i++){
            map.put(s[i], i);
        }
        eindex = map.get(ext);
        index=map.get(sort_by);

        int finalIndex = index;
        System.out.println("index: "+index);

        //오름차순 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[finalIndex]==b[finalIndex]){
                return a[0]-b[0];
            }
            return a[finalIndex]-b[finalIndex];
        });





        for(int i=0;i<data.length; i++){
            if(data[i][eindex]<val_ext){
                pq.add(data[i]);
            }
        }
        answer = new int[pq.size()][4];
        int j=0;
        while(!pq.isEmpty())
        {
            answer[j++] = pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        pcce_data sol = new pcce_data();
        //[[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]]
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext =20300501;
        String sort_by = "remain";
        int[][] ret = sol.solution(data, ext, val_ext, sort_by);
        for(int i=0; i<ret.length; i++){
            for(int j=0; j<ret[i].length; j++){
                System.out.print(ret[i][j]+" ");
            }
            System.out.println();
        }
    }
}
