package samsung;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;
public class swea_2007 {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{   sb.append("#").append(test_case).append(" ");
        String str = br.readLine();
            for(int i=1;i<=10;i++)
            {
                
                  if(check(str,i))
                  {
                        sb.append(i+1).append("\n");
                        break;
                  }
            }
            

			/////////////////////////////
            /// ////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
        System.out.print(sb.toString());
	}
    static boolean check(String str,int i)
    {
        for(int j=i+1;j<30;j=j+i)
        {
             if(!str.substring(0,i).equals(str.substring(i+1,2*i+1)))
             {
                 return false;
             }
                
        }
            return true;
    }
    
}
