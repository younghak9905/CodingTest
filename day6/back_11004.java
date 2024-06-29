package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int []A=new int[N];
        for(int i=0;i<N;i++)
        {
            A[i]=Integer.parseInt(st.nextToken());
        }
        quickSort(A,0,N-1,K-1);
        System.out.print(A[K-1]);

    }
    public static void quickSort(int[] A,int start,int end,int k)
    {
       if(start<end)
       {
           int pivot = partition(A,start,end);
           if(pivot==k)
               return;
           else if(k<pivot)
               quickSort(A,start,pivot-1,k);
           else
               quickSort(A,pivot+1,end,k);
       }


    }
    public static int partition(int[] A, int start,int end)
    {
        if(start+1==end)
        {
            if(A[start]>A[end]) swap(A,start,end);
            return end;
        }

        int M = (start + end)/2; //중간을 pivot으로 설정하고
        swap(A,start,M); //반복문 사용을 용이하게 하기 위해 start와 M 스왑
        int pivot = A[start];
        int i = start +1, j=end; //pivot 앞을 시작지점으로 하고 정렬 시작
        while(i<=j)
        {
            while(j>=start+1 && pivot <A[j])  //pivot 값 보다 end 값이 크다면 왼쪽으로 이동
                j--;
            while (i<=end && pivot>A[i])//pivot 값 보다 start 값이 크다면 오른쪽으로 이동
                i++;
            if(i<=j)
            {
                swap(A,i++,j--); //이동을 멈추고 둘을 스왑
            }

        } //pivot 데이터를 나눠진 두 그룹의 경계 index에 저장
        A[start]=A[j];
        A[j]=pivot;
        return j;

    }
    public static void swap(int[] A, int i,int j)
    {
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
