package ChungnamSWIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class e_light {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st=new StringTokenizer(br.readLine());
        int MIN=T;
        int gcd=0;
        int count =0;
        for(int i=1;i<=N;i++)
        {
            arr[i]=Integer.parseInt(st.nextToken());
            gcd=T*arr[i]/gcd(T,arr[i]);
            if(arr[i]==1)
                gcd=T;
            if(MIN>gcd)
            {
                MIN=gcd;
            }
        }
      //  System.out.println(MIN);
      for(int i=1;i<=N;i++)
      {
          if(MIN%arr[i]==0) {
              continue;
          }

          if(MIN<arr[i])
          {
              count+=arr[i]-MIN;
          }
          else
           count+= gcdm(MIN,arr[i]);


        // System.out.println(count);
      }
        System.out.println(count);

    }



    public static int gcd(int a, int b) {

        if (b == 0 || b==1) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int gcdm(int a, int b) {
        int count=0;
        int temp=0;
        while (true) {
            count++;
            temp++;
            int down = b-temp;
            int up = b+temp;
            if(down>0)
            {
                if(a%down==0)
                    break;
            }
            if(up<=a)
            {
                if(a%up==0)
                    break;
            }
        }
        return count;
    }
}
