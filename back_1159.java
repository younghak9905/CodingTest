import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_1159 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] list = new int[26];
        for(int i=0;i<N;i++)
        {
            String s = br.readLine();
            list[s.charAt(0)-'a']++;
        }
        char result ='A';
        for(int i=0;i<26;i++)
        {
            if(list[i]>=5)
            {
                result= (char)(i+'a');
                System.out.print(result);
            }
        }
        if(result=='A')
            System.out.println("PREDAJA");
    }
}
