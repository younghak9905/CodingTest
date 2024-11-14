package samsung;
import java.util.*;
import java.io.*;

public class swea_1204 {
    public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
       
      
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(map.get(a)==map.get(b))
            {
                return b-a;
            }
            return map.get(b)-map.get(a);
        });
		for(int test_case = 1; test_case <= T; test_case++)
		{   
           
            

            int num = Integer.parseInt(br.readLine());
            sb.append("#"+num+" ");
           
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                map.put(score, map.getOrDefault(score, 0) + 1);
            }
          
            for(int key:map.keySet())
            {
                pq.add(key);
            }
            map.clear();
            
           


           sb.append(pq.poll()).append("\n");
           pq.clear();
         


		
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
           
		}
        System.out.println(sb.toString());
        
	}
}

class Solution
{
	
}
