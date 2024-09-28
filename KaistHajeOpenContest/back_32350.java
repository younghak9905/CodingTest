package KaistHajeOpenContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_32350 {
    static int N,p,page,D;
    static Queue<Integer> battle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        battle = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            battle.add(Integer.parseInt(st.nextToken()));
        }
        int overKill = 0;
        page = 0;
        int attack = 0;
        while (!battle.isEmpty()) {//30 21 1 2 30 22 3

            //battle(D,overKill);

            int now = battle.poll() - attack;
            attack = 0;
            while (now > 0) {
                //System.out.println("공격전 now: "+ now+" page: "+page);
                now -= D;
                page++;
                //System.out.println("공격 후 now: "+ now+" page: "+page);
                if(now>=0)
                {
                    overKill = 0;
                }
            }
            if (overKill == 0 && now<0) {
                if(battle.isEmpty())
                {
                    break;
                }
                overKill = 1;
                attack = getPercentage(-now);
                //System.out.println("오버킬 h: "+ attack);
            } else {
                //System.out.println("오버킬 now: "+ now+" page: "+page);
                overKill = 0;
            }
        }
        System.out.println(page);


    }

    static int getPercentage(int h) {
        int percentage = (h * p) / 100;
        return percentage;
    }

}
