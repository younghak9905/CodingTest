package KaistHajeOpenContest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class back_32353 {
	static int []x={0,1,0,-1};
	static int []y={-1,0,1,0};
	static int [][]map;
	static int [][]visited;
	static int [][]apple;
	static int score,N,M,count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int r1= Integer.parseInt(st.nextToken());
		int c1= Integer.parseInt(st.nextToken());
		int r2= Integer.parseInt(st.nextToken());
		int c2= Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		visited=new int[N+1][M+1];
		visited[r1][c1]=1;
		visited[r2][c2]=1;
		for(int i=1;i<=N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int K=Integer.parseInt(st.nextToken());

		apple = new int[N+1][M+1];
		for(int i=0;i<K;i++)
		{
			st = new StringTokenizer(br.readLine());
			int ay=Integer.parseInt(st.nextToken());
			int ax=Integer.parseInt(st.nextToken());
			apple[ay][ax]=1;
		}

		score=0;
		count=N*M*2;
		snake(r1,c1,r2,c2);
		System.out.println(score);

	}

	static void snake(int r1,int c1,int r2,int c2)
	{  int MAX=2;
		Deque<body> deque = new LinkedList<>(); //snake deque로 구현
		deque.addFirst(new body(r1,c1)); //머리 추가
		deque.addLast(new body(r2,c2));//꼬리 추가
		body head=deque.peekFirst();
		body tail=deque.peekLast();
		int startx=head.x-tail.x; //초기 방향 확인
		int starty=head.y-tail.y;
		while(true){
			int wayx=x[map[head.y][head.x]]; //현재 방향
			int wayy=y[map[head.y][head.x]];
			if(startx!=0&&wayx!=0) //둘의 방향 벡터가 둘 다 0이 아니면 (정 반대의 가능성)
			{
				if((startx-wayx)!=0)  //원래 방향과 현재 방향이 다르면 원래 방향으로 변경
					wayx=startx;
			}
			else if(starty!=0&&wayy!=0)
			{
				if((starty-wayy)!=0)
					wayy=starty;
			}
			int nowX=head.x;
			int nowY=head.y;
			nowX+=wayx; //현재 방향으로 이동
			nowY+=wayy;
			if(!isOver(nowX,nowY)) //범위를 벗어나면 break
				break;
			if(apple[nowY][nowX]!=0) //사과가 있으면
				apple[nowY][nowX]--; //사과 없애기
			else
			{
				visited[tail.y][tail.x]=0; //꼬리 이동
				deque.removeLast(); //꼬리 삭제
				tail=deque.peekLast();
			}
			if(visited[nowY][nowX]==1) //이미 방문한 곳이면 break
				break;
			visited[nowY][nowX]=1;
			startx=nowX-head.x; //원래 방향 재 설정
			starty=nowY-head.y;

			deque.addFirst(new body(nowY,nowX));  //머리 추가
			head=deque.peekFirst(); //머리 갱신
			if(MAX<deque.size()) //최대 길이 갱신
			{
				MAX=deque.size();
				count=N*M*2;
			}else{ //루프를 돌고 있지는 않은지 확인
				if(count--<0)
					break;
			}
		}
		score=MAX;

	}
	static boolean isOver(int nowX,int nowY)
	{
		if(1>nowX || M<nowX)
			return false;
		if(1>nowY || N<nowY)
			return false;
		return true;

	}
	static class body
	{
		int x;
		int y;
		public body(int r,int c){
			this.x=c;
			this.y=r;
		}
	}
}



