package pccp;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class pccp_blackwater {
	static int []dx= {0,0,1,-1};
	static int []dy= {1,-1,0,0};
	public int solution(int[][] land) {
		int r = land.length;
		int c = land[0].length;
		int []cnt = new int[c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(land[i][j]==0)
					continue;

				Set<Integer> candidates = new HashSet<>();
				Queue<int[]> q = new ArrayDeque<>();
				q.add(new int[] {i,j});
				int area=1;
				candidates.add(j);
				while(!q.isEmpty())
				{
					int []cur = q.poll();
					int cr=cur[0];
					int cc=cur[1];
					land[cr][cc]=0;
					for(int k=0;k<4;k++){
							int nr = cr+dy[k];
							int nc = cc+dx[k];
							if (nr<0||nr>=r||nc<0||nc>=c||land[nr][nc]==0) continue;

							area++;
							land[nr][nc] = 0;
							candidates.add(nc);
							q.add(new int[]{nr, nc});
					}
				}
				for(int candidate:candidates)
				{
					cnt[candidate]+=area;
				}

			}
		}
		int max = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max) max = cnt[i];
		}
		return max;
	}

	public static void main(String[] args) {
		pccp_blackwater sol = new pccp_blackwater();
		//[[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]
		int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
		int ret = sol.solution(land);
		System.out.println(ret);
	}
}
