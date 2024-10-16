public class pccp_puzzle {
    public int solution(int[] diffs, int[] times, long limit) {

            long left=1;
            long right=limit;


            while(left<right)
            {
                long mid = (left+right)/2;
                if(isImposible(diffs,times,mid,limit)) {
                    left = mid+1;
                }
                else {
                    right = mid;
                }
            }
            return (int)left;
    }
    static boolean isImposible(int[] diffs, int[] times, long mid, long limit)
    {
        long time = (long)times[0];
        for(int i=1;i<diffs.length;i++)
        {
           if(diffs[i]>mid)
           {
               time+=((long)diffs[i]-mid)* ((long)times[i]+(long)times[i-1]);
           }
           time+=(long)times[i];
        }
        return limit<time;
    }





    public static void main(String[] args) {
        pccp_puzzle sol = new pccp_puzzle();
        //[1, 328, 467, 209, 54]
        int[] diffs = {1,1,1,1,1};
        //[2, 7, 1, 4, 3]
        int[] times = {2, 7,1,4,3};
        long limit = 1723;
        int ret = sol.solution(diffs, times, limit);
        System.out.println(ret);
    }
}
