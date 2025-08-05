package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class back_16434 {
    static long maxHp;
    static long nowHP;
    static long attack;
    static int N;
    static long H;
    public static void main(String[] args) throws Exception {
        // This is a placeholder for the main method.
        // The original code does not contain any logic, so we will leave it empty.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Long.parseLong(st.nextToken());

        tObject[] object = new tObject[N];


        long min = 1;
        long max = 0;

        for(int i=0;i<N;i++)
        {    st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());


            object[i] = new tObject(t, a, h);
            if(t == 1) max += ((long)a * h);
        }



        while(min<=max)
        {
                long mid = (min+max)/2;

                if(combat(object,mid))
                {
                    max = mid-1;
                }
                else{
                    min = mid+1;
                }
        }
        System.out.println(min);



    }
    static boolean combat(tObject []obs,long hp)
    {

        maxHp = hp;
        nowHP = hp;
        attack = H;
        for(int i=0;i<obs.length;i++)
        {

            tObject ob= obs[i];

                if(ob.t==1) {
                    if(ob.h % attack==0) {
                         long temp = ob.a * ((ob.h / attack) - 1);//tqttqtqtqttqtqtqtqtqtqtqtqtqtqttqt 타입 때문에 1시간 날렸네
                        nowHP -= temp;
                    }
                    else {
                        nowHP -= ob.a * (ob.h / attack);
                    }
                    if(nowHP <= 0) {
                        return false; // Player dies
                    }
                }else{
                    attack+= ob.a;
                    nowHP += ob.h;
                    if(nowHP > maxHp) {
                        nowHP = maxHp; // Ensure health does not exceed maximum
                    }
                }


        }

        return true;

    }

    static class tObject{
        long t;
        long a;
        long h;

        public tObject(long t, long a, long h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
}
