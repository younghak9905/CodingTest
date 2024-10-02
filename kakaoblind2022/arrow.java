package kakaoblind2022;

import java.awt.print.Pageable;
import java.util.ArrayList;

public class arrow {
	static int N;

	static int []lion;
	static int []apeach;

	static int max=0;
	static ArrayList<int[]> list = new ArrayList<>();
	public int[] solution(int n, int[] info) {
		int[] answer = {};
		lion=new int[11];
		apeach=info;
		N=n;
		int apeachScore=0;
		for(int i = 0; i < 11; i++) {
			if (info[i] > 0) { apeachScore += (10-i); }
		}
		max-=apeachScore;
		permutation(0,n,max);
		if(max<=0)
			answer = new int[]{-1};
		else {
			for(int i=0;i<=10;i++)
			{
				if(list.size()==1)
				{
					break;
				}

				int maxCount=0;
				for(int[] lion : list)
				{
					maxCount = Math.max(lion[10-i], maxCount);
				}
				int c=0;
				while (c<list.size())
				{
					if(list.get(c)[10-i]!=maxCount)
					{
						list.remove(c);
					}
					else
					{
						c++;
					}
				}
			}

			answer = list.get(0);
		}

		return answer;
	}

	static void permutation(int cnt,int n,int nowPoint)
	{

		if(n==0)
		{
		  if(nowPoint>max) {
			  max = nowPoint;
			  list = new ArrayList<>();
			  list.add(lion.clone());
		  }else if(nowPoint==max) {
			  list.add(lion.clone());
		  }
		}else if(n>=0 && cnt<11)
		{
			for(int i=0;i<=apeach[cnt]+1;i++)
			{
				lion[cnt]+=i;
				int nextPoint = nowPoint;
				if(lion[cnt]>apeach[cnt])
				{
					if (apeach[cnt] == 0)
						nextPoint += (10 - cnt);
					else if(apeach[cnt] > 0) {
						nextPoint += (10 - cnt)*2;
					}
				}

				permutation(cnt+1,n-i,nextPoint);
				lion[cnt]-=i;
			}
		}


	}
	public static void main(String[] args) {
		arrow arrow = new arrow();
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		int []result=arrow.solution(n, info);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
}
