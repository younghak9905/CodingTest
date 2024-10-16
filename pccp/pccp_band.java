package pccp;

public class pccp_band {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int t=bandage[0];
		int restore = bandage[1];
		int max = bandage[2];
		int h=health;
		int time = 0;
		int N=0;
		int last=attacks[attacks.length-1][0];
		int timeline[] = new int[last+1];
		for(int i=0;i<attacks.length;i++)
		{
			timeline[attacks[i][0]]+=attacks[i][1];
		}

		while(time<=last)
		{
			if(timeline[time]>0)
			{
				h-=timeline[time];
				N=0;
				if(h<=0)
				{
					return -1;
				}
			}
			else
			{
				N++;
				if(N==t)
				{
					h+=max;
					N=0;
				}
				h+=restore;

				if(h>health)
				{
					h=health;
				}
			}
			time++;
		}

		int answer = 0;
		return h;
	}

	public static void main(String[] args) {
		pccp_band sol = new pccp_band();
		//[5, 1, 5]
		int[] bandage = {5, 1, 5};

		int health = 30;
		//[[2, 10], [9, 15], [10, 5], [11, 5]]
		int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
		int ret = sol.solution(bandage, health, attacks);
		System.out.println(ret);
	}
}
