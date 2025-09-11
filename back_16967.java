import java.io.BufferedReader;
import java.util.StringTokenizer;

public class back_16967 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int B[][] = new int[H+X][W+Y];
		int A[][] = new int[H+1][W+1];
		for(int i=0;i<H+X;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W+Y;j++)
			{
				B[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int i=0;
		while(i+X<H)
		{
			for(int j=i;j<i+X;j++)
			{
				for(int k=0;k<W;k++)
				{
					A[j][k]=B[j][k];
				}
			}
			for(int j=i;j<i+X;j++)
			{
				for(int k=0;k<W;k++)
				{
					B[j+X][k+Y]-=A[j][k];
				}
			}
			i+=X;
		}

		for(int j=i;j<H;j++)
		{
			for(int k=0;k<W;k++)
			{
				A[j][k]=B[j][k];
			}
		}


		for(int j=0;j<H;j++)
		{
			for(int k=0;k<W;k++)
			{
				System.out.print(A[j][k]+" ");
			}
			System.out.println();
		}

	}
}
