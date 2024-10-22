import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class back_1148 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = " ";
		int [][]arr = new int[200000][27];
		int n=0;
		while(true)
		{
				s=br.readLine();
				if(s.equals("-"))
					break;
				for(int i=0;i<s.length();i++) {
				arr[n][s.charAt(i)-'A']++;
			    }
				n++;

		}

		while(true)
		{	StringBuilder sb = new StringBuilder();
			s=br.readLine();
			int []board = new int[26];
			int []result= new int[26];
			if(s.equals("#"))
				break;
			for(int i=0;i<s.length();i++)
			{
				board[s.charAt(i)-'A']++;
			}
			for(int i=0;i<n;i++)
			{
				if(!check(board,arr[i])) continue;
				for(int j=0;j<26;j++)
				{
					if(arr[i][j]!=0)
					{
						result[j]++;
					}
				}
			}
			int min=200000+1;
			int max=0;
			for(int i=0;i<26;i++)
			{
				if(board[i]==0) continue;
				if(result[i]>max)
					max=result[i];
				if(result[i]<min && board[i]!=0)
					min=result[i];
			}

			for(int i=0;i<26;i++)
			{
				if(board[i]!=0 && result[i]==min)
				{
					sb.append((char)(i+'A'));
				}
			}
			sb.append(" "+min+" ");
			for(int i=0;i<26;i++)
			{
				if(board[i]!=0 && result[i]==max)
				{
					sb.append((char)(i+'A'));
				}
			}
			sb.append(" "+max+"\n");
			System.out.print(sb);
		}

	}
	static boolean check(int []result, int []arr)
	{
		for(int i=0;i<26;i++)
		{
			if(arr[i]>result[i])
				return false;
		}
		return true;
	}

}
