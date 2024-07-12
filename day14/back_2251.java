package day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//물채우기, BFS,DFS, 그래프
public class back_2251 {

	static Reader in = new Reader();
	static boolean visited[][];
	static boolean check[];
	static int []send ={0,0,1,1,2,2};
	static int []receive = {1,2,0,2,0,1};

	static int []now = new int[3];

	public static void main(String[] args) throws Exception {
		StringBuilder st = new StringBuilder();
		now[0]= in.nextInt();
		now[1]= in.nextInt();
		now[2] = in.nextInt();
		visited = new boolean[201][201];
		check = new boolean[201];
		BFS();
		for(int i=0;i<check.length;i++)
		{
			if(check[i])
			{
				st.append(i+" ");
			}
		}
		System.out.print(st);

	}





	public static void BFS()
	{
		Queue<AB> queue = new LinkedList<>();
		queue.add(new AB(0,0));
		visited[0][0]= true;
		check[now[2]]=true;
		while(!queue.isEmpty())
		{
			AB p = queue.poll();
			int A = p.A;
			int B = p.B;
			int C = now[2]-A-B;
			for(int k=0;k<6;k++) { //A-B, A-C , B-C,B-A,C-A,C-B
				int []next = {A,B,C};
				next[receive[k]]+=next[send[k]];
				next[send[k]]=0;
				if(next[receive[k]]>now[receive[k]])
				{
					next[send[k]]=next[receive[k]]-now[receive[k]];
					next[receive[k]]=now[receive[k]];
				}
				if(visited[next[0]][next[1]]==false)
				{
					visited[next[0]][next[1]]=true;
					queue.add(new AB(next[0],next[1]));
					if(next[0]==0)
					{
						check[next[2]]=true;
					}
				}
			}
		}
	}

	static class AB{
		int A;
		int B;
		public AB(int A,int B){
			this.A=A;
			this.B=B;
		}

	}
	static class Reader {
		final int SIZE = 1 << 13;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
			int n = 0;
			byte c;
			while ((c = read()) <= 32)
				;
			do
				n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			return n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}
