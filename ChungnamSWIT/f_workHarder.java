package ChungnamSWIT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class f_workHarder {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      //  int N = Integer.parseInt(br.readLine());
        int N = 4;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=N;i>0;i--)
        {
            arrayList.add(i);
        }
        int mid = N/2;
        int A[]= new int[N+1];
        if(mid%2==0)
        {   mid=mid+1;
            A[mid]=arrayList.remove(0);
            for(int i=2;i<mid;i+=2)
            {
                A[mid+i]=arrayList.remove(0);
                A[mid-i]=arrayList.remove(0);
            }
            for(int i=2;i<=N && !arrayList.isEmpty();i+=2)
            {
                A[i]=arrayList.remove(0);
            }


        }else {

            for(int i=1;i<mid;i++)
            {
                A[mid+i]=arrayList.remove(0);
                A[mid-i]=arrayList.remove(0);
            }
            for(int i=2;i<=N && !arrayList.isEmpty();i+=2)
            {
                A[i]=arrayList.remove(0);
            }


        }
// 2 3 4 1
        //  3 2 4 1  21
        //  4 2 3 1 19
        //  2 3 4 1 21
        //  3 2 5 1 4
        //int []A= { 4 ,3 ,6, 2, 7, 1, 5};
        int X= 1;
        for(int i=1;i<=N;i++)
        {
            System.out.print(A[i]+" ");
        }

        for(int i=1;i<=N;i++)
        {
            if(i%2==0)
            {
                X+=A[i];
            }
            else {
                X*=A[i];
            }
        }
        System.out.println(X);
    }
}
