import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_5525 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char []c = s.toCharArray();
        int result =0;
        String s1="I";
        int temp = N;
        while(temp-->0)
        {
            s1=s1+"OI";
        }
        for(int i=0;i<M && (i+2*N)<M;i++)
        {
            if(c[i]=='I')
            {
                if(s.substring(i,i+2*N+1).equals(s1))
                {
                    result++;
                    i++;
                }

            }
        }
        System.out.println(result);

    }
}
