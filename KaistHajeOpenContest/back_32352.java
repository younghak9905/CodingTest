package KaistHajeOpenContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_32352 {
	static long axl,axh,ayl,ayh,azl,azh;
	static long bxl,bxh,byl,byh,bzl,bzh;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		axl = Long.parseLong(st.nextToken());
		axh = Long.parseLong(st.nextToken());
		ayl = Long.parseLong(st.nextToken());
		ayh = Long.parseLong(st.nextToken());
		azl = Long.parseLong(st.nextToken());
		azh = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		bxl = Long.parseLong(st.nextToken());
		bxh = Long.parseLong(st.nextToken());
		byl = Long.parseLong(st.nextToken());
		byh = Long.parseLong(st.nextToken());
		bzl = Long.parseLong(st.nextToken());
		bzh = Long.parseLong(st.nextToken());
		if(!isMatch())
		{
			System.out.println(-1);
			return ;
		}

		int count = 0;
		while(bzl<azl)
		{
			if(!isMatch())
			{
				System.out.println(-1);
				return ;
			}
			if((bzl<=azh && bzh>=azh) || (bzl<=azl && bzh>=azh))
			{
				System.out.println(count);
				return;
			}
			azl--;
			azh--;
			count++;
		}

	}

	static public boolean isMatch()
	{
		if(bxl>=axh || bxh <=axl)
			return false;
		if(byl>=ayh || byh <=ayl)
			return false;
		if(bzl>=azl)
			return false;
		return true;

	}
}
