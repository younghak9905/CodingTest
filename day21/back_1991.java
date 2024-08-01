package day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class back_1991 {
	static int[][] tree;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {

		sb=new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		tree = new int[26][2];
		for(int i=0;i<N;i++)
		{	// st = new StringTokenizer(br.readLine());
			String[] temp = sc.nextLine().split(" ");
			int node=temp[0].charAt(0)-'A';
			char left = temp[1].charAt(0);
			char right = temp[2].charAt(0);
			if(left=='.'){
				tree[node][0]=-1;
			}else {
				tree[node][0]=left-'A';
			}
			if(right=='.'){
				tree[node][1]=-1;
			}else {
				tree[node][1]=right-'A';
			}
		}
		preOrder(0);
		//sb.append("\n");
		System.out.println();
		inOrder(0);
		//sb.append("\n");
		System.out.println();
		postOrder(0);
		//sb.append("\n");
		System.out.println();


	}
	public static void preOrder(int i)
	{
		if(i==-1)
			return;
		System.out.print((char)(i+'A'));
		//sb.append((char)(i+'A'));
		preOrder(tree[i][0]);
		preOrder(tree[i][1]);
	}
	public static void inOrder(int i)
	{
		if(i==-1)
			return;
		inOrder(tree[i][0]);
		System.out.print((char)(i+'A'));
		//sb.append((char)(i+'A'));
		inOrder(tree[i][1]);

	}
	public static void postOrder(int i)
	{
		if(i==-1)
			return;
		postOrder(tree[i][0]);
		postOrder(tree[i][1]);
		//sb.append((char)(i+'A'));
		System.out.print((char)(i+'A'));
	}
}
