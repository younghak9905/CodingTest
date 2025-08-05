package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class back_20055 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int size = 2 * N;
		int[] durability = new int[size];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] robot = new boolean[size];
		int start = 0;
		int end = N - 1;
		int step = 0;
		int count =0;
		while (count <K){
			step++;
			start = (start-1+size)%size;
			end = (end-1+size)%size;
			robot[end] = false;

			for(int i=(end - 1 + size) % size,cnt=0;cnt<N;cnt++,i=(i-1+size)%size)
			{
				if(!robot[i]) continue;
				int ni = (i+1)%size; 
				if(!robot[ni] && durability[ni]>0) {
					robot[i] = false;
					robot[ni] = true;
					durability[ni]--;
					if (durability[ni] == 0)
						count++;
				}
			}
			robot[end]=false;

			if (durability[start] > 0 && !robot[start]) {
				robot[start] = true;
				durability[start]--;
				if (durability[start] == 0)
					count++;
			}
		}

		System.out.println(step);


	}

}
