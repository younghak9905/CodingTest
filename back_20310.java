import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_20310 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String s = br.readLine();
        char[] c = s.toCharArray();
        int zero =0;
        int one = 0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='0')
                zero++;
            else
                one++;
        }
        int start = 0;
        int end = s.length()-1;
        zero/=2;
        one/=2;
        while(one!=0 || zero!=0)
        {
            if(c[end]=='0' && zero>0) {
                c[end] = '2';
                zero--;
            }
            if(c[start]=='1' && one>0) {
                c[start] = '2';
                one--;
            }
            if(start<c.length-1)
                start++;
            if(end>0)
            {
                end--;
            }


        }
        for(int i=0;i<c.length;i++)
        {
            if(c[i]!='2')
                sb.append(c[i]);
        }
        System.out.println(sb);
    }
}
