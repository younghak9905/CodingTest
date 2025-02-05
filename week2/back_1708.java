package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_1708 {
    static Point root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            points.add(new Point(x,y));
        }
        System.out.println(countPoint(points));
    }
    static int ccw(Point p1,Point p2,Point p3)
    {
        long result = (p2.x-p1.x)*(p3.y-p2.y)-(p2.y-p1.y)*(p3.x-p2.x);
        if(result >0) return 1;
        else if(result<0) return -1;
        else return 0;
    }
    static int countPoint(ArrayList<Point> points)
    {
        //������ ã�� (y���� ���� ���� �� , ���ٸ� x���� ���� ����
        for(int i=0;i<points.size();i++)
        {
            if(points.get(i).y<root.y)
            {
                root=points.get(i);
            }else if(points.get(i).y==root.y)
            {
                if (points.get(i).x < root.x) {
                    root = points.get(i);
                }
            }
        }
        points.sort(new Comparator<Point>() { //�������� �������� �ݽð� �������� ����
            @Override
            public int compare(Point o1, Point o2) {
                int result = ccw(root,o1,o2);
                if(result>0) return -1;
                else if(result<0) return 1;
                else {
                    long distance1 = dist(root,o1);
                    long distance2 = dist(root,o2);
                    if(distance1 > distance2) return 1; //�������� �ִٸ� ����� ��

                }
                return -1;
            }
        });
        Stack<Point> stack = new Stack<>();
        stack.add(root);//�ʱ� ���� ���� ���ÿ� �ֱ�

        for(int i=1;i<points.size();i++)
        {
            while (stack.size()>1 &&
                    (ccw(
                            stack.get(stack.size()-2), //�ʱ� 0
                            stack.get(stack.size()-1), //�ʱ� 1
                            points.get(i))<=0
                    )
            )
            {
                stack.pop();//�ݽð� ������ �ƴ϶�� ��������
            }
            stack.add(points.get(i));
        }
        return stack.size();
    }

    static long dist(Point p1,Point p2)
    {
        return (p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y);
    }
    static class Point
    {
        long x;
        long y;
        public Point(long x, long y)
        {
            this.x=x;
            this.y=y;
        }
    }

}
