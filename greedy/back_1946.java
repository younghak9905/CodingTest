package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			Person[] P = new Person[N];


			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				P[j] = new Person(a, b);
			}
			Arrays.sort(P);
			int count =1;
			int bestInterview = P[0].interview;

			for (int k = 1;k<N;k++ ) {
				if(P[k].interview<bestInterview)
				{
					count++;
					bestInterview = P[k].interview;
				}
			}
			System.out.println(count);
		}
	}




	static class Person implements Comparable<Person>{
		int test;
		int interview;
		public Person(int test,int interview)
		{
			this.test=test;
			this.interview=interview;
		}
		@Override
		public int compareTo(Person o)
		{
			return this.test - o.test;
		}





	}
}
