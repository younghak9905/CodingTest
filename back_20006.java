import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class back_20006 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<PriorityQueue<Player>> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<p;i++)
        {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

                boolean enter =false;
                for(int j=0;j<list.size();j++)
                {
                    int size = list.get(j).size();
                    int top = map.get(j);

                    if(size<m && (top+10)>=level && (top-10)<=level)
                    {
                        list.get(j).add(new Player(level,n));
                        enter = true;
                        break;
                    }
                }
                if(!enter)
                {

                    list.add(new PriorityQueue<>());
                    list.get(list.size()-1).add(new Player(level,n));
                    map.put(list.size()-1,level);
                }

        }
        for(int j=0;j<list.size();j++)
        {
            if(list.get(j).size()==m)
            {
                sb.append("Started!").append("\n");
            }
            else
            {
                sb.append("Waiting!").append("\n");
            }
            while(!list.get(j).isEmpty())
            {
                Player result = list.get(j).poll();
                sb.append(result.level).append(" ").append(result.nickname).append("\n");
            }
        }
        System.out.println(sb);
    }
    //사전 순으로 정렬
    static class Player implements Comparable<Player> {
        int level;
        String nickname;

        public Player(int level, String n) {
            this.level = level;
            this.nickname = n;
        }

        @Override
        public int compareTo(Player o) {
            // 닉네임 사전순
            int c = this.nickname.compareTo(o.nickname); // 또는 CharSequence.compare(this.nickname, o.nickname)
            if (c != 0) return c;
            // (선택) 닉네임 같으면 레벨로 tie-break
            return Integer.compare(this.level, o.level);
        }
    }

}
