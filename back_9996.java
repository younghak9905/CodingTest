import java.io.BufferedReader;
import java.util.regex.Pattern;

public class back_9996 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        pattern = pattern.replace("*", ".*");
        pattern = "^" + pattern +"$";
        for(int i=0;i<N;i++)
        {
            String input = br.readLine();
            if(Pattern.matches(pattern,input))
            {
                System.out.println("DA");
            }
            else
            {
                System.out.println("NE");
            }
        }
    }
}
