package segtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class back_1275 {
    static long[] arr;
    static long[] tree;

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
       tree = new long[treeSize(N)];

        buildTree(1,1,N);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int x  = Integer.parseInt(st.nextToken());
            int y  = Integer.parseInt(st.nextToken());
            if(x>y)
            {
                int temp = x;
                x=y;
                y=temp;
            }
            int a  = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());
            sb.append(sum(1,1,N,x,y)).append("\n");
            update(1,1,N,a,b-arr[a]);
            arr[a]=b;

        }
        System.out.println(sb);

    }

    static long buildTree(int node,int start, int end)
    {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        long left = buildTree(node * 2, start, mid);
        long right = buildTree(node * 2 + 1, mid + 1, end);
        return tree[node] = left+right;
    }

    static long sum(int node,int start, int end,long left,long right)
    {
        if(left>end || right<start)
        {
            return 0;
        }
        if (left<=start && end <=right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        long leftNode = sum(node * 2, start, mid,left,right);
        long rightNode = sum(node * 2 + 1, mid + 1, end,left,right);
        return leftNode+rightNode;
    }

    static int treeSize(int n)
    {
        int height = (int) Math.ceil(Math.log(n) / Math.log(2))+1;
        return (1 << (height + 1)) - 1;
    }

    static void update(int node,int start, int end, int target,long diff)
    {
        if(target < start || end < target) return;

        tree[node] +=diff;

        if(start != end)
        {   int mid = (start + end) / 2;
            update(node*2,start,mid,target,diff);
            update(node*2+1,mid+1,end,target,diff);
        }
    }
}