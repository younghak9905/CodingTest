import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2609 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int res=gcd(a,b);
        System.out.println(res);
        System.out.println(a*b/res);
    }
    //�ִ� �����
    static int gcd(int a, int b) {

        if(b==0) return a;

        return gcd(b, a % b);
    }
}
