package weak0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1546 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double result=0;
		int MAX=0;
		int input;
		for(int i=0;i<N;i++)
		{
			input=Integer.parseInt(st.nextToken());
			if(MAX<input)
			{
				MAX=input;
			}
			result+=input;
		}
		System.out.println(result/N * 100/MAX);

	}
}