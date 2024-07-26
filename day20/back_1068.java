package day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_1068 {
	static ArrayList<Integer> tree[];
	static boolean visited[];
	static int parent[];
	static int D,leaf,root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<N;i++)
		{
			tree[i]=new ArrayList<>();
			parent[i]=-1;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			int temp = Integer.parseInt(st.nextToken());
			if(temp!=-1)
			{
				tree[i].add(temp);
				tree[temp].add(i);
			}else{
				root = i;
			}
		}
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		leaf=0;
		if(D==root) {
			System.out.println(0);
		}else {
			DFS(root);
			System.out.println(leaf);
		}

	}
	static void DFS(int v)
	{

		visited[v]=true;
		int cNode =0; //자식 노드의 개수
		for(int i : tree[v])
		{
			if(D!=i && visited[i]==false)
			{
				cNode++;
				DFS(i);
			}
		}
		if(cNode==0) //자식 노드가 없다면 리프 노드이다.
		{
			leaf++;
		}
	}
}
