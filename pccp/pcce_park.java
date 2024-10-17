package pccp;

import java.util.Arrays;

public class pcce_park {
    static String[][] parks;
    static int [] mat;
    static int mx,my;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        mx=park[0].length;
        my=park.length;
        parks=park;
        mat=mats;
        Arrays.sort(mat);
        int max =-1;
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length; j++){
                if(park[i][j].equals("-1")){
                    for(int k=0; k<mats.length; k++){
                        int a = isImposible(k,i,j);
                        if(a>0){
                                if(max<a){
                                    max=a;
                                }
                            }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        if(max==0)
        {
            return -1;
        }

        return max;
    }
    static int isImposible(int i,int x, int y)
    {

            if(x>=0 && y>0 && x<=mx-mat[i] && y<=my-mat[i])
            {
               for(int j=y;j<y+mat[i];j++)
               {
                     for(int k=x;k<x+mat[i];k++)
                     {
                          if(!parks[j][k].equals("-1"))
                          {
                            return 0;
                          }
                     }
               }
               return mat[i];
            }



        return 0;
    }


    public static void main(String[] args) {
        pcce_park sol = new pcce_park();
        //[5,3,2]
        int[] mats = {1,2};
        // [["-1", "-1", "-1"], ["-1", "-1", "-1"], ["-1", "-1", "A"]]
       String[][] park = {{"A","-1"},{"A","-1"}};
        int ret = sol.solution(mats, park);
        System.out.println(ret);
    }
}
