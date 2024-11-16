package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1873 {
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static char[]tank={'^','v','<','>'};
    static int x,y,dir;
    static int sx,sy,sdir;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //  Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringTokenizer st;


        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
             dir=0;
             x = 0;
             y=0;
            for(int i=0;i<H;i++)
            {   String s = br.readLine();
                for(int j=0;j<W;j++)
                {
                    map[i][j]=s.charAt(j);

                    if(s.charAt(j)=='^')
                    {
                        x=i;
                        y=j;
                        dir=0;
                    }else if(s.charAt(j)=='v')
                    {
                        x=i;
                        y=j;
                        dir=1;
                    }
                    else if(s.charAt(j)=='<')
                    {
                        x=i;
                        y=j;
                        dir=2;
                    }
                    else if(s.charAt(j)=='>')
                    {
                        x=i;
                        y=j;
                        dir=3;
                    }
                }
            }
            int size = Integer.parseInt(br.readLine());
            String s = br.readLine();
            for(int j=0;j<size;j++)
            {
                int nx = x;
                int ny = y;
                if(s.charAt(j)=='S')
                {
                    sx=x;
                    sy=y;
                    while(true)
                    {

                        sx+=dx[dir];
                        sy+=dy[dir];
                        if(sx<0 || sx>H-1 || sy<0 || sy>W-1) break;
                        if(map[sx][sy]=='*')
                        {
                            map[sx][sy]='.';
                            break;
                        }
                        if(map[sx][sy]=='#')
                        {
                            break;
                        }
                    }
                }
                else {
                    if (s.charAt(j) == 'U')  dir = 0;
                    else if (s.charAt(j) == 'D') dir = 1;
                    else if (s.charAt(j) == 'L')dir = 2;
                    else if (s.charAt(j) == 'R') dir = 3;
                    nx=x+dx[dir];
                    ny=y+dy[dir];
                    map[x][y]=tank[dir];
                    if (nx < 0 || ny < 0 || nx > H - 1 || ny > W - 1) continue;
                    if (map[nx][ny]=='.')
                    {
                        map[x][y]='.';
                        map[nx][ny]=tank[dir];
                        x=nx;
                        y=ny;

                    }
                }
            }
            for(int i=0;i<H;i++)
            {
                for(int j=0;j<W;j++)
                {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);


    }

}

