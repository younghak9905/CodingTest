package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2195 {
    static String S, P;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P =br.readLine();

       while(P.length()>0)
        {
            find();
        }
        System.out.println(result);
    }
    static void find()
    {

            int j = P.length();  //11 -1 = 10
            for(int i=j-1; i>=0; i--)// 0 10
            {
                if(!S.contains(P.substring(i, j)))   //8,10
                {
                   P=P.substring(0, i+1);
                   result++;
                   break;
                }else if(i==0)
                {
                    result++;
                    P="";
                    break;
                }
            }

    }
}
