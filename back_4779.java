import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Ä­Åä¾î ÁýÇÕ
public class back_4779 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        //EOF
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String input;
       while((input = br.readLine())!=null)
       {
            N = Integer.parseInt(input);
            sb = new StringBuilder();
            int len = (int)Math.pow(3,N);
            for(int i=0;i<len;i++)
            {
                sb.append('-');
            }
           recur(0,len);
            System.out.println(sb);

       }
    }
    //Àç±Í
    static void recur(int start , int size)
    {
        if(size==1)
        {
            return;
        }
      int newSize = size/3;
        for(int i=start+newSize;i<=start+2*newSize;i++)
        {
            sb.setCharAt(i,' ');
        }
        recur(start,newSize);
        recur(start+2*newSize,newSize);
    }


}
